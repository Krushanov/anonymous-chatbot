package UI;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import Command.Command;

public class TelegramButton {
	
	public InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
	public List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
    
	public List<InlineKeyboardButton> firstRow = new ArrayList<>();
	public List<InlineKeyboardButton> secondRow = new ArrayList<>();   
	public List<InlineKeyboardButton> thirdRow = new ArrayList<>();  
	public List<InlineKeyboardButton> fourthRow = new ArrayList<>();
    
	public TelegramButton() { }
	
	public EditMessageText onClick(Command command, EditMessageText editMessageText) {
		 return command.execute(this, editMessageText);
	}
}