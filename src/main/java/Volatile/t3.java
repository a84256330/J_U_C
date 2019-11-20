package Volatile;

/**
 * dcl
 */
public class t3 {

    private  volatile static t3 t = null;

    private t3(){};

    public static t3 getInstance(){
        if (t == null) {
            synchronized (t3.class){
                if (t == null) {
                    t = new t3();
                }
            }
        }
        return t;
    }

}
