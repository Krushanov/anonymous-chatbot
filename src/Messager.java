import java.util.ArrayList;
import java.util.List;
import org.telegram.telegrambots.api.objects.Update;

public class Messager {
	HashTable users;
	List<List<Dialog>> freeDialogs;
	List<List<Dialog>> busyDialogs;
	
	public Messager() {
		freeDialogs = new ArrayList<List<Dialog>>();
		busyDialogs = new ArrayList<List<Dialog>>();
		users = new HashTable();
	}
	
	private void sendMessage(MyUser user, String text) {
		
	}
	
	private void deleteUserFromDialog(MyUser user) {
		
	}
	
	private void addDialogFree(Dialog dialog) {
		freeDialogs.get(dialog.getInterest()).add(dialog);
	}
	
	private void addBusyDialog(Dialog dialog) {
		busyDialogs.get(dialog.getInterest()).add(dialog);
	}
	
	private void addUserToFree(MyUser user) {
		
	}
	
	public void parsingUpdate(Update update) {

	}
}
