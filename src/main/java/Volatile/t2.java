package Volatile;

/**
 *  Ω˚÷π÷ÿ≈≈–Ú
 */
public class t2 {

    int a = 0;
    boolean flag = false;

    void m(){
        this.a=1;
        this.flag = true;
    }

    public static void main(String[] args) {
        t2 t2 = new t2();
        new Thread(t2::m).start();
        while (t2.flag){
            t2.a = t2.a+5;
        }
        System.out.println(t2.a);
    }

}
