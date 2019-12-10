package Queue;

public class Prosumer {

    public void put(){
        for (int i = 0; i < 10; i++) {

            try {
                Main.queue.put(i+"");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
