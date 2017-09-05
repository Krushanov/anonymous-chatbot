package UI;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class TelegramButton {
	
    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
    
    List<InlineKeyboardButton> firstRow = new ArrayList<>();
    List<InlineKeyboardButton> secondRow = new ArrayList<>();   
    List<InlineKeyboardButton> thirdRow = new ArrayList<>();  
    List<InlineKeyboardButton> fourthRow = new ArrayList<>();
    
	public TelegramButton() { }
	
	public EditMessageText searchCompanionClicked(EditMessageText editMessageText) {
		firstRow.add(new InlineKeyboardButton().setText("Отмена").setCallbackData("cancelSearchCompanion"));
		
		rowsInline.add(firstRow);
        markupInline.setKeyboard(rowsInline);
        editMessageText.setReplyMarkup(markupInline);
        
        return editMessageText;
	}
	
	public void selectInterestClicked() {

	}
	
	public void companionCountClicked() {

	}
	
	public void closeDialogClicked() {
		
	}
	
	public EditMessageText helpClicked(EditMessageText editMessageText) {
		firstRow.add(new InlineKeyboardButton().setText("Назад").setCallbackData("back"));
		
		rowsInline.add(firstRow);
        markupInline.setKeyboard(rowsInline);
        editMessageText.setReplyMarkup(markupInline);
        
        return editMessageText;
	}
	
	public SendMessage mainMenuClicked(SendMessage message) {
		firstRow.add(new InlineKeyboardButton().setText("Найти собеседника").setCallbackData("searchCompanion"));
        secondRow.add(new InlineKeyboardButton().setText("Выбрать тематику переписки").setCallbackData("selectInterest"));
        thirdRow.add(new InlineKeyboardButton().setText("Задать кол-во собеседников").setCallbackData("companionCount"));
        fourthRow.add(new InlineKeyboardButton().setText("Помощь").setCallbackData("help"));
        
        rowsInline.add(firstRow);
        rowsInline.add(secondRow);
        rowsInline.add(thirdRow);
        rowsInline.add(fourthRow);
        
        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);
        
        return message;
	}

	public EditMessageText backClicked(EditMessageText editMessageText) {
		firstRow.add(new InlineKeyboardButton().setText("Найти собеседника").setCallbackData("searchCompanion"));
        secondRow.add(new InlineKeyboardButton().setText("Выбрать тематику переписки").setCallbackData("selectInterest"));
        thirdRow.add(new InlineKeyboardButton().setText("Задать кол-во собеседников").setCallbackData("companionCount"));
        fourthRow.add(new InlineKeyboardButton().setText("Помощь").setCallbackData("help"));
        
        rowsInline.add(firstRow);
        rowsInline.add(secondRow);
        rowsInline.add(thirdRow);
        rowsInline.add(fourthRow);
        
        markupInline.setKeyboard(rowsInline);
        editMessageText.setReplyMarkup(markupInline);
        
		return editMessageText;
	}
	
	public EditMessageText cancelSearchCompanionClicked(EditMessageText editMessageText) {        
        return backClicked(editMessageText);
	}
}