package com.pirates.game.crew.room;

import com.pirates.game.crew.member.Keeper;

public abstract class Room {

	protected Keeper keeper;

	public Room() {

	}

	public Room(Keeper keeper) {
		super();
		this.keeper = keeper;
	}

	public Keeper getKeeper() {
		return keeper;
	}

	public void setKeeper(Keeper keeper) {
		this.keeper = keeper;
	}
}
