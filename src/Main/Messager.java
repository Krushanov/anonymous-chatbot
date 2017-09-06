package Main;

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
	private HashTable users;
    private MyUser user;

	private List<List<Dialog>> freeDialogs;
	private List<List<Dialog>> busyDialogs;

	private TelegramButton button;
	
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
		button = new TelegramButton(anonymousChatBot);
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
	
	public void parsingUpdate(Update update) throws TelegramApiException {
		Message message = update.getMessage();
		String messageText;

		if (update.hasMessage() && update.getMessage().hasText()) {
			int userID = update.getMessage().getFrom().getId();
			long chatID = update.getMessage().getChatId();

		    if ( (user = users.searchUser(userID)) == null ) {
                user = new MyUser(userID, chatID);
                users.addUser(user);
            }

            switch (update.getMessage().getText()) {

			case "/start":
				SendMessage sendMessage1 = new SendMessage(message.getChatId(), "Добро пожаловать в Anonymous ChatBot, сервис для анонимного общения в сети Telegram.");
				testMessage(sendMessage1);
				showMainMenu(message.getChatId());
				break;

			case "/commands":
				showMainMenu(message.getChatId());
				break;

			case "/stopchat":
				SendMessage sendMessage2 = new SendMessage(message.getChatId(), "Вы покинули чат.");
				testMessage(sendMessage2);
				showMainMenu(message.getChatId());
				break;

			case "/about":
				SendMessage sendMessage3 = new SendMessage(message.getChatId(), "Информация о кисях разработчиках.");
				testMessage(sendMessage3);
				showMainMenu(message.getChatId());
				break;

			case "/rate":
				System.out.println("Функция оценки бота");
				break;

			default:
				// обработать как сообщение
				break;
			}

		} else if (update.hasCallbackQuery()) {
			String callData = update.getCallbackQuery().getData();
			
			long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            switch (callData) {
            
            case "searchCompanion":
				String answer1 = "Поиск собеседника...";
				EditMessageText newMessage1 = new EditMessageText();
				newMessage1.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer1);
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(searchCompanionCommand, newMessage1));
				
                break;
            
			case "help":
				String answer2 = "Здесь будет описание команд.";
				EditMessageText newMessage2 = new EditMessageText();
				newMessage2.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer2);
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(helpCommand, newMessage2));

                break;
				
			case "back":
				String answer3 = "Выберите команду:";
				EditMessageText newMessage3 = new EditMessageText();
				newMessage3.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer3);
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage3));

                break;
                
			case "cancelSearchCompanion":
				String answer4 = "Выберите команду:";
				EditMessageText newMessage4 = new EditMessageText();
				newMessage4.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer4);
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage4));
                
                break;

			case "selectInterest":
				String answer5 = "Выберите тематику переписки:";
				EditMessageText newMessage5 = new EditMessageText();
				newMessage5.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer5);
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(selectInterestCommand, newMessage5));

				break;

			// Обработка выбора категорий
			case "/setInterest 0":
			case "/setInterest 1":
			case "/setInterest 2":
			case "/setInterest 3":
            case "/setInterest 4":
            case "/setInterest 5":
            case "/setInterest 6":
                int index = Integer.parseInt( callData.substring(13) );
				String answer = Interest.getString(index);
				EditMessageText newMessage = new EditMessageText();
				newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                user.setInterest(index);
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage));

                break;

			default:
				break;
			}
		}
	}
	
	private void showMainMenu(Long chatId) {
		SendMessage sendMessage = new SendMessage(chatId, "Выберите команду:");
		Message message1 = testMessage(sendMessage);

		EditMessageText newMessage = new EditMessageText();
		newMessage.setChatId(chatId).setMessageId(message1.getMessageId()).setText("Выберите команду:");

		try {
			anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	private void showInterests(Long chatId) {

	}

	private Message testMessage(SendMessage sendMessage) {
		Message message = new Message();

		try {
			message = anonymousChatBot.sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}

	public MyUser getUser() {
	    return user;
    }
}
