package Command;
import UI.TelegramButton;

public class CompanionCountClicked implements Command {
	private TelegramButton button;
	
	public CompanionCountClicked(TelegramButton button) {
		this.button = button;
	}

	@Override
	public void execute() {
		button.companionCountClicked();
	}
}
