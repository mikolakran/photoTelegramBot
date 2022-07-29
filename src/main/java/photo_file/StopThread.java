package photo_file;

public class StopThread implements Runnable {
    public PhotoFileRun photoFileRun;

    public StopThread(PhotoFileRun photoFileRun) {
        this.photoFileRun = photoFileRun;
    }

    @Override
    public void run() {
        photoFileRun.photo_start_notify(false);
    }
}
