package Main;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;

public class Dialog {
	private ArrayList<MyUser> users;
	private int maxSize;
	private int interest;
	private AnonymousChatBot bot;
	
	public Dialog(int interst, int maxSize, AnonymousChatBot bot) {
		this.interest = interst;
		this.maxSize = maxSize;
		this.bot = bot;
		users = new ArrayList();
	}
	
	public void sendMessage(MyUser user,String text) throws TelegramApiException {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setText(user.getNameGenerated() + text);

		for (MyUser u : users) {
			if (u.getUserID() != user.getUserID()) {
				sendMessage.setChatId(u.getChatID());
				bot.sendMessage(sendMessage);
			}
		}
	}

	public int getMaxSize() {
		return maxSize;
	}
	
	public boolean hasFree() {
		return users.size() < maxSize;
	}
	
	public void addUser(MyUser user) throws TelegramApiException {
		user.generateName(users.size() + 1);
		sendMessage(user, user.getNameGenerated() + "joined to the dialog. ");
		users.add(user);
	}
	
	public void deleteUser(MyUser user) {
		user.setDialog(null);
		users.remove(user);
	}

	public int getCount() {
		return users.size();
	}
	
	public void setInterest(int interest) {
		this.interest = interest;
	}
	
	public int getInterest() {
		return interest;
	}
}
