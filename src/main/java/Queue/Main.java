package Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    public static BlockingQueue<String> queue = new LinkedBlockingQueue();
    public static void main(String[] args) {
        
        Thread t = new Thread(
                () ->{
                    new Consumer().take();
                }
        );

        Thread t2 = new Thread(
                () ->{
                    new Prosumer().put();
                }
        );
        t2.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.start();


        



    }
}
