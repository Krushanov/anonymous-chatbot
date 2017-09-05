package Command;
import UI.TelegramButton;

public class CanselSearchCompanionClicked implements Command {
	private TelegramButton button;
	
	public CanselSearchCompanionClicked(TelegramButton button) {
		this.button = button;
	}

	@Override
	public void execute() {
		button.cancelSearchCompanionClicked(null);
	}
}
