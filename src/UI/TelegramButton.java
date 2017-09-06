package UI;

import java.util.ArrayList;
import java.util.List;

import Main.AnonymousChatBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import Command.Command;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class TelegramButton {
	
	public InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
	public List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
    
	public List<InlineKeyboardButton> firstRow = new ArrayList<>();
	public List<InlineKeyboardButton> secondRow = new ArrayList<>();   
	public List<InlineKeyboardButton> thirdRow = new ArrayList<>();  
	public List<InlineKeyboardButton> fourthRow = new ArrayList<>();
	public List<InlineKeyboardButton> fifthRow = new ArrayList<>();
    public List<InlineKeyboardButton> sixthRow = new ArrayList<>();
	public List<InlineKeyboardButton> seventhRow = new ArrayList<>();
	public AnonymousChatBot bot;

    public TelegramButton(AnonymousChatBot bot) {
        this.bot = bot;
    }

	public EditMessageText onClick(Command command, EditMessageText editMessageText) {
        return command.execute(this, editMessageText, bot);
    }
}