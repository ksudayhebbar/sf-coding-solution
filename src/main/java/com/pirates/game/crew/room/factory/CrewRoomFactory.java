package com.pirates.game.crew.room.factory;

import java.util.ArrayList;
import java.util.List;

import com.pirates.game.crew.member.Keeper;
import com.pirates.game.crew.member.NonTallyKeeper;
import com.pirates.game.crew.member.TallyKeeper;
import com.pirates.game.crew.room.KeeperRoom;
import com.pirates.game.crew.room.Room;

public final class CrewRoomFactory {
	public static final int CREW_MEMEBR_COUNT = 23;
	private static final CrewRoomFactory crewRoomFactory = new CrewRoomFactory();
	private List<Room> keeperRoom = new ArrayList<Room>(CREW_MEMEBR_COUNT);

	private CrewRoomFactory() {
		fillKeeperRoom();
	}

	public static CrewRoomFactory getCrewRoomFactory() {
		
		return crewRoomFactory;
	}

	public Keeper getCrewMembers(int index) {
		if ((index > 0 || index <= keeperRoom.size())) {
			Room room = keeperRoom.get(index);
			return room.getKeeper();

		}

		return null;

	}

	protected void fillKeeperRoom() {
		for (int i = 0; i < CREW_MEMEBR_COUNT - 2; i++) {
			keeperRoom.add(new KeeperRoom(new NonTallyKeeper(i)));

		}
		int keeperid = keeperRoom.size() + 1;
		keeperRoom.add(new KeeperRoom(new TallyKeeper(true, keeperid)));
	}

	public List<Room> getKeeperRoom() {
		return keeperRoom;
	}
}
