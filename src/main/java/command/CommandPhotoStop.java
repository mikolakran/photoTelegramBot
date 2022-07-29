package command;

import json.ReadingJson;
import org.telegram.telegrambots.meta.api.objects.Update;
import photo_file.PhotoFileRun;

public class CommandPhotoStop {
    private volatile boolean stop;


    public PhotoFileRun photoFileStart;

    private  ReadingJson readingJson = new ReadingJson();
    private final String nameFileJson = "photoTelegramBot/src/main/resources/json.js";
    private final String command_stop_bot = readingJson.reading("command5", nameFileJson);
    public Thread thread;

    public void command_stop(Update update){
        if (update.getMessage().getText().equals(command_stop_bot)){
            /*photoFileStart = new PhotoFileStart(true);
            photoFileStart.photo_stop();*/
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {

        this.stop = stop;
    }
}
