import org.telegram.telegrambots.api.objects.User;

public class MyUser extends User {
	private long chatID;
	private int userID;
	private int interest;
	
	public MyUser(long chatID, int userID) {
		this.chatID = chatID;
		this.userID = userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getuserID() {
		return userID;
	}
	
	public void setChatID(long chatID) {
		this.chatID = chatID;
	}
	
	public long getChatID() {
		return chatID;
	}
}
