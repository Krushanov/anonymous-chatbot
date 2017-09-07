package Command;
import Language.Language;
import Main.AnonymousChatBot;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;

import UI.TelegramButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class SelectLanguageClicked implements Command {
    private TelegramButton button;

    @Override
    public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText, AnonymousChatBot bot, Language language) {
        button = tButton;

        button.firstRow.add(new InlineKeyboardButton().setText(language.getString("selectEnglishButton")).setCallbackData("/setLanguage " + Language.ENGLISH + ""));
        button.secondRow.add(new InlineKeyboardButton().setText(language.getString("selectRussianButton")).setCallbackData("/setLanguage " + Language.RUSSAIN + ""));

        button.rowsInline.add(button.firstRow);
        button.rowsInline.add(button.secondRow);

        button.markupInline.setKeyboard(button.rowsInline);
        editMessageText.setReplyMarkup(button.markupInline);

        return editMessageText;
    }
}
