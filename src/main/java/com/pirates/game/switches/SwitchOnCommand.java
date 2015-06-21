package com.pirates.game.switches;


public class SwitchOnCommand implements Command {
	private Switch switchButtton;

	public SwitchOnCommand(Switch switchButtton) {
		this.switchButtton = switchButtton;
	}

	public void execute() {
		switchButtton.switchOn();
	}

}
