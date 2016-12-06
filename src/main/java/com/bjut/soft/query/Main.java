package com.bjut.soft.query;

import com.bjut.soft.rule.RuleFactory;
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
    private File file;
    private SaxParser dh;
    private SAXParser parser;

    public void initApp(String filePath, String xPath) {
        file = new File(filePath);
        dh = new SaxParser(xPath);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
    public void runApp(boolean isWarmup) {
        int nLoop = 0;
        try {
            for (int i = 0; i < nLoop; ++i) {
                parser.parse(file, dh);
            }
            if (!isWarmup) {
                parser.parse(file, dh);
                System.out.println(dh.getTestTime());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Main obj = new Main();
        String filePath = "test-case/xmark_20.xml";
        String xPath = "//open_auction/bidder/time";
        obj.initApp(filePath, xPath);
        obj.runApp(true);
        obj.runApp(false);


    }
}
