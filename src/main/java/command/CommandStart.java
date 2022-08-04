package command;

import SendMesseng.BotCommandSend;
import bot.Bot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import person.UserPerson;

public class CommandStart {
    private final UserPerson userPerson;
    private final Bot bot=new Bot();
    private final BotCommandSend botCommandSend = new BotCommandSend();

    public CommandStart(UserPerson userPerson) {
        this.userPerson = userPerson;
    }

    public void start_command(Update update) {
        if (update.getMessage().getFrom().getUserName() == null) {
            userPerson.setNameIdPerson(update.getMessage().getFrom().getFirstName(),
                    String.valueOf(update.getMessage().getFrom().getId()));
            try {
                bot.execute(botCommandSend.sendMessage(String.valueOf(update.getMessage().getChatId()),
                        "Добро пожаловать " + userPerson.getNamePerson()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            userPerson.setNameIdPerson(update.getMessage().getFrom().getUserName(),
                    String.valueOf(update.getMessage().getFrom().getId()));
            try {
                bot.execute(botCommandSend.sendMessage(String.valueOf(update.getMessage().getChatId()),
                        "Добро пожаловать " + userPerson.getNamePerson()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        if (update.getMessage().getChatId() < 0) {
            userPerson.setGroupNameIdPerson(update.getMessage().getChat().getUserName(),
                    String.valueOf(update.getMessage().getChatId()));
        }else{
           userPerson.setGroupNameIdPerson(update.getMessage().getChat().getUserName(),
                   String.valueOf(update.getMessage().getForwardFromChat().getId()));
        }
    }
}
