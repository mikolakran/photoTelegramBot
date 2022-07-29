package photo_file;

import SendMesseng.BotCommandSend;
import bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class FileDowтload implements Runnable{
    private String chat_idPerson;
    private String chat_idGroup;
    private String time;
    private Thread thread;
    private volatile boolean start_stop = false;
    private volatile boolean stop;
    private boolean counter=false;

    public Bot bot = new Bot();
    public BotCommandSend botCommandSend = new BotCommandSend();

    public FileDowтload() {
    }

    public FileDowтload(String chat_idPerson, String chat_idGroup, String time, boolean stop) {
        this.chat_idPerson = chat_idPerson;
        this.chat_idGroup = chat_idGroup;
        this.time = time;
        this.stop = stop;
    }

    public FileDowтload(Thread thread) {
        this.thread = thread;
    }

    public void photo_start(){
        if (!counter){
            thread .start();
            counter=true;
        }else {
                photo_stop(true);
        }
    }

    public void photo_stop(boolean stop){
        if (stop) {
            thread.interrupt();
        }else {
            counter=false;
            start_stop = true;
        }
        this.stop=stop;
    }

    public synchronized void photo_dovloand(boolean start_stop){
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
                                TimeUnit.SECONDS.sleep(2);
                            } catch (InterruptedException e) {
                                System.out.println("start_stop = " + start_stop);
                                if (!start_stop) {
                                    start_stop = true;
                                    try {
                                        System.out.println(" остановить");
                                        wait();
                                    } catch (InterruptedException ex) {
                                        System.out.println("продолжить");
                                        Thread.currentThread().interrupt();
                                    }
                                }else {
                                    System.out.println("1");
                                    break;
                                }
                            }
                        } else {
                            try {
                                TimeUnit.MINUTES.sleep(Long.parseLong(time));
                            } catch (InterruptedException e) {
                                break;
                            }
                        }
                }
            }
        }
    }

    @Override
    public void run() {
            photo_dovloand(start_stop);
    }
}
