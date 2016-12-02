package com.bjut.soft.rule;

import com.bjut.soft.pathParser.ASTPath;
import com.bjut.soft.pathParser.QueryParser;
import org.junit.Test;

/**
 * Created by toy on 29/11/2016.
 */
public class RuleTest {
    @Test
    public void testRule() {
        QueryParser parser = new QueryParser();
        ASTPath path = parser.parseXPath("//a[b[//c]][//d]/e[f]");
        RuleFactory factory = RuleFactory.getRulesFactory();
        factory.genRules(path);
        System.out.println("done");
    }
}
