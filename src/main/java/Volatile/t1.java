package Volatile;

import java.util.concurrent.TimeUnit;

/**
 *  Volatile �ɼ���
 */
public class t1 {

    volatile Boolean flag = true;

    void m (){
        System.out.println("��ʼ");
        while (flag){};
        System.out.println("����");
    }

    public static void main(String[] args) {
        t1 t1 = new t1();
        new Thread(t1::m).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.flag = false;
    }

}
