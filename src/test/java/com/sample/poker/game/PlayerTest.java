package com.sample.poker.game;

import org.junit.Test;

import com.sample.poker.game.Player;

import static org.junit.Assert.*;

public class PlayerTest {

	@Test
	public void getName() {
		Player player = new Player("Name");

		assertEquals("Name", player.getName());
	}

}