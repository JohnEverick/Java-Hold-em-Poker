package com.sample.poker.card;

import org.junit.Test;

import com.sample.poker.card.Card;
import com.sample.poker.card.CardRank;
import com.sample.poker.card.CardSuit;

import static org.junit.Assert.*;

public class CardTest {

	@Test
	public void testCardEquality_sameRankAndSuitAreConsideredEqual() {
		Card card1 = new Card(CardRank.ACE, CardSuit.DIAMONDS);
		Card card2 = new Card(CardRank.ACE, CardSuit.DIAMONDS);

		assertEquals(card1, card2);
	}

	@Test
	public void testCardEquality_differentRankAndSuitAreNotEqual() {
		Card card1 = new Card(CardRank.ACE, CardSuit.DIAMONDS);
		Card card2 = new Card(CardRank.KING, CardSuit.DIAMONDS);

		assertNotEquals(card1, card2);
	}

	@Test
	public void styleClass_whenDiamondsOrHearts_returnsRedClass() {
		Card card1 = new Card(CardRank.ACE, CardSuit.DIAMONDS);
		Card card2 = new Card(CardRank.ACE, CardSuit.HEARTS);

		assertEquals("card-red", card1.styleClass());
		assertEquals("card-red", card2.styleClass());
	}

	@Test
	public void styleClass_whenClubsOrSpades_returnsBlackClass() {
		Card card1 = new Card(CardRank.ACE, CardSuit.CLUBS);
		Card card2 = new Card(CardRank.ACE, CardSuit.SPADES);

		assertEquals("card-black", card1.styleClass());
		assertEquals("card-black", card2.styleClass());
	}

}