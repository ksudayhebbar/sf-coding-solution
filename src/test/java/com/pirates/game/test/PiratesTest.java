package com.pirates.game.test;

import org.junit.Test;

import com.pirates.game.crew.warden.Warden;

public class PiratesTest {
	@Test
	public void piratesTest() {

		System.out.println("Start the Game by picking crew member   from room");

		new Warden().pickCrewMember();

	}
}
