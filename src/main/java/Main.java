import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.SampleParser;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.HashMap;
import java.util.Map;


public class Main implements Runnable{
    static final Logger logger = LoggerFactory.getLogger(Main.class);
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
        // 작업 큐 생성
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(9);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,3,3, TimeUnit.SECONDS, queue);
        ExecutorService service = Executors.newFixedThreadPool(5);

        // Future<Integer> test = service.submit(()->{
        //     int a = 0;
        //     for(int i=0; i<10; i++) {
        //         this.run();
        //         Thread.sleep(1000);
        //         a++;
        //     }
        //     return a;
        // });
        // service.shutdown();
        // return test;

        for(int i=0; i<10; i++) {
            // logger.info("create thread pool count : {}", threadPoolExecutor.getActiveCount());
            // threadPoolExecutor.execute(this::run);
            try {
                Thread.sleep(1000);
                threadPoolExecutor.execute(()->{
                    this.run();
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadPoolExecutor.shutdown();
    }

    @Override
    public void run() {
        SampleParser sampleParser = new SampleParser();
        sampleParser.parse();
    }
}
