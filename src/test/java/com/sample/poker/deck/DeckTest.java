package com.sample.poker.deck;

import org.junit.Before;
import org.junit.Test;

import com.sample.poker.card.Card;
import com.sample.poker.card.CardRank;
import com.sample.poker.card.CardSuit;
import com.sample.poker.deck.Deck;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DeckTest {

	private Deck deck;

	@Before
	public void setUp() {
		deck = new Deck();
	}

	@Test
	public void constructor_initializesWithNoCards() {
		assertEquals(0, deck.size());
	}

	@Test
	public void addCard() {
		Card card = new Card(CardRank.ACE, CardSuit.HEARTS);

		deck.addCard(card);

		assertEquals(1, deck.size());
	}

	@Test
	public void shuffle_returnsShuffledDeckOfEqualSize() {
		Card aceHearts = new Card(CardRank.ACE, CardSuit.HEARTS);
		Card aceDiamonds = new Card(CardRank.ACE, CardSuit.DIAMONDS);
		Card aceClubs = new Card(CardRank.ACE, CardSuit.CLUBS);
		Card aceSpades = new Card(CardRank.ACE, CardSuit.SPADES);
		deck.addCards(Arrays.asList(aceHearts, aceDiamonds, aceClubs, aceSpades));

		deck.shuffle();

		assertEquals(4, deck.size());
	}

	@Test
	public void removeFromTop_removeCardFromTopOfDeck() {
		Card expectedTopCard = new Card(CardRank.ACE, CardSuit.HEARTS);
		Card bottomCard = new Card(CardRank.ACE, CardSuit.DIAMONDS);
		deck.addCards(Arrays.asList(expectedTopCard, bottomCard));

		Card actualRemovedTopCard = deck.removeFromTop();

		assertEquals(expectedTopCard, actualRemovedTopCard);
	}

}