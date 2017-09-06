package Command;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;

import UI.TelegramButton;

public class CompanionCountClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText) {
		button = tButton;
		return null;
	}
}
