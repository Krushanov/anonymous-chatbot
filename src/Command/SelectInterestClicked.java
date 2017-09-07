package Command;
import Language.Language;
import Main.AnonymousChatBot;
import Main.Interest;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;

import UI.TelegramButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class SelectInterestClicked implements Command {
	private TelegramButton button;

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText, AnonymousChatBot bot, Language language) {
		button = tButton;

		button.firstRow.add(new InlineKeyboardButton().setText(language.getString("defaultInterestButton")).setCallbackData("/setInterest " + Interest.DEFAULT + ""));
		button.secondRow.add(new InlineKeyboardButton().setText(language.getString("musicInterestButton")).setCallbackData("/setInterest " + Interest.MUSIC + ""));
		button.thirdRow.add(new InlineKeyboardButton().setText(language.getString("filmsInterestButton")).setCallbackData("/setInterest " + Interest.FILMS + ""));
		button.fourthRow.add(new InlineKeyboardButton().setText(language.getString("gamesInterestButton")).setCallbackData("/setInterest " +Interest.GAMES + ""));
		button.fifthRow.add(new InlineKeyboardButton().setText(language.getString("itInterestButton")).setCallbackData("/setInterest " +Interest.IT + ""));
		button.sixthRow.add(new InlineKeyboardButton().setText(language.getString("sexInterestButton")).setCallbackData("/setInterest " +Interest.SEX + ""));
		button.seventhRow.add(new InlineKeyboardButton().setText(language.getString("psyhologyInterestButton")).setCallbackData("/setInterest " + Interest.PSYHOLOGY + ""));

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
