package com.bjut.soft.query;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by toy on 29/11/2016.
 */
public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String cur = System.getProperty("user.dir");
        System.out.println(cur);


        String filePath = "test-case/xmark_20.xml";
        String xPath = "//open_auction/bidder/time";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        File f = new File(filePath);
        SaxParser dh = new SaxParser(xPath);
        parser.parse(f, dh);
    }
}
