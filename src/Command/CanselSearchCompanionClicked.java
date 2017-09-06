package Command;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import UI.TelegramButton;

public class CanselSearchCompanionClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText) {
		button = tButton;
		
		button.firstRow.add(new InlineKeyboardButton().setText("Найти собеседника").setCallbackData("searchCompanion"));
		button.secondRow.add(new InlineKeyboardButton().setText("Выбрать тематику переписки").setCallbackData("selectInterest"));
		button.thirdRow.add(new InlineKeyboardButton().setText("Задать кол-во собеседников").setCallbackData("companionCount"));
		button.fourthRow.add(new InlineKeyboardButton().setText("Помощь").setCallbackData("help"));
        
		button.rowsInline.add(button.firstRow);
		button.rowsInline.add(button.secondRow);
		button.rowsInline.add(button.thirdRow);
		button.rowsInline.add(button.fourthRow);
        
		button.markupInline.setKeyboard(button.rowsInline);
        editMessageText.setReplyMarkup(button.markupInline);
        
		return editMessageText;
	}
}
