package util;

import data.Gpx;
import data.Sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SampleHandler extends DefaultHandler {

    static final Logger logger = LoggerFactory.getLogger(SampleHandler.class);
    private Gpx gpx;

    public static List<Sample> sampleList;
    private Sample sample;
    private String str;
    public static List<HashMap<String, Float>> pointList = new ArrayList<>();


    public SampleHandler() {
        sampleList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // 시작태그를 만났을 때
//        sample = new Sample();
        if(qName.equals("gpx")) {
//            sampleList.add(sample);
        } else if(qName.equals("trkpt")) {
            HashMap<String, Float> hashMap = new HashMap<>();
            hashMap.put("lat", Float.parseFloat(attributes.getValue("lat")));
            hashMap.put("lon", Float.parseFloat(attributes.getValue("lon")));
            pointList.add(hashMap);

//            logger.info("lat - {}, lon - {}", attributes.getValue("lat"), attributes.getValue("lon"));
//            sample.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if(qName.equals("employee")) {
//            sample.setEmployee(str);
//        } else if(qName.equals("firstname")) {
//            sample.setFirstname(str);
//        } else if(qName.equals("lastname")) {
//            sample.setLastname(str);
//        } else if(qName.equals("salary")) {
//            sample.setSalary(Integer.parseInt(str));
//        }
//        if(qName.equals("employee")) {
//            sample.setEmployee(str);
//        } else if(qName.equals("firstname")) {
//            sample.setFirstname(str);
//        } else if(qName.equals("lastname")) {
//            sample.setLastname(str);
//        } else if(qName.equals("salary")) {
//            sample.setSalary(Integer.parseInt(str));
//        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //태그와 태그 사이의 내용을 처리
        str = new String(ch,start,length);
    }

    public List<Sample> getSampleList() {
        return sampleList;
    }

    public List<HashMap<String, Float>> getPointList() {
        return pointList;
    }
}
