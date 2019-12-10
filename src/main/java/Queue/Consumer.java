package Queue;

public class Consumer {

    public void take(){
        while (true){
            try {

                    String s = Main.queue.take();
                    System.out.println(s);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
