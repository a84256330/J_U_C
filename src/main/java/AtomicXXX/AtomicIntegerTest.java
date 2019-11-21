package AtomicXXX;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ma
 * @version 1.0 {2019/11/21}
 */
public class AtomicIntegerTest {
    AtomicInteger at = new AtomicInteger(0);
    void m(){

        for (int i = 0; i < 10000; i++) {
            at.incrementAndGet();
        }

    }

    public static void main(String[] args) {
        AtomicIntegerTest att = new AtomicIntegerTest();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(att::m,"id"+i));
        }
        list.forEach((o)->o.start());
        list.forEach((i)-> {
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(att.at);
    }
}
