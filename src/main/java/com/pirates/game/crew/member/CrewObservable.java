package com.pirates.game.crew.member;

import com.pirates.game.crew.warden.CrewObserver;

public interface CrewObservable {
	public void addObserver(CrewObserver crewObserver);

	public void removeObserver(CrewObserver crewObserver) ;

	public void notifyObserver();
}
