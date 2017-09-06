package Command;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import UI.TelegramButton;

public class HelpButtonClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText) {
		button = tButton;
		
		button.firstRow.add(new InlineKeyboardButton().setText("Назад").setCallbackData("back"));
		button.rowsInline.add(button.firstRow);
		button.markupInline.setKeyboard(button.rowsInline);
        editMessageText.setReplyMarkup(button.markupInline);
        
        return editMessageText;
	}
}
