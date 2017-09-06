package Command;
import Main.AnonymousChatBot;
import Main.Interest;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;

import UI.TelegramButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class SelectInterestClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText, AnonymousChatBot bot) {
		button = tButton;

		button.firstRow.add(new InlineKeyboardButton().setText("Любая категория").setCallbackData("/setInterest " + Interest.DEFAULT + ""));
		button.secondRow.add(new InlineKeyboardButton().setText("Музыка").setCallbackData("/setInterest " + Interest.MUSIC + ""));
		button.thirdRow.add(new InlineKeyboardButton().setText("Фильмы").setCallbackData("/setInterest " + Interest.FILMS + ""));
		button.fourthRow.add(new InlineKeyboardButton().setText("Игры").setCallbackData("/setInterest " +Interest.GAMES + ""));
		button.fifthRow.add(new InlineKeyboardButton().setText("IT").setCallbackData("/setInterest " +Interest.IT + ""));
		button.sixthRow.add(new InlineKeyboardButton().setText("Секс").setCallbackData("/setInterest " +Interest.SEX + ""));
		button.seventhRow.add(new InlineKeyboardButton().setText("Психология").setCallbackData("/setInterest " + Interest.PSYHOLOGY + ""));

		button.rowsInline.add(button.firstRow);
		button.rowsInline.add(button.secondRow);
		button.rowsInline.add(button.thirdRow);
		button.rowsInline.add(button.fourthRow);
		button.rowsInline.add(button.fifthRow);
		button.rowsInline.add(button.sixthRow);
		button.rowsInline.add(button.seventhRow);

		button.markupInline.setKeyboard(button.rowsInline);
		editMessageText.setReplyMarkup(button.markupInline);

		return editMessageText;
	}
}
