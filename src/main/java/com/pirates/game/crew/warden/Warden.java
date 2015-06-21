package com.pirates.game.crew.warden;

import java.util.List;
import java.util.Random;

import com.pirates.game.crew.member.Keeper;
import com.pirates.game.crew.member.TallyKeeper;
import com.pirates.game.crew.room.Room;
import com.pirates.game.crew.room.SwitchRoom;
import com.pirates.game.crew.room.factory.CrewRoomFactory;
/* Warden is the observer for the tally keeper observer pattern used  */
public class Warden implements CrewObserver {

	public void update() {
		System.out.println("Warden receives notification from tallykeeper.....");
		List<Room> keeperRoom = CrewRoomFactory.getCrewRoomFactory()
				.getKeeperRoom();
		boolean vistorFlag = false;
		for (Room room : keeperRoom) {
			if (!room.getKeeper().isIsVisitedRoom()) {
				System.out.println("Warden verifys that " + room.getKeeper()
						+ " Not visited the switch room ... got angry ... ");
				vistorFlag = true;
				break;
			}
			System.out.println("Warden verified that "
					+ room.getKeeper().getKeeperId() + " visted");
		}
		if (vistorFlag) {
			System.out
					.println("Crew will be fed to the alligators. No NO NO  ....");

		} else {
			System.out.println("Crew will be Released ahhhhhhhhh");
		}
		keeperRoom.clear();
		System.exit(0);
	}

	public Warden() {
		// CrewRoomFactory.getCrewRoomFactory().fillKeeperRoom();
		List<Room> keeperRoom = CrewRoomFactory.getCrewRoomFactory()
				.getKeeperRoom();
		for (Room room : keeperRoom) {
			Keeper keeper = room.getKeeper();
			if (keeper.isIstallyKeeper()) {
				if (keeper instanceof TallyKeeper) {
					((TallyKeeper) keeper).addObserver(this);

				}
			}
		}
	}

	public void pickCrewMember() {
		Random randomGenerator = new Random();
		while (true) {
			int randomInt = randomGenerator
					.nextInt(CrewRoomFactory.CREW_MEMEBR_COUNT - 1);
			Keeper crewMembers = CrewRoomFactory.getCrewRoomFactory()
					.getCrewMembers(randomInt);
			if (crewMembers != null) {
				System.out.println(" Warden picked up " + crewMembers);
				SwitchRoom.getSwitchRoom().setKeeper(crewMembers);
				System.out.println(" Warden released up " + crewMembers);
			}
		}
	}
}
