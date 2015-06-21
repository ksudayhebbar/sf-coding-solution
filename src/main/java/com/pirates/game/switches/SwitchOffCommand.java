package com.pirates.game.switches;


public class SwitchOffCommand implements Command {
	private Switch switchButtton;

	public SwitchOffCommand(Switch switchButtton) {
		this.switchButtton = switchButtton;
	}

	public void execute() {
		switchButtton.switchOff();
	}

}
