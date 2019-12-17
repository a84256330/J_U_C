package WriteReadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ¶ÁÐ´Ëø
 */

public class t1 {
    static ReadWriteLock rw = new ReentrantReadWriteLock();

    static Lock read = rw.readLock();

    static Lock write = rw.writeLock();

    void Read(){

    }

}
