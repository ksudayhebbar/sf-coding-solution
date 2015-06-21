package com.pirates.game;

import com.pirates.game.crew.warden.Warden;

public class PiratesMain {
	public static void main(String[] args) {
		System.out.println("Start the Game by picking crew member   from room");
		new Warden().pickCrewMember();
	}
}
