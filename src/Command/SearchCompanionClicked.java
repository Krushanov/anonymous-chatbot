package Command;
import UI.TelegramButton;

public class SearchCompanionClicked implements Command {
	private TelegramButton button;
	
	public SearchCompanionClicked(TelegramButton button) {
		this.button = button;
	}

	@Override
	public void execute() {
		button.searchCompanionClicked(null);
	}
}

