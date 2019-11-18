package SynTest;

public class Main {
    // 线程八锁
    /**
     ** 1.同一个手机，先短信，先邮件
     *  2.同一个手机短信停2秒，先短信，先邮件
     *  3.新增一个普通方法玩手机壳，先短信，先玩手机壳
     *  4.两部手机，先短信，先邮件
     *  5.两个静态方法，同一个手机，先短信，先邮件
     *  6.两个静态方法，两部手机，先短信，先邮件
     *  7.一个普通同步，一个静态同步，同一部手机 先短信，先邮件
     *  8.一个普通同步，一个静态同步，俩部手机 先短信，先邮件
     *
     *
     *
     *
     *  结论：
     *  八锁
     *  1.一个对象多个synchronized方法，锁的是对象，必须一个完毕，才走下一个
     *  2.加入普通方法，则不被锁限制
     *  3.两个对象多个synchronized方法，锁不会互相影响
     *  4.静态的synchronized方法，锁的是class,多个对象也会互相影响
     *  5.无论一个还是多个对象，静态同步和普通同步都不会互相影响
     *
     *  ps: new this 为一部手机
     *      static class 为手机模板
     *      普通非同步方法为手机壳
     *
     *  synchronized（任意一个对象都可以上锁）
     *  1.普通同步方法锁当前对象this
     *  2.静态同步方法锁类static 锁class
     *  3.同步代码块锁synchronized配置内容
     *
     */

    public static void main(String[] args) {
        HuaWei huawei = new HuaWei();
        HuaWei iPhone = new HuaWei();
        Thread t1 = new Thread(
                () ->{
                    try {
                        huawei.doSms();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );

        Thread t2 = new Thread(
                () ->{
                    try {
                        huawei.doCall();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );

        Thread t3 = new Thread(
                () ->{
                    huawei.doPlay();
                }
        );
        Thread t4 = new Thread(
                () ->{
                    try {
                        iPhone.doCall();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } 
        );

        t1.start();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.start();


    }
}
