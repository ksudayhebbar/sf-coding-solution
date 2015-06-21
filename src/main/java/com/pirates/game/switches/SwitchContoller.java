package com.pirates.game.switches;


public class SwitchContoller {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void pressButton() {
		command.execute();
	}
}
