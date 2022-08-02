package command;

import json.ReadingJson;
import org.telegram.telegrambots.meta.api.objects.Update;
import person.UserPerson;
import photo_file.PhotoFileRun;
import photo_file.StartPhotoThread;
import photo_file.StopThread;

public class CommandPhotoStartRun {
    private final ReadingJson readingJson = new ReadingJson();
    private final String nameFileJson = "src/main/resources/json.js";
    private final String command_start_photo = readingJson.reading("command4", nameFileJson);
    private final String command_stop_bot = readingJson.reading("command5", nameFileJson);

    CommandPhotoStart_time commandPhotoStart_time = new CommandPhotoStart_time();

    public Thread thread;
    public Thread thread1;

    private boolean counter = false;
    private boolean counter_stop = false;

    public void commandStartRun(Update update, UserPerson userPerson,PhotoFileRun photoFileRun){
        commandPhotoStart_time = new CommandPhotoStart_time();
        if (update.getMessage().getText().equals(command_start_photo + "+"
                + commandPhotoStart_time.commandPhotoStart_time(update)) && update.getMessage().getFrom().getId().equals(
                Long.parseLong(userPerson.getIdPerson())
        ) && userPerson.getIdPerson() != null) {
            thread_start_time(update, userPerson, photoFileRun);
        } else if (update.getMessage().getText().equals(command_start_photo) && update.getMessage().getFrom().getId().equals(
                Long.parseLong(userPerson.getIdPerson())
        )) {
            thread_start_0(userPerson, photoFileRun);
        }  if (update.getMessage().getText().equals(command_stop_bot) && userPerson.getIdPerson() != null && update.getMessage().getFrom().getId().equals(
                Long.parseLong(userPerson.getIdPerson())
        )) {
            thread_stop_0(photoFileRun);
        }
    }

    private void thread_start_time(Update update, UserPerson userPerson, PhotoFileRun photoFileRun) {
        if (!counter) {
            if (thread==null) {
                thread = new Thread(new StartPhotoThread(photoFileRun));
                photoFileRun.photo_start(thread, userPerson.getGroupIdPerson(), userPerson.getIdPerson(),
                        commandPhotoStart_time.commandPhotoStart_time(update)
                        , false);
                thread1 = new Thread(new StopThread(photoFileRun));
                thread.start();
                thread1.start();
            }else if (thread.isAlive()){
                counter_stop = false;
                photoFileRun.photo_start_notify(true);
            }else {
                thread = new Thread(new StartPhotoThread(photoFileRun));
                photoFileRun.photo_start(thread, userPerson.getGroupIdPerson(), userPerson.getIdPerson(),
                        commandPhotoStart_time.commandPhotoStart_time(update)
                        , false);
                thread1 = new Thread(new StopThread(photoFileRun));
                thread.start();
                thread1.start();
            }
        }
    }

    private void thread_start_0(UserPerson userPerson, PhotoFileRun photoFileRun) {
        if (!counter) {
            if (thread==null) {
                thread = new Thread(new StartPhotoThread(photoFileRun));
                photoFileRun.photo_start(thread, userPerson.getGroupIdPerson(), userPerson.getIdPerson(),
                        "0"
                        , false);
                thread1 = new Thread(new StopThread(photoFileRun));
                thread.start();
                thread1.start();
            }else if (thread.isAlive()){
                counter_stop = false;
                photoFileRun.photo_start_notify(true);
            }else {
                thread = new Thread(new StartPhotoThread(photoFileRun));
                photoFileRun.photo_start(thread, userPerson.getGroupIdPerson(), userPerson.getIdPerson(),
                        "0"
                        , false);
                thread1 = new Thread(new StopThread(photoFileRun));
                thread.start();
                thread1.start();
            }
        }
    }

    private void thread_stop_0(PhotoFileRun photoFileRun) {
        if (!counter_stop) {
            counter_stop = true;
            photoFileRun.photo_stop(true);
        } else {
            counter = false;
            counter_stop = false;
            photoFileRun.photo_stop(false);
        }
    }
}
