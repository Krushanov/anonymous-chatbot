package Command;
import Language.Language;
import Main.AnonymousChatBot;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import UI.TelegramButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class MainMenuClicked implements Command {

	private TelegramButton button;
	
	public MainMenuClicked() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public EditMessageText execute(TelegramButton tButton, EditMessageText editMessageText, AnonymousChatBot bot, Language language) {
		button = new TelegramButton(bot);

		button.firstRow.add(new InlineKeyboardButton().setText(language.getString("searchCompanionButton")).setCallbackData("searchCompanion"));
        button.secondRow.add(new InlineKeyboardButton().setText(language.getString("selectInterestButton")).setCallbackData("selectInterest"));
        button.thirdRow.add(new InlineKeyboardButton().setText(language.getString("countCompanionButton")).setCallbackData("selectCountCompanion"));
        button.fourthRow.add(new InlineKeyboardButton().setText(language.getString("selectLanguageButton")).setCallbackData("selectLanguage"));
        button.fifthRow.add(new InlineKeyboardButton().setText(language.getString("helpButton")).setCallbackData("help"));
        
        button.rowsInline.add(button.firstRow);
        button.rowsInline.add(button.secondRow);
        button.rowsInline.add(button.thirdRow);
        button.rowsInline.add(button.fourthRow);
        button.rowsInline.add(button.fifthRow);
        
        button.markupInline.setKeyboard(button.rowsInline);
        editMessageText.setReplyMarkup(button.markupInline);
        
		return editMessageText;
	}
}
