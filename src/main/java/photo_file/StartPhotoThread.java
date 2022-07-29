package photo_file;

public class StartPhotoThread implements Runnable{
    public PhotoFileRun photoFileRun;

    public StartPhotoThread(PhotoFileRun photoFileRun) {
        this.photoFileRun = photoFileRun;
    }

    @Override
    public void run() {
        photoFileRun.photo_run();
    }
}
