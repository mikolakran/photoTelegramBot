import bot.Bot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import photo_file.PhotoFileRun;

public class Run {
    public static void main(String[] args) throws TelegramApiException {
       final PhotoFileRun photoFileRun = new PhotoFileRun();
        Bot bot = new Bot(photoFileRun);
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
