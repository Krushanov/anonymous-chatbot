import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�������� ���...");
		
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		
		try {
			telegramBotsApi.registerBot(new AnonymousChatBot());
			System.out.println("��� �������.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
