package bot;

import SendMesseng.BotCommandSend;
import command.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import person.UserPerson;
import photo_file.*;
import json.ReadingJson;
import pull.FileThread;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Bot extends TelegramLongPollingBot {

    private ReadingJson readingJson = new ReadingJson();
    private final String nameFileJson = "photoTelegramBot/src/main/resources/json.js";
    private final String command_start = readingJson.reading("command", nameFileJson);
    private final String command_start_photo = readingJson.reading("command4", nameFileJson);
    private final String command_stop_bot = readingJson.reading("command5", nameFileJson);


    public BotCommandSend botCommandSend = new BotCommandSend();
    public PhotoDocument photoDocument;
    private UserPerson userPerson;
    private CommandStart commandStart;
    public CommandPhotoDelete commandPhotoDelete = new CommandPhotoDelete();
    public CommandPhotoLoadingPhoto commandPhotoLoadingPhoto = new CommandPhotoLoadingPhoto();
    public CommandPhotoStart_time commandPhotoStart_photo;
    public CommandPhotoStop commandPhotoStop = new CommandPhotoStop();
    public CommandPhotoStartRun commandPhotoStartRun = new CommandPhotoStartRun();
    public PhotoFileRun photoFileRun;

    public Bot() {
    }

    public Bot(PhotoFileRun photoFileRun) {
        this.photoFileRun = photoFileRun;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage().hasDocument() && commandPhotoLoadingPhoto.isB()) {
            try {
                photoDocument = new PhotoDocument(update, getBotToken());
                photoDocument.getPhotoDocument();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (update.hasMessage()) {
            if (update.getMessage().getText().equals(command_start)) {
                userPerson = new UserPerson();
                commandStart = new CommandStart(userPerson);
                commandStart.start_command(update);
            }
            commandPhotoDelete.commandPhotoDelete(update, userPerson.getIdPerson());
            commandPhotoLoadingPhoto.commandLoadingPhoto(update, userPerson.getIdPerson());
            try {
                commandPhotoStartRun.commandStartRun(update,userPerson,photoFileRun);
               /* commandPhotoStart_photo = new CommandPhotoStart_time();
                if (update.getMessage().getText().equals(command_start_photo + "+"
                        + commandPhotoStart_photo.commandPhotoStart_photo(update)) && update.getMessage().getFrom().getId().equals(
                        Long.parseLong(userPerson.getIdPerson())
                ) && userPerson.getIdPerson() != null) {
                    *//*thread = new Thread(new PhotoFileRun(userPerson.getGroupIdPerson(), userPerson.getIdPerson(),
                            commandPhotoStart_photo.commandPhotoStart_photo(update)
                            , false));
                    thread.start();*//*
                } else if (update.getMessage().getText().equals(command_start_photo) && update.getMessage().getFrom().getId().equals(
                        Long.parseLong(userPerson.getIdPerson())
                )) {
                    if (!counter) {
                        if (thread==null) {
                        thread = new Thread(new StartPhotoThread(photoFileRun));
                        photoFileRun.photo_start(thread, userPerson.getGroupIdPerson(),userPerson.getIdPerson(),
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
                            photoFileRun.photo_start(thread, userPerson.getGroupIdPerson(),userPerson.getIdPerson(),
                                    "0"
                                    , false);
                            thread1 = new Thread(new StopThread(photoFileRun));
                            thread.start();
                            thread1.start();
                        }
                    }
                }  if (update.getMessage().getText().equals(command_stop_bot) && userPerson.getIdPerson() != null && update.getMessage().getFrom().getId().equals(
                        Long.parseLong(userPerson.getIdPerson())
                )) {
                    if (!counter_stop) {
                        counter_stop = true;
                        photoFileRun.photo_stop(true);
                    } else {
                        counter = false;
                        counter_stop = false;
                        photoFileRun.photo_stop(false);
                    }
                }*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            extracted();
        }
    }

    private void extracted() {
        int threadCount = 0;
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for ( Thread t : threadSet){
            if ( t.getThreadGroup() == Thread.currentThread().getThreadGroup()){
                System.out.println("Thread :"+t+":"+"state:"+t.getState());
                ++threadCount;
            }
        }
        System.out.println("Thread count started by Main thread:"+threadCount);
    }

    @Override
    public String getBotUsername() {
        return readingJson.reading("name", nameFileJson);
    }

    @Override
    public String getBotToken() {
        return readingJson.reading("token", nameFileJson);
    }

}

