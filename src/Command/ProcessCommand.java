package Command;

public class ProcessCommand {
	private Command searchCompanionCommand;
	private Command selectInterestCommand;
	private Command companionCountCommand;
	private Command helpCommand;
	private Command closeDialogCommand;
	private Command mainMenuCommand;
	
	public ProcessCommand(Command searchCompanionCommand, Command selectInterestCommand,
			Command companionCountCommand, Command helpCommand, 
			Command closeDialogCommand, Command backCommand) {	
		
		this.searchCompanionCommand = searchCompanionCommand;
		this.selectInterestCommand = selectInterestCommand;
		this.companionCountCommand = companionCountCommand;
		this.helpCommand = helpCommand;
		this.closeDialogCommand = closeDialogCommand;
		this.mainMenuCommand = backCommand;
	}
	
	public void searchCompanionClicked() {
		searchCompanionCommand.execute();
	}
	
	public void selectInterestClicked() {
		selectInterestCommand.execute();
	}
	
	public void companionCountClicked() {
		companionCountCommand.execute();
	}
	
	public void helpClicked() {
		helpCommand.execute();
	}
	
	public void closeDialogClicked() {
		closeDialogCommand.execute();
	}
	
	public void mainMenuClicked() {
		mainMenuCommand.execute();
	}
}
