package com.bjut.soft.query;

import com.bjut.soft.graph.INode;
import com.bjut.soft.pathParser.ASTPath;
import com.bjut.soft.pathParser.QueryParser;
import com.bjut.soft.rule.RuleFactory;
import com.bjut.soft.utils.TagUtils;
import com.sun.tools.javac.tree.JCTree;
import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;


/**
 * Created by toy on 01/12/2016.
 */
public class SaxParser extends DefaultHandler {
    private RuleFactory factory;
    private int layer = 0;
    private Queue<INode> entryList;
    private long time = 0L;
    private long start = 0L;
    private long middle = 0L;
    private long end = 0L;
    private Queue<INode> listNew = new ArrayDeque<>(100);
    //private TagUtils record;
    public SaxParser(String xPath) {
        super();
        QueryParser parser = new QueryParser();
        ASTPath path = parser.parseXPath(xPath);
        factory = RuleFactory.getRulesFactory();
        factory.genRules(path);
        layer = 0;
    }
    public long getTestTime() {
        return time;
    }

    public SaxParser() {
        super();
    }

    @Override
    public void startDocument() throws org.xml.sax.SAXException {
        super.startDocument();
        start = 0;
        end = 0;
        time = 0;
        layer = 0;
        entryList = factory.initNodes();
        //record = TagUtils.getPath();
        System.out.println("=================== START DOC ====================");
    }

    @Override
    public void endDocument() throws org.xml.sax.SAXException {
        //super.endDocument();
        System.out.println("=================== END  DOC ====================");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {

        Queue<INode> tmp;
        listNew.clear();
        //record.addToPath(qName);

        start = System.currentTimeMillis();
        middle = System.currentTimeMillis();
        for (INode each: entryList) {
            factory.doStartTag(listNew, each, qName, layer);
        }
        end = System.currentTimeMillis();
        time += (end - start) - (middle-start);

        tmp = entryList;
        entryList = listNew;
        listNew = tmp;
        ++layer;
        //super.startElement(uri, localName, qName, attributes);

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {

        Queue<INode> tmp;
        listNew.clear();

        start = System.currentTimeMillis();
        middle = System.currentTimeMillis();
        for (INode each: entryList) {
            factory.doEndTag(listNew, each, qName, layer);
        }
        end = System.currentTimeMillis();
        time += (end - start) - (middle-start);

        --layer;
        //record.removeToPath();
        tmp = entryList;
        entryList = listNew;
        listNew = tmp;
        super.endElement(uri, localName, qName);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        super.characters(ch, start, length);
    }


}
