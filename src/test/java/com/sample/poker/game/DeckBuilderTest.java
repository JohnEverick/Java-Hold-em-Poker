package com.sample.poker.game;

import org.junit.Test;

import com.sample.poker.deck.Deck;
import com.sample.poker.deck.DeckBuilder;

import static org.junit.Assert.*;

public class DeckBuilderTest {

	@Test
	public void buildDeck() {
		DeckBuilder deckBuilder = new DeckBuilder();

		Deck deck = deckBuilder.buildDeck();

		assertEquals(52, deck.size());
	}

}