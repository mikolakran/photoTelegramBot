package photo_file;

import SendMesseng.BotCommandSend;
import bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PhotoFileRun {
    public Thread thread;
    private String chat_idGroup;
    private String chat_idPerson;
    private String time;
    private boolean stop;
    private boolean stop_wait;
    private volatile boolean file_stop;

    public Bot bot = new Bot();
    public BotCommandSend botCommandSend = new BotCommandSend();


    public synchronized void photo_start(Thread thread,String chat_idGroup, String chat_idPerson, String time, boolean stop) {
        this.thread = thread;
        this.chat_idGroup = chat_idGroup;
        this.chat_idPerson = chat_idPerson;
        this.time = time;
        this.stop = stop;
    }

    public synchronized void photo_start_notify(boolean stop){
        if (stop){
           notify();
        }
    }

    public  void photo_stop(boolean stop) {
        if (stop){
            thread.interrupt();
        }else{
            thread.interrupt();
        }
    }

    public synchronized void photo_run() {
        File file = new File("src/main/resources/upload_file");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        if (file.isDirectory()) {
            while (!Thread.currentThread().isInterrupted()) {
                    for (File file1 : Objects.requireNonNull(file.listFiles())) {
                        InputFile inputFile = new InputFile(file1);
                        try {
                            bot.execute(SendPhoto.builder().chatId(chat_idGroup).photo(inputFile).build());
                        } catch (TelegramApiException e) {
                            try {
                                bot.execute(botCommandSend.sendMessage(chat_idPerson, "Файл для загрузки не нашлось" +
                                        " возможно вы их удалили во время загрузки"));
                            } catch (TelegramApiException ex) {
                                ex.printStackTrace();
                            }
                        }
                        if (time.equals("0")) {
                            try {
                                TimeUnit.SECONDS.sleep(5);
                            } catch (InterruptedException e) {
                                System.out.println("stop");
                                if (!file_stop) {
                                    try {
                                        wait();
                                    } catch (InterruptedException ex) {
                                        break;
                                    }
                                    System.out.println("notify");
                                }else {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        } else {
                            try {
                                TimeUnit.MINUTES.sleep(Long.parseLong(time));
                            } catch (InterruptedException e) {
                                System.out.println("stop");
                                if (!file_stop) {
                                    try {
                                        wait();
                                    } catch (InterruptedException ex) {
                                        break;
                                    }
                                    System.out.println("notify");
                                }else {
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }
                    }
                try {
                    bot.execute(botCommandSend.sendMessage(chat_idPerson, "Все перечисленные фото на данный момент закончились удалите старые " +
                            "и загрузите новые или они повторно загрузятся с новыми"));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
