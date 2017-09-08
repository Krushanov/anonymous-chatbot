package Command;
import Language.Language;
import Main.AnonymousChatBot;
import Main.Interest;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;

import UI.TelegramButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class SelectCountCompanionClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText, AnonymousChatBot bot, Language language) {
		button = tButton;

		button.firstRow.add(new InlineKeyboardButton().setText("2").setCallbackData("/setCountCompanion 2"));
        button.secondRow.add(new InlineKeyboardButton().setText("3").setCallbackData("/setCountCompanion 3"));
        button.thirdRow.add(new InlineKeyboardButton().setText("4").setCallbackData("/setCountCompanion 4"));
        button.fourthRow.add(new InlineKeyboardButton().setText("5").setCallbackData("/setCountCompanion 5"));

		button.rowsInline.add(button.firstRow);
		button.rowsInline.add(button.secondRow);
		button.rowsInline.add(button.thirdRow);
		button.rowsInline.add(button.fourthRow);

		button.markupInline.setKeyboard(button.rowsInline);
		editMessageText.setReplyMarkup(button.markupInline);

		return editMessageText;
	}
}
