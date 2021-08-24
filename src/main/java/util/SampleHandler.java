package util;

import data.Sample;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SampleHandler extends DefaultHandler {

    public static List<Sample> sampleList;
    private Sample sample;
    private String str;


    public SampleHandler() {
        sampleList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // 시작태그를 만났을 때
        System.out.println(qName);
        if(qName.equals("company")) {

            sample = new Sample();
            sampleList.add(sample);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals("employee")) {
            sample.setEmployee(str);
        } else if(qName.equals("firstname")) {
            sample.setFirstname(str);
        } else if(qName.equals("lastname")) {
            sample.setLastname(str);
        } else if(qName.equals("salary")) {
            sample.setSalary(Integer.parseInt(str));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //태그와 태그 사이의 내용을 처리
        str = new String(ch,start,length);
    }

    public List<Sample> getSampleList() {
        return sampleList;
    }
}
