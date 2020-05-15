package com.sample.poker.hand.utility;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.sample.poker.card.Card;
import com.sample.poker.card.CardRank;
import com.sample.poker.card.CardSuit;
import com.sample.poker.hand.utility.SortHelpers;

public class SortHelpersTest {
	SortHelpers sort = new SortHelpers();

	@Test
	public void sortBySuit_Test() {
		List<Card> handCards = Arrays.asList(
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.ACE, CardSuit.CLUBS),
				new Card(CardRank.QUEEN, CardSuit.DIAMONDS),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.KING, CardSuit.SPADES),
				new Card(CardRank.NINE, CardSuit.HEARTS)
		);
		
		List<Card> sortedBySuit = Arrays.asList(
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.KING, CardSuit.SPADES),
				new Card(CardRank.ACE, CardSuit.CLUBS),
				new Card(CardRank.QUEEN, CardSuit.DIAMONDS),
				new Card(CardRank.NINE, CardSuit.HEARTS)
		);
		
		assertEquals(sortedBySuit, sort.sortBySuit(handCards));
	}
	
	@Test
	public void sortByRank_Test() {
		List<Card> handCards = Arrays.asList(
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.ACE, CardSuit.CLUBS),
				new Card(CardRank.QUEEN, CardSuit.DIAMONDS),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.KING, CardSuit.SPADES),
				new Card(CardRank.NINE, CardSuit.DIAMONDS)
		);
		
		List<Card> sortedByRank = Arrays.asList(
				new Card(CardRank.ACE, CardSuit.CLUBS),
				new Card(CardRank.KING, CardSuit.SPADES),
				new Card(CardRank.QUEEN, CardSuit.DIAMONDS),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.NINE, CardSuit.DIAMONDS),
				new Card(CardRank.TWO, CardSuit.SPADES)
		);
		
		assertEquals(sortedByRank, sort.sortByRank(handCards));
	}

}
