package Command;
import UI.TelegramButton;

public class SelectInterestClicked implements Command {
	private TelegramButton button;
	
	public SelectInterestClicked(TelegramButton button) {
		this.button = button;
	}

	@Override
	public void execute() {
		button.selectInterestClicked();
	}
}
