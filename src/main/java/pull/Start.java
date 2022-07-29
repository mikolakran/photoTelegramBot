package pull;

import java.util.concurrent.TimeUnit;

public class Start implements Runnable{

    public synchronized void start(){
        while (!Thread.currentThread().isInterrupted()) {
            for (int i = 0; i < 15; i++) {
                System.out.print("i = " + i+" ");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        System.out.println("stop");
                    }
                    System.out.println("proceed");
                }
            }
        }
    }
    @Override
    public void run() {
        start();
    }
}
