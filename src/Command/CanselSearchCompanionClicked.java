package Command;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import UI.TelegramButton;

public class CanselSearchCompanionClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText) {
		button = tButton;
		
		button.firstRow.add(new InlineKeyboardButton().setText("����� �����������").setCallbackData("searchCompanion"));
		button.secondRow.add(new InlineKeyboardButton().setText("������� �������� ���������").setCallbackData("selectInterest"));
		button.thirdRow.add(new InlineKeyboardButton().setText("������ ���-�� ������������").setCallbackData("companionCount"));
		button.fourthRow.add(new InlineKeyboardButton().setText("������").setCallbackData("help"));
        
		button.rowsInline.add(button.firstRow);
		button.rowsInline.add(button.secondRow);
		button.rowsInline.add(button.thirdRow);
		button.rowsInline.add(button.fourthRow);
        
		button.markupInline.setKeyboard(button.rowsInline);
        editMessageText.setReplyMarkup(button.markupInline);
        
		return editMessageText;
	}
}
