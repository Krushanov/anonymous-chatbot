package Command;

import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;

import UI.TelegramButton;

public interface Command {
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText);
}