package com.bjut.soft.query;

import com.bjut.soft.graph.INode;
import com.bjut.soft.pathParser.ASTPath;
import com.bjut.soft.pathParser.QueryParser;
import com.bjut.soft.rule.RuleFactory;
import jdk.internal.org.xml.sax.Attributes;
import jdk.internal.org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by toy on 01/12/2016.
 */
public class SaxParser extends DefaultHandler {
    private RuleFactory factory;
    private int layer = 0;
    private List<INode> entryList;
    public SaxParser(String xPath) {
        super();
        QueryParser parser = new QueryParser();
        ASTPath path = parser.parseXPath(xPath);
        factory = RuleFactory.getRulesFactory();
        factory.genRules(path);
        layer = 0;
        entryList = factory.initNodes();
    }

    public SaxParser() {
        super();
    }

    @Override
    public void startDocument() throws org.xml.sax.SAXException {
        super.startDocument();
        System.out.println("=================== START DOC ====================");
    }

    @Override
    public void endDocument() throws org.xml.sax.SAXException {
        super.endDocument();
        System.out.println("=================== END  DOC ====================");
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws org.xml.sax.SAXException {
        List<INode> listNew = new ArrayList<>();
        for (INode each: entryList) {
            factory.doStartTag(listNew, each, qName, layer);
        }
        entryList = listNew;
        ++layer;
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {
        List<INode> listNew = new ArrayList<>();
        for (INode each: entryList) {
            factory.doEndTag(listNew, each, qName, layer);
        }
        --layer;
        entryList = listNew;
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
        super.characters(ch, start, length);
    }


}
