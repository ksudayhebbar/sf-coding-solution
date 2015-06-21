package com.pirates.game.crew.member;

public abstract class Keeper {
	private int keeperId;
	private int personalCount;
	protected final boolean istallyKeeper;
	protected boolean IsVisitedRoom;

	public int getPersonalCount() {
		return personalCount;
	}

	public void setPersonalCount(int personalCount) {
		this.personalCount = personalCount;
	}

	public boolean isIsVisitedRoom() {
		return IsVisitedRoom;
	}

	public boolean isIstallyKeeper() {
		return istallyKeeper;
	}

	public void setIsVisitedRoom(boolean isVisitedRoom) {
		IsVisitedRoom = isVisitedRoom;
	}

	public Keeper() {
		this.istallyKeeper = false;
		this.IsVisitedRoom = false;
	}

	public Keeper(int keeperId) {
		super();
		this.istallyKeeper = false;
		this.IsVisitedRoom = false;
		this.keeperId = keeperId;
	}

	public Keeper(boolean istallyKeeper, int keeperId) {
		super();
		this.istallyKeeper = istallyKeeper;
		this.IsVisitedRoom = false;
		this.keeperId = keeperId;
	}

	public int getKeeperId() {
		return keeperId;
	}

	@Override
	public String toString() {

		return " keeperId :" + keeperId + " personalCount : " + personalCount
				+ " istallyKeeper : " + istallyKeeper + " IsVisitedRoom : "
				+ IsVisitedRoom;
	}
}
