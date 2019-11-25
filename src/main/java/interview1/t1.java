package interview1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * �����������⣺���Ա�����
 * ʵ��һ���������ṩ����������add��size
 * д�����̣߳��߳�1���10��Ԫ�ص������У��߳�2ʵ�ּ��Ԫ�صĸ�������������5��ʱ���߳�2������ʾ������
 *
 * �����������������������������
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
                    System.out.println("t2 ����");
                }
        );
        t.start();
        t2.start();
    }
}
