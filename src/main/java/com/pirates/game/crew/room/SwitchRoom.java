package com.pirates.game.crew.room;

import com.pirates.game.crew.member.Keeper;
import com.pirates.game.switches.Command;
import com.pirates.game.switches.Switch;
import com.pirates.game.switches.SwitchContoller;
import com.pirates.game.switches.SwitchOffCommand;
import com.pirates.game.switches.SwitchOnCommand;

public final class SwitchRoom extends Room {
	private static final SwitchRoom switchRoom = new SwitchRoom();
	private Switch leftSwitch;
	private Switch rightSwitch;
	private Command leftSwitchOn;
	private Command leftSwitchOff;
	private Command rightSwitchOn;
	private Command rightSwitchOff;
	private SwitchContoller switchContoller;

	private SwitchRoom() {
		leftSwitch = new Switch();
		rightSwitch = new Switch();
		leftSwitchOn = new SwitchOnCommand(leftSwitch);
		leftSwitchOff = new SwitchOffCommand(leftSwitch);
		rightSwitchOn = new SwitchOnCommand(rightSwitch);
		rightSwitchOff = new SwitchOffCommand(rightSwitch);
		switchContoller = new SwitchContoller();
	}

	public static SwitchRoom getSwitchRoom() {
		return switchRoom;
	}

	@Override
	public void setKeeper(Keeper keeper) {
		System.out.println("Crew memember" + keeper + " enter the switch room");
		synchronized (keeper) {
			super.setKeeper(keeper);
			keeper.setIsVisitedRoom(true);
			if (!keeper.isIstallyKeeper()) {
				if (keeper.getPersonalCount() < 1) {

					excuteLeftSwitch(keeper);
				} else {
					excuteRightSwitch(keeper);
				}
			} else {
				excuteRightSwitch(keeper);
			}
			int count = keeper.getPersonalCount();
			count++;
			keeper.setPersonalCount(count);
		}
	}

	private void excuteLeftSwitch(Keeper keeper) {
		synchronized (keeper) {
			System.out.println("Crew memember" + keeper
					+ " based on personal count choosen the left switch");
			if (leftSwitch.isOn()) {
				switchContoller.setCommand(leftSwitchOff);
				switchContoller.pressButton();
				System.out.println("Crew memember" + keeper
						+ " left switch is ON make it OFF ");
			} else {
				switchContoller.setCommand(leftSwitchOn);
				switchContoller.pressButton();
				System.out.println("Crew memember" + keeper
						+ " left switch is OFF make it ON ");
			}
		}
	}

	private void excuteRightSwitch(Keeper keeper) {
		synchronized (keeper) {
			System.out.println("Crew memember" + keeper
					+ " based on personal count choosen the right switch");
			if (rightSwitch.isOn()) {
				switchContoller.setCommand(rightSwitchOff);
				switchContoller.pressButton();
				System.out.println("Crew memember" + keeper
						+ " right switch is ON make it OFF ");
			} else {
				switchContoller.setCommand(rightSwitchOn);
				switchContoller.pressButton();
				System.out.println("Crew memember" + keeper
						+ " right switch is OFF make it ON ");
			}
		}
	}

}
