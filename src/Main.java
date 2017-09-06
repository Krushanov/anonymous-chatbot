import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

public class Main {

	public static void main(String[] args) {
		System.out.println("Запуск бота...");
		
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		
		try {
			telegramBotsApi.registerBot(new AnonymousChatBot());
			System.out.println("Бот запущен.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
