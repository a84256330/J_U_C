package SynTest;

import java.util.concurrent.TimeUnit;

public class HuaWei {
    public static synchronized  void doSms() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("华为发短信");
    }

    public  synchronized void doCall()throws Exception{

        System.out.println("华为打电话");
    }

    public void doPlay(){
        System.out.println("玩华为手机壳");
    }
}
