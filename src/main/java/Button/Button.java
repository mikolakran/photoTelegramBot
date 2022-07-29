package Button;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Button {

    public ReplyKeyboard inlineOne(String text, String numberText) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(numberText);
        buttons1.add(inlineKeyboardButton);
        buttons.add(buttons1);
        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
        return markupKeyboard;
    }

    public ReplyKeyboard inlineOne(String text, String numberText,
                                   String text2, String numberText2) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(numberText);
        inlineKeyboardButton1.setText(text2);
        inlineKeyboardButton1.setCallbackData(numberText2);
        buttons1.add(inlineKeyboardButton);
        buttons1.add(inlineKeyboardButton1);
        buttons.add(buttons1);
        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
        return markupKeyboard;
    }

    public ReplyKeyboard inlineOne(String text, String numberText,
                                   String text2, String numberText2,
                                   String text3, String numberText3) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(numberText);
        inlineKeyboardButton2.setText(text2);
        inlineKeyboardButton2.setCallbackData(numberText2);
        inlineKeyboardButton3.setText(text3);
        inlineKeyboardButton3.setCallbackData(numberText3);
        buttons1.add(inlineKeyboardButton);
        buttons1.add(inlineKeyboardButton2);
        buttons1.add(inlineKeyboardButton3);
        buttons.add(buttons1);
        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
        return markupKeyboard;
    }

    public ReplyKeyboard inlineOne(String text, String numberText,
                                   String text3, String numberText3,
                                   String text2, String numberText2,
                                   String text4, String numberText4) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        inlineKeyboardButton.setText(text);
        inlineKeyboardButton.setCallbackData(numberText);
        inlineKeyboardButton.setText(text2);
        inlineKeyboardButton.setCallbackData(numberText2);
        inlineKeyboardButton.setText(text3);
        inlineKeyboardButton.setCallbackData(numberText3);
        inlineKeyboardButton.setText(text4);
        inlineKeyboardButton.setCallbackData(numberText4);
        buttons1.add(inlineKeyboardButton);
        buttons1.add(inlineKeyboardButton2);
        buttons1.add(inlineKeyboardButton3);
        buttons1.add(inlineKeyboardButton4);
        buttons.add(buttons1);
        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
        return markupKeyboard;
    }
}
