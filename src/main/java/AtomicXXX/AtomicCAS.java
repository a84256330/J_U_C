package AtomicXXX;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子性CAS使用
 *
 * @author ma
 * @version 1.0 {2019/11/21}
 */
public class AtomicCAS {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(10);
        System.out.println(atomicInteger.compareAndSet(10, 12));
    }
}
