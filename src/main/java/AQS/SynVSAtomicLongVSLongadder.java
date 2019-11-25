package AQS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ma
 * @version 1.0 {2019/11/25}
 */
public class SynVSAtomicLongVSLongadder {
    static Long count = 0L;
    static AtomicLong count2 = new AtomicLong(0L);
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws  InterruptedException{

        Thread[] ts = new Thread[1000];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count2.incrementAndGet();
                }

            });
        }
        long start = System.currentTimeMillis();
        for(Thread t : ts)t.start();
        for(Thread t : ts)t.join();
        long end = System.currentTimeMillis();
        System.out.println("Atomic:" + (end-start));


        for (int i = 0; i < ts.length; i++) {
            ts[i] = new Thread(()->{
                for (int j = 0; j < 100000; j++) {
                    count3.increment();
                }
            });
        }

        long start2 = System.currentTimeMillis();
        for(Thread t : ts)t.start();
        for(Thread t : ts)t.join();
        long end2 = System.currentTimeMillis();
        System.out.println("LongAdder:" + (end2-start2));

        Object lock = new Object();
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                        for (int j = 0; j < 100000; j++) {
                            synchronized (lock){
                            count++;
                        }
                    }
                }
            });
        }

        long start3 = System.currentTimeMillis();
        for(Thread t : ts)t.start();
        for(Thread t : ts)t.join();
        long end3 = System.currentTimeMillis();
        System.out.println("Long:" + (end3-start3));


    }

}
