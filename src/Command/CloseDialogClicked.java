package Command;
import Language.Language;
import Main.AnonymousChatBot;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;

import UI.TelegramButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class CloseDialogClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText, AnonymousChatBot bot, Language language) {
		button = tButton;
		return null;
	}
}
