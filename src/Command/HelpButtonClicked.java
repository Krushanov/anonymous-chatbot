package Command;
import Language.Language;
import Main.AnonymousChatBot;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import UI.TelegramButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class HelpButtonClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText, AnonymousChatBot bot, Language language) {
		button = tButton;
		
		button.firstRow.add(new InlineKeyboardButton().setText(language.getString("backButton")).setCallbackData("back"));
		button.rowsInline.add(button.firstRow);
		button.markupInline.setKeyboard(button.rowsInline);
        editMessageText.setReplyMarkup(button.markupInline);
        
        return editMessageText;
	}
}
