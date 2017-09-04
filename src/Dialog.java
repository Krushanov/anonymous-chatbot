import java.util.ArrayList;

public class Dialog {
	private ArrayList<User> users;
	private int maxSize;
	private int interest;
	
	public Dialog(int interst, int maxSize) {
		this.interest = interst;
		this.maxSize = maxSize;
		users = new ArrayList(maxSize);
	}
	
	public void sendMessage() {
		
	}
	
	public boolean hasFree() {
		boolean result = false;
		
		if ( users.size() < maxSize )
			result = true;
		
		return result;
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void deleteUser(User user) {
		users.remove(user);
	}
	
	public void setInterest(int interest) {
		this.interest = interest;
	}
	
	public int getInterest() {
		return interest;
	}
}
