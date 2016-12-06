package com.bjut.soft.rule;


import com.bjut.soft.graph.INode;
import com.bjut.soft.graph.Node;
import com.bjut.soft.pathParser.ASTPath;
import com.bjut.soft.pathParser.ASTPreds;
import com.bjut.soft.pathParser.AxisType;
import com.bjut.soft.rule.ruleImpl.*;
import com.bjut.soft.rule.ruleImpl.RuleT1_1;

import java.util.*;

/**
 * Created by toy on 28/11/2016.
 */
public class RuleFactory {
    private static final RuleFactory instance = new RuleFactory();
    private final Map<Integer, IRule> rules = new HashMap<>();
    private int ruleIndex = 0;
    private RuleFactory() {
        rules.put(-2, RuleOutput.getRule());
    }

    public Queue<INode> initNodes() {
        IRule rule = rules.get(0);
        ruleIndex = 0;
        Queue<INode> list = new ArrayDeque<>(1);
        INode node = rule.productNode(0, Node.nil,  Node.nil, 0, list);
        list.add(node);
        return list;
    }
    public static Map<Integer, IRule> getRules() {return instance.rules;}

    public static RuleFactory getRulesFactory() {
        return instance;
    }

    public void genRules(ASTPath path) {
        mapRules(path, ruleIndex, ruleIndex);
    }

    /*
     * @param path: XPath
     * @param orgIndex: previous index of rule
     * @param curIndex: index of current handled rule
     */
    private void mapRules(ASTPath path, int orgIndex, int curIndex) {
        IRule rule;

        if (path == null || path == ASTPath.nil) {
            return;
        }
        int nextIndex = ++ruleIndex;
        ASTPreds nextPreds = path.getFirstStep().getPreds();
        ASTPath nextPath = path.getRemainderPath();
        String name = path.getFirstStep().getNodeTest().getTag();

        if (path.getRemainderPath() == ASTPath.nil) {
            if (path.getFirstStep().getAxisType() == AxisType.PC) {
                rule = RuleT1_1.getRule(name, orgIndex, nextIndex, -1);
            } else {
                rule = RuleT1_2.getRule(name, orgIndex, nextIndex, -1);
            }
        } else {
            int pathIndex = ++ruleIndex;
            if (path.getFirstStep().getAxisType() == AxisType.PC) {
                rule = RuleT1_3.getRule(name, orgIndex, nextIndex, pathIndex);
                mapRules(nextPath, curIndex, pathIndex);
            } else {
                rule = RuleT1_4.getRule(name, orgIndex, nextIndex, pathIndex);
                mapRules(nextPath, curIndex, pathIndex);
            }
        }
        rules.put(curIndex, rule);
        mapRules(nextPreds, curIndex, nextIndex);


    }

    /*
     * overwrite mapRules
     * @param preds: predicates
     * @param orgIndex: previous index of rule
     * @param curIndex: index of current handled rule
     * pathIndex: index of nextIndex
    */
    private void mapRules(ASTPreds preds, int orgIndex, int curIndex) {
        IRule rule;

        if (preds == null || preds == ASTPreds.nil) {
            rule = RuleT2_1.getRule(orgIndex);
        } else {
            int nextIndex = ++ruleIndex;
            ASTPreds nextInnerPreds = preds.getFirstStep().getPreds();
            ASTPreds nextPreds = preds.getRemainderPreds();
            String name = preds.getFirstStep().getNodeTest().getTag();
            int predIndex = ++ruleIndex;

            if (preds.getRemainderPreds() == ASTPreds.nil) {
                int orgY1 = rules.get(orgIndex).getY1();
                if (preds.getFirstStep().getAxisType() == AxisType.PC) {
                    rule = RuleT3_1.getRule(name, orgY1, orgIndex, nextIndex, predIndex);
                } else {
                    rule = RuleT3_2.getRule(name, orgY1, orgIndex, nextIndex, predIndex);
                }
                mapRules(nextInnerPreds, curIndex, nextIndex);
                mapRules(nextPreds, curIndex, predIndex);
            } else {
                rule = RuleT2_2.getRule(name, orgIndex, curIndex, nextIndex, predIndex);
                mapRuleT2_2(preds, orgIndex, nextIndex, predIndex);
            }
        }
        rules.put(curIndex, rule);
    }

    private void mapRuleT2_2(ASTPreds preds, int orgIndex, int curIndex, int predIndex) {
        if (preds == null || preds == ASTPreds.nil) {
            return;
        }
        int nextIndex = ++ruleIndex;
        IRule rule;
        ASTPreds nextInnerPreds = preds.getFirstStep().getPreds();
        ASTPreds nextPreds = preds.getRemainderPreds();
        String name = preds.getFirstStep().getNodeTest().getTag();
        int orgY1 = rules.get(orgIndex).getY1();
        if (preds.getFirstStep().getAxisType() == AxisType.PC) {
            rule = RuleT3_1.getRule(name, orgY1, orgIndex, nextIndex, -1);
        } else {
            rule = RuleT3_2.getRule(name, orgY1, orgIndex, nextIndex, -1);
        }
        rules.put(curIndex, rule);
        mapRules(nextInnerPreds, curIndex, nextIndex);
        mapRules(nextPreds, curIndex, predIndex);
    }

    public void doStartTag(Queue<INode> list, INode node, String tagName, int layer) {
        if (node.getLayer() < layer) {
            list.add(node);
        } else if (node.getLayer() == layer) {
            selectTag(list, node, tagName);
        } else {
            System.out.println("node.layer > layer");
        }
    }

    public void doEndTag(Queue<INode> list, INode node, String tagName, int layer) {
        if (node.getLayer() < layer) {
            list.add(node);
        } else if (node.getLayer() == layer) {
            IRule rule = rules.get(node.getType());
            rule.genBacktrackNodes(list, node);
        }
    }

    private void selectTag(Queue<INode> list, INode node, String tagName) {
        IRule rule = rules.get(node.getType());
        IRule q1 = rules.get(rule.getQ1());
        IRule q2 = rules.get(rule.getQ2());
        if (node.getTagName().equals(tagName)) {
            rule.genMatchedNodes(list, node, q1, q2, tagName);
        } else {
            rule.genOtherNodes(list, node, q1, q2, tagName);
        }
    }


}
