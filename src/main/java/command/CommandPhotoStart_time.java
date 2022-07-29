package command;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandPhotoStart_time {
    public String time;

    public String commandPhotoStart_time(Update update) {
        String s = update.getMessage().getText();
        Pattern pattern = Pattern.compile("([/\\S]+[+])([0-9]+)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            time = matcher.group(2);
        }
        return time;
    }

}
