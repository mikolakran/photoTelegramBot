package pull;

import SendMesseng.BotCommandSend;
import bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FileThread {
    public volatile boolean stop_wait_notify;
    public volatile boolean stop_wait_notify2;

    private Bot bot = new Bot();
    private BotCommandSend botCommandSend = new BotCommandSend();

    public synchronized void start(String chat_idGroup, String chat_idPerson, String time, boolean stop){
        File file = new File("photoTelegramBot/src/main/resources/upload_file");
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
                            }
                            if (!stop_wait_notify){
                               /* this.stop_wait_notify = true;*/
                                try {
                                    System.out.println("stop_wait");
                                    wait();
                                } catch (InterruptedException e) {
                                    System.out.println("esc");
                                }
                            }
                            System.out.println("notify");
                        } else {
                            try {
                                TimeUnit.MINUTES.sleep(Long.parseLong(time));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    try {
                        bot.execute(botCommandSend.sendMessage(chat_idPerson, "Все перечисленные фото на данный момент закончились удалите старые " +
                                "и загрузите новые или они повторно загрузятся с новыми"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
    }



    public synchronized void stop(boolean stop_wait_notify){
        System.out.println(0);
        System.out.println(stop_wait_notify);
        if (stop_wait_notify){
            notify();
        }
    }

    public  void isStop_notify(boolean stop,boolean stop_wait_notify2){
        this.stop_wait_notify = stop;
        this.stop_wait_notify2 = stop_wait_notify2;
    }

}
