package AQS;

import java.util.concurrent.Exchanger;

/**
 * @author ma
 * @version 1.0 {2019/11/25}
 */
public class Exchange {

    static  Exchanger<String> stringExchange = new Exchanger();

    public static void main(String[] args) {
        new Thread(()->{
            String a = "t1";
            System.out.println(
                    "线程名："+Thread.currentThread().getName());
            try {
                String b = stringExchange.exchange(a);
                System.out.println("t1打印："+b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            String a = "t2";
            System.out.println(
                    "线程名："+Thread.currentThread().getName());
            try {
                String b = stringExchange.exchange(a);
                System.out.println("t2打印："+b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
