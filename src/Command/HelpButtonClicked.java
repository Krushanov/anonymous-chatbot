package Command;
import UI.TelegramButton;

public class HelpButtonClicked implements Command {
	private TelegramButton button;
	
	public HelpButtonClicked(TelegramButton button) {
		this.button = button;
	}

	@Override
	public void execute() {
		button.helpClicked(null);
	}
}
