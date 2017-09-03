import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class AnonymousChatBot extends TelegramLongPollingBot {

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		Message message = update.getMessage();
		if (message != null && message.hasText()) {
			
			switch (message.getText()) {	
			case "/start":
				String first_name = message.getFrom().getFirstName();
				sendMsg(message, "������, " + first_name + "!\n���� ������������ ��� ��� ���������� �������. ������ ����� �� ����� ��������.");
				break;
			
			case "/help":
				sendMsg(message, "�����! ����� ����� ���-�� �����.");
				break;

			case "/stop":
				sendMsg(message, "��������, �� ��� ��������!");
				break;
				
			default:
				sendMsg(message, "�������, � ��� �� �����.");
				break;
			}
		}
	}

	@SuppressWarnings("deprecation")
	private void sendMsg(Message message, String text) {
		// TODO Auto-generated method stub
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.setReplyToMessageId(message.getMessageId());
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return System.getenv("bot_token");
	}
}
