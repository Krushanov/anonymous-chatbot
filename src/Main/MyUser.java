package Main;

public class MyUser {
	private Dialog dialog;
	private int userID;
	private long chatID;
	private String nameGenerated;
	private int interest;
	private int language;
	private int countCompanion;
	
	public MyUser(int userID, long chatID) {
		this.userID = userID;
		this.chatID = chatID;
		dialog = null;
		countCompanion = 2;
	}
	
	public void generateName(int number) {
		nameGenerated = "User " + number + ": ";
	}

	public String getNameGenerated() {
		return nameGenerated;
	}

	public void setCountCompanion(int countCompanion) {
		this.countCompanion = countCompanion;
	}

	public int getCountCompanion() {
		return countCompanion;
	}
	
	public int getUserID() {
		return userID;
	}

	public boolean hasDialog() {
		return dialog != null;
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

    public void setLanguage(int language) {
        this.language = language;
    }

	public int getLanguage() {
		return language;
	}

}
