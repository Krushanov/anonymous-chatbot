import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import Command.CloseDialogClicked;
import Command.Command;
import Command.CompanionCountClicked;
import Command.HelpButtonClicked;
import Command.MainMenuClicked;
import Command.SearchCompanionClicked;
import Command.SelectInterestClicked;
import UI.TelegramButton;

public class Messager {
	private AnonymousChatBot anonymousChatBot;
	private TelegramButton button;
	
	private HashTable users;
	private List<List<Dialog>> freeDialogs;
	private List<List<Dialog>> busyDialogs;
	
	//Commands
	private Command searchCompanionCommand;
	private Command selectInterestCommand;
	private Command companionCountCommand;
	private Command helpCommand;
	private Command closeDialogCommand;
	private Command mainMenuCommand;

	public Messager(AnonymousChatBot anonymousChatBot) {
		this.anonymousChatBot = anonymousChatBot;
		initObjects();
		initCommands();
	}
	
	// Init
	
	private void initObjects() {
		freeDialogs = new ArrayList<List<Dialog>>();
		busyDialogs = new ArrayList<List<Dialog>>();
		users = new HashTable();
	}
	
	private void initCommands() {
		this.searchCompanionCommand = new SearchCompanionClicked();
		this.selectInterestCommand = new SelectInterestClicked();
		this.companionCountCommand = new CompanionCountClicked();
		this.helpCommand = new HelpButtonClicked();
		this.closeDialogCommand = new CloseDialogClicked();
		this.mainMenuCommand = new MainMenuClicked();
	}
	
	// end Init
	
	private void sendMessage(MyUser user, String text) {

	}
	
	private void deleteUserFromDialog(MyUser user) {
		
	}
	
	private void addDialogFree(Dialog dialog) {
		freeDialogs.get(dialog.getInterest()).add(dialog);
	}
	
	private void addBusyDialog(Dialog dialog) {
		busyDialogs.get(dialog.getInterest()).add(dialog);
	}
	
	private void addUserToFree(MyUser user) {
		
	}
	
	public void parsingUpdate(Update update) {	
		Message message = update.getMessage();
		SendMessage sendMessage;
		String messageText;
		
		if (update.hasMessage() && update.getMessage().hasText()) {
			switch (update.getMessage().getText()) {
			
			case "/start":
				sendMessage = new SendMessage(message.getChatId(), "����� ���������� � Anonymous ChatBot, ������ ��� ���������� ������� � ���� Telegram.");
				testMessage(sendMessage);
				showMainMenu(message.getChatId());
				break;
			
			case "/commands":
				showMainMenu(message.getChatId());
				break;
			
			case "/stopchat":
				sendMessage = new SendMessage(message.getChatId(), "������ ���������.");
				testMessage(sendMessage);
				showMainMenu(message.getChatId());
				break;
			
			default:
				// ���������� ��� ���������
				break;
			}
			
		} else if (update.hasCallbackQuery()) {
			String callData = update.getCallbackQuery().getData();
			
			long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            
            String answer;
            EditMessageText newMessage = new EditMessageText();
            
            switch (callData) {
            
            case "searchCompanion":
				answer = "����� �����������...";
                newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                
                try {
                	button = new TelegramButton();
                    anonymousChatBot.editMessageText(button.onClick(searchCompanionCommand, newMessage));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
				
                break;
            
			case "help":
				answer = "����� ����� ������� �������.";
                newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                
                try {
                	button = new TelegramButton();
                    anonymousChatBot.editMessageText(button.onClick(helpCommand, newMessage));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
				
                break;
				
			case "back":
				answer = "�������� �������:";
                newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                
                try {
                	button = new TelegramButton();
                    anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                
                break;
                
			case "cancelSearchCompanion":
				answer = "�������� �������:";
                newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                
                try {
                	button = new TelegramButton();
                	
                	/* ���������, �������� �������,
                	 * ����������� ��.
                	 */
                	
                    anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage));
                    
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                
                break;

			default:
				break;
			}
		}
	}
	
	private void showMainMenu(Long chatId) {
		SendMessage sendMessage = new SendMessage(chatId, "�������� �������:");
		button = new TelegramButton();
	//	anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, sendMessage));
	}

	private void testMessage(SendMessage sendMessage) {
		try {
			anonymousChatBot.sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
