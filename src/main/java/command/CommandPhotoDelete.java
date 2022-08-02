package command;

import SendMesseng.BotCommandSend;
import bot.Bot;
import json.ReadingJson;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import photo_file.PhotoFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandPhotoDelete {

    public String plus = "+";
    public String nameFile;

    private  ReadingJson readingJson = new ReadingJson();
    private final String nameFileJson = "src/main/resources/json.js";
    private final String command_delete_photo = readingJson.reading("command3", nameFileJson);

    public Bot bot;
    public BotCommandSend botCommandSend = new BotCommandSend();
    public PhotoFile photoFile;

    public void commandPhotoDelete(Update update,String idPerson){
        bot =  new Bot();
        String text =update.getMessage().getText();
        Pattern pattern = Pattern.compile("([/\\S]+[+])([\\S]+[.(jpg|png|gif|bmp|psd|svg|tga|tiff|JPG|PNG|GIF|BMP|PSD|SVG|TGA|TIFF)])");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            nameFile = matcher.group(2);
        }
        if(text.equals(command_delete_photo) && update.getMessage().getFrom().getId().equals(
                Long.parseLong(idPerson)
        )){
            photoFile = new PhotoFile();
            if (photoFile.deleteFile()){
                try {
                    bot.execute(botCommandSend.sendMessage(String.valueOf(update.getMessage().getChatId()),"Файлы успешно удаленны"));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    bot.execute(botCommandSend.sendMessage(String.valueOf(update.getMessage().getChatId()),"Файлов нет"));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }else if (update.getMessage().getText().equals(command_delete_photo+plus+nameFile)&&update.getMessage().getFrom().getId().equals(
                Long.parseLong(idPerson)
        )){
            photoFile =new PhotoFile();
            if (nameFile!=null){
                if (photoFile.deleteFileName(nameFile)){
                    try {
                        bot.execute(botCommandSend.sendMessage(String.valueOf(update.getMessage().getChatId()),"Файл успешно удален"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        bot.execute(botCommandSend.sendMessage(String.valueOf(update.getMessage().getChatId()),"Файла нету"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
