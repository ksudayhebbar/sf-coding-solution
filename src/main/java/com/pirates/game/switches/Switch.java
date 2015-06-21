package com.pirates.game.switches;

public class Switch {
	private boolean on;

	public void switchOn() {
		on = true;
	}

	public void switchOff() {
		on = false;
	}

	public boolean isOn() {
		return on;
	}

}
