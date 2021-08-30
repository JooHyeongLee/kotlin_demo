package util;

import data.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SampleParser {
    static final Logger logger = LoggerFactory.getLogger("SampleParser");
    // File file = new File("src/main/resources/sample.xml");
    File file = new File("src/main/resources/sample.gpx");

    // 파싱 함수
    public void parse() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SampleHandler handler = new SampleHandler();
            List<HashMap<String, Float>> list = handler.getPointList();
            // xml parsing
            saxParser.parse(file, handler);


           // List<Sample> list = handler.getSampleList();
           //  list.forEach(latLon->{
           //      logger.info("lat - {}, lon - {}", latLon.get("lat"), latLon.get("lon"));
           //  });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
