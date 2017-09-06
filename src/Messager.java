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
	
	public void parsingUpdate(Update update) throws TelegramApiException {
		Message message = update.getMessage();
		String messageText;
		
		if (update.hasMessage() && update.getMessage().hasText()) {
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

				TelegramButton button1 = new TelegramButton();
				anonymousChatBot.editMessageText(button1.onClick(searchCompanionCommand, newMessage1));
				
                break;
            
			case "help":
				String answer2 = "Здесь будет описание команд.";
				EditMessageText newMessage2 = new EditMessageText();
				newMessage2.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer2);

				TelegramButton button2 = new TelegramButton();
				anonymousChatBot.editMessageText(button2.onClick(helpCommand, newMessage2));

                break;
				
			case "back":
				String answer3 = "Выберите команду:";
				EditMessageText newMessage3 = new EditMessageText();
				newMessage3.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer3);

				TelegramButton button3 = new TelegramButton();
				anonymousChatBot.editMessageText(button3.onClick(mainMenuCommand, newMessage3));

                break;
                
			case "cancelSearchCompanion":
				String answer4 = "Выберите команду:";
				EditMessageText newMessage4 = new EditMessageText();
				newMessage4.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer4);

				TelegramButton button4 = new TelegramButton();
				anonymousChatBot.editMessageText(button4.onClick(mainMenuCommand, newMessage4));
                
                break;

			case "selectInterest":
				String answer5 = "Выберите тематику переписки:";
				EditMessageText newMessage5 = new EditMessageText();
				newMessage5.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer5);

				TelegramButton button5 = new TelegramButton();
				anonymousChatBot.editMessageText(button5.onClick(selectInterestCommand, newMessage5));

				break;

			// Обработка выбора категорий
			case "allInterest":
				String answer6 = "Отлично! Теперь вы будете общаться на любые темы.";
				EditMessageText newMessage6 = new EditMessageText();
				newMessage6.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer6);

				TelegramButton button6 = new TelegramButton();
				anonymousChatBot.editMessageText(button6.onClick(mainMenuCommand, newMessage6));

				break;

			case "musicInterest":
				String answer7 = "Отлично! Теперь вы будете говорить о музыке.";
				EditMessageText newMessage7 = new EditMessageText();
				newMessage7.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer7);

				TelegramButton button7 = new TelegramButton();
				anonymousChatBot.editMessageText(button7.onClick(mainMenuCommand, newMessage7));

				break;

			case "filmsInterest":
				String answer8 = "Отлично! Теперь вы будете говорить о фильмах.";
				EditMessageText newMessage8 = new EditMessageText();
				newMessage8.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer8);

				TelegramButton button8 = new TelegramButton();
				anonymousChatBot.editMessageText(button8.onClick(mainMenuCommand, newMessage8));

				break;

			case "gamesInterest":
				String answer9 = "Отлично! Теперь вы будете говорить об играх.";
				EditMessageText newMessage9 = new EditMessageText();
				newMessage9.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer9);

				TelegramButton button9 = new TelegramButton();
				anonymousChatBot.editMessageText(button9.onClick(mainMenuCommand, newMessage9));

				break;

			case "itInterest":
				String answer10 = "Отлично! Теперь вы будете говорить об IT.";
				EditMessageText newMessage10 = new EditMessageText();
				newMessage10.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer10);

				TelegramButton button10 = new TelegramButton();
				anonymousChatBot.editMessageText(button10.onClick(mainMenuCommand, newMessage10));

				break;

			case "sexInterest":
				String answer11 = "Отлично! Теперь вы будете говорить о сексе.";
				EditMessageText newMessage11 = new EditMessageText();
				newMessage11.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer11);

				TelegramButton button11 = new TelegramButton();
				anonymousChatBot.editMessageText(button11.onClick(mainMenuCommand, newMessage11));

				break;


			case "psychologyInterest":
				String answer12 = "Отлично! Теперь вы будете говорить о психологии.";
				EditMessageText newMessage12 = new EditMessageText();
				newMessage12.setChatId(chatId).setMessageId((int)(long)(messageId)).setText(answer12);

				TelegramButton button12 = new TelegramButton();
				anonymousChatBot.editMessageText(button12.onClick(mainMenuCommand, newMessage12));

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
			TelegramButton button5 = new TelegramButton();
			anonymousChatBot.editMessageText(button5.onClick(mainMenuCommand, newMessage));
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
}
