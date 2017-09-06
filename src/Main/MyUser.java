package Main;

public class MyUser {
	private Dialog dialog;
	private int userID;
	private long chatID;
	private String nameGenerated;
	private int interest;
	
	public MyUser(int userID, long chatID) {
		this.userID = userID;
		this.chatID = chatID;
	}
	
	public void generateName(String name) {
		
	}
	
	public int getUserID() {
		return userID;
	}
	
	public long getChatID() {
		return chatID;
	}
	
	public Dialog getDialog() {
		return dialog;
	}
	
	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
	}
	
	public void setInterest(int interest) {
		this.interest = interest;
	}
	
	public int getInterest() {
		return interest;
	}
}
