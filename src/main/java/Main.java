import util.SampleParser;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public void hashMapTest() {
        HashMap<String,Integer> hm1 = new HashMap<>();
        for(int i=0; i<30; i++) {
            hm1.put("Hello"+i, i);
        }

        hm1.forEach((key, value)-> {
            System.out.printf("key: %s, value: %s \n", key, value);
        });
    }

    public void parserTest() {
        SampleParser sampleParser = new SampleParser();
        sampleParser.parse();
    }
}
