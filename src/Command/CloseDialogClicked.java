package Command;
import UI.TelegramButton;

public class CloseDialogClicked implements Command {
	private TelegramButton button;
	
	public CloseDialogClicked(TelegramButton button) {
		this.button = button;
	}

	@Override
	public void execute() {
		button.closeDialogClicked();
	}
}
