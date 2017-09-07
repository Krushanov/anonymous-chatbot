package Main;

import java.util.ArrayList;
import java.util.List;

import Language.Language;
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
    public Language language;
    private Interest interest;

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
		language = new Language();
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
				SendMessage sendMessage1 = new SendMessage(message.getChatId(), language.getString("/start"));
				testMessage(sendMessage1);
				showMainMenu(message.getChatId());
				break;

			case "/commands":
				showMainMenu(message.getChatId());
				break;

			case "/stopchat":
				SendMessage sendMessage2 = new SendMessage(message.getChatId(), language.getString("/stopchat"));
				testMessage(sendMessage2);
				showMainMenu(message.getChatId());
				break;

			case "/about":
				SendMessage sendMessage3 = new SendMessage(message.getChatId(), language.getString("/about"));
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
				EditMessageText newMessage1 = new EditMessageText();
				newMessage1.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(language.getString("searchCompanion"));
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(searchCompanionCommand, newMessage1, language));
				
                break;
            
			case "help":
				EditMessageText newMessage2 = new EditMessageText();
				newMessage2.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(language.getString("help"));
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(helpCommand, newMessage2, language));

                break;
				
			case "back":
				EditMessageText newMessage3 = new EditMessageText();
				newMessage3.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(language.getString("selectCommand"));
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage3, language));

                break;
                
			case "cancelSearchCompanion":
				EditMessageText newMessage4 = new EditMessageText();
				newMessage4.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(language.getString("selectCommand"));
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage4, language));
                
                break;

			case "selectInterest":
				EditMessageText newMessage5 = new EditMessageText();
				newMessage5.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(language.getString("selectInterest"));
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(selectInterestCommand, newMessage5, language));

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
				interest = new Interest(language);
				String answer = interest.getString(index);
				EditMessageText newMessage = new EditMessageText();
				newMessage.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer);
                user.setInterest(index);
                button = new TelegramButton(anonymousChatBot);
				anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage, language));

                break;

			default:
				break;
			}
		}
	}
	
	private void showMainMenu(Long chatId) {
		SendMessage sendMessage = new SendMessage(chatId, language.getString("selectCommand"));
		Message message1 = testMessage(sendMessage);

		EditMessageText newMessage = new EditMessageText();
		newMessage.setChatId(chatId).setMessageId(message1.getMessageId()).setText(language.getString("selectCommand"));

		try {
			anonymousChatBot.editMessageText(button.onClick(mainMenuCommand, newMessage, language));
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
