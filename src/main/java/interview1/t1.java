package interview1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 * 分析下面这个程序，能完成这个功能吗？
 * @author ma
 */
public class t1 {

    public static void main(String[] args) throws InterruptedException {
        NewList newList = new NewList();
        
        Thread t = new Thread(
                () ->{
                    for (int i = 0; i < 10; i++) {
                        newList.add(i);
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        
        Thread t2 = new Thread(
                () ->{
                    while (true){
                        if (newList.size()==5) {
                            break;
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 结束");
                }
        );
        t.start();
        t2.start();
    }
}
