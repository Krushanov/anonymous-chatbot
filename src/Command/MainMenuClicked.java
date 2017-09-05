package Command;
import UI.TelegramButton;

public class MainMenuClicked implements Command {
	private TelegramButton button;
	
	public MainMenuClicked(TelegramButton button) {
		this.button = button;
	}

	@Override
	public void execute() {
		button.mainMenuClicked(null);
	}
}
