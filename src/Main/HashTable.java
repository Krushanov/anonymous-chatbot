package Main;

import java.util.ArrayList;

public class HashTable {
	private ArrayList<MyUser> users;
	private final int MAX_COUNT;	
	
	public HashTable() {
		MAX_COUNT = 10000;
		users = new ArrayList(MAX_COUNT);
		for (int i = 0; i < MAX_COUNT; i++)
			users.add(null);
	}
	
	public boolean addUser(MyUser user) {
		boolean result = false;
		int i = getHash(user.getUserID() + "");
		
		if ( users.get(i) == null ) {
			users.add(i, user);
			result = true;
		}
		
		return result;
	}
	
	private int getHash(String text) {
		int a = 54059; 
        int b = 76963; 
        int FIRSTH = 37;
        int h = FIRSTH;
        int i = 0;
        char c[] = text.toCharArray();
        
        while ( i < text.length() )
        {
            h = (h * a) ^ (c[i] * b);
            i++;
        }
        
        return Math.abs(h % MAX_COUNT);

	}
	
	public boolean deleteUser(int userID) {
		boolean result = false;
		int i = 0;
		
		if ( hasUser(userID) ) {
			i = getHash(userID + "");
			users.set(i, null);
			result = true;
		}
			
		return result;
	}
		
	public boolean hasUser(int userID) {
		boolean result = false;
		int i = getHash(userID + "");
		
		if (users.get(i) != null && users.get(i).getUserID() == userID) {
			result = true;
		}
			
		return result;
	}

	public MyUser searchUser(int userID) {
		int i = getHash(userID + "");

		return users.get(i);
	}
}
