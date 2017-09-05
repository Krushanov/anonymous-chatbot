import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import UI.TelegramButton;

public class Messager {
	private AnonymousChatBot anonymousChatBot;
	private TelegramButton button;
	
	HashTable users;
	List<List<Dialog>> freeDialogs;
	List<List<Dialog>> busyDialogs;
	
	public Messager(AnonymousChatBot anonymousChatBot) {
		this.anonymousChatBot = anonymousChatBot;
		freeDialogs = new ArrayList<List<Dialog>>();
		busyDialogs = new ArrayList<List<Dialog>>();
		users = new HashTable();
	}
	
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
				sendMessage = new SendMessage(message.getChatId(), "Добро пожаловать в Anonymous ChatBot, сервис для анонимного общения в сети Telegram.");
				testMessage(sendMessage);
				showMainMenu(message.getChatId());
				break;
			case "/commands":
				showMainMenu(message.getChatId());
			case "/stopchat":
				sendMessage = new SendMessage(message.getChatId(), "Беседа завершена.");
				testMessage(sendMessage);
				showMainMenu(message.getChatId());
				break;
			default:
				// Обработать как сообщение
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
				answer = "Поиск собеседника...";
                newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                try {
                	button = new TelegramButton();
                    anonymousChatBot.editMessageText(button.searchCompanionClicked(newMessage));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
				break;
            
			case "help":
				answer = "Здесь будут описаны команды.";
                newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                try {
                	button = new TelegramButton();
                    anonymousChatBot.editMessageText(button.helpClicked(newMessage));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
				break;
				
			case "back":
				answer = "Выберите команду:";
                newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                try {
                	button = new TelegramButton();
                    anonymousChatBot.editMessageText(button.backClicked(newMessage));
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                break;
                
			case "cancelSearchCompanion":
				answer = "Выберите команду:";
                newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                try {
                	button = new TelegramButton();
                    anonymousChatBot.editMessageText(button.cancelSearchCompanionClicked(newMessage));
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
		SendMessage sendMessage = new SendMessage(chatId, "Выберите команду:");
		button = new TelegramButton();
		testMessage(button.mainMenuClicked(sendMessage));
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
