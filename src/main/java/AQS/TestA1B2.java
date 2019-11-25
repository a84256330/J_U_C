package AQS;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ma
 * @version 1.0 {2019/11/25}
 */
public class TestA1B2 {
    public static void main(String[] args) {

//        Thread t1 =new Thread (()->{
//            for (String c : a){
//                System.out.println(c);
//                wait();
//            } }
//        );

        Thread t2 = new Thread (()->{
            for (int i = 1; i < 6; i++) {
                System.out.println(i);
            }
        }
        );


    }
}
