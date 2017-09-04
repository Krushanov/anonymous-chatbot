import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class AnonymousChatBot extends TelegramLongPollingBot {
	private Messager messager;
	
	public AnonymousChatBot() {
		messager = new Messager();
	}
	
	@Override
	public String getBotUsername() {
		return "";
	}
	
	@Override
	public void onUpdateReceived(Update update) {
		messager.parsingUpdate(update);
	}
	
	@Override
	public String getBotToken() {
		return System.getenv("bot_token");
	}
}
