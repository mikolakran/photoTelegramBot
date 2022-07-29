package pull;

public class StopThread1 implements Runnable{
    public  Start start;

    public StopThread1(Start start) {
        this.start = start;
    }


    @Override
    public void run() {
        synchronized (start){
            System.out.println(0);
            start.notify();
            System.out.println(1);
        }
    }
}
