package util;

import data.Sample;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class SampleParser{
    File file = new File("src/main/resources/sample.xml");

    public void parse() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SampleHandler handler = new SampleHandler();
            saxParser.parse(file, handler);

            List<Sample> list = handler.getSampleList();
            for(Sample s : list) {
                System.out.println(s.toString());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
