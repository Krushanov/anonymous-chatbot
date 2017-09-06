package Command;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;

import UI.TelegramButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class SelectInterestClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText) {
		button = tButton;

		button.firstRow.add(new InlineKeyboardButton().setText("Любая категория").setCallbackData("allInterest"));
		button.secondRow.add(new InlineKeyboardButton().setText("Музыка").setCallbackData("musicInterest"));
		button.thirdRow.add(new InlineKeyboardButton().setText("Фильмы").setCallbackData("filmsInterest"));
		button.fourthRow.add(new InlineKeyboardButton().setText("Игры").setCallbackData("gamesInterest"));
		button.fifthRow.add(new InlineKeyboardButton().setText("IT").setCallbackData("itInterest"));
		button.sixthRow.add(new InlineKeyboardButton().setText("Секс").setCallbackData("sexInterest"));
		button.seventhRow.add(new InlineKeyboardButton().setText("Психология").setCallbackData("psychologyInterest"));

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
