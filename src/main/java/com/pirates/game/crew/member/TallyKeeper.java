package com.pirates.game.crew.member;

import java.util.ArrayList;
import java.util.List;

import com.pirates.game.crew.warden.CrewObserver;
/* created based out observer pattern  */
public class TallyKeeper extends Keeper implements CrewObservable {
	public static final int PERSONAL_COUNT_THRESHHOLD = 2;
	private List<CrewObserver> crewObserver;

	public TallyKeeper(boolean isTallyKeeper, int keeperId) {
		super(isTallyKeeper, keeperId);
		crewObserver = new ArrayList<CrewObserver>();
	}

	public void addObserver(CrewObserver crewObserver) {
		this.crewObserver.add(crewObserver);
	}

	public void removeObserver(CrewObserver crewObserver) {
		this.crewObserver.remove(crewObserver);
	}

	public void notifyObserver() {
		for (CrewObserver crewOb : crewObserver) {
			crewOb.update();
		}

	}

	@Override
	public void setPersonalCount(int personalCount) {
		if (getPersonalCount() <= PERSONAL_COUNT_THRESHHOLD) {
			super.setPersonalCount(personalCount);
		} else {
			System.out
					.println("Crew Member   "
							+ this
							+ " Notify to Warden saying that we all  visted the Switch room.....");
			notifyObserver();
		}
	}
}
