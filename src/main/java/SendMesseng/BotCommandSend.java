package SendMesseng;

import Button.Button;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class BotCommandSend {
    Button button = new Button();

    public SendMessage sendMessage(String chat_id, String text,
                                   String textButton, String textNumberButton,
                                   String textButton2, String textNumberButton2 ,
                                   String textButton3, String textNumberButton3 ,
                                   String textButton4,String textNumberButton4){
        return SendMessage.builder().chatId(chat_id).text(text).
                replyMarkup(button.inlineOne(textButton,textNumberButton,
                        textButton2,textNumberButton2,
                        textButton3,textNumberButton3,
                        textButton4,textNumberButton4)).build();
    }
    public SendMessage sendMessage(String chat_id, String text,
                                   String textButton, String textNumberButton,
                                   String textButton2, String textNumberButton2 ,
                                   String textButton3,String textNumberButton3){
        return SendMessage.builder().chatId(chat_id).text(text).
                replyMarkup(button.inlineOne(textButton,textNumberButton,
                        textButton2,textNumberButton2,
                        textButton3,textNumberButton3)).build();
    }

    public SendMessage sendMessage(String chat_id, String text,
                                   String textButton, String textNumberButton,
                                   String textButton2, String textNumberButton2){
        return SendMessage.builder().chatId(chat_id).text(text).
                replyMarkup(button.inlineOne(textButton,textNumberButton,textButton2,textNumberButton2)).build();
    }

    public SendMessage sendMessage(String chat_id, String text,
                                   String textButton, String textNumberButton){
        return SendMessage.builder().chatId(chat_id).text(text).
                replyMarkup(button.inlineOne(textButton,textNumberButton)).build();
    }

    public SendMessage sendMessage(String chat_id, String text){
        return SendMessage.builder().chatId(chat_id).text(text).build();
    }
}
