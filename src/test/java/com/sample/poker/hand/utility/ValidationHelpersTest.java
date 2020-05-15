package com.sample.poker.hand.utility;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.sample.poker.card.Card;
import com.sample.poker.card.CardRank;
import com.sample.poker.card.CardSuit;
import com.sample.poker.hand.utility.ValidationHelpers;

public class ValidationHelpersTest {
	
	ValidationHelpers validate = new ValidationHelpers();

	@Test
	public void isStraighFlush_Test() {
		List<Card> playerCards = Arrays.asList(
				new Card(CardRank.ACE, CardSuit.SPADES),
				new Card(CardRank.KING, CardSuit.SPADES)
		);

		List<Card> handCards = Arrays.asList(
				new Card(CardRank.ACE, CardSuit.SPADES),
				new Card(CardRank.KING, CardSuit.SPADES),
				new Card(CardRank.QUEEN, CardSuit.SPADES),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.NINE, CardSuit.SPADES),
				new Card(CardRank.ACE, CardSuit.CLUBS)
		);

		assertTrue(validate.isStraightFlush(handCards, playerCards));
	}

	@Test
	public void isFourOfAKind_Test() {
		List<Card> playerCards = Arrays.asList(
				new Card(CardRank.EIGHT, CardSuit.SPADES),
				new Card(CardRank.EIGHT, CardSuit.CLUBS)
		);

		List<Card> handCards = Arrays.asList(
				new Card(CardRank.EIGHT, CardSuit.SPADES),
				new Card(CardRank.EIGHT, CardSuit.CLUBS),
				new Card(CardRank.EIGHT, CardSuit.DIAMONDS),
				new Card(CardRank.EIGHT, CardSuit.HEARTS),
				new Card(CardRank.SEVEN, CardSuit.SPADES),
				new Card(CardRank.SIX, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.CLUBS)
		);
		
		assertTrue(validate.isFourOfAKind(handCards, playerCards));
	}

	@Test
	public void isFullHouse_Test() {
		List<Card> playerCards = Arrays.asList(
				new Card(CardRank.EIGHT, CardSuit.SPADES),
				new Card(CardRank.EIGHT, CardSuit.DIAMONDS)
		);

		List<Card> handCards = Arrays.asList(
				new Card(CardRank.EIGHT, CardSuit.SPADES),
				new Card(CardRank.EIGHT, CardSuit.DIAMONDS),
				new Card(CardRank.SEVEN, CardSuit.HEARTS),
				new Card(CardRank.SEVEN, CardSuit.SPADES),
				new Card(CardRank.EIGHT, CardSuit.CLUBS),
				new Card(CardRank.NINE, CardSuit.SPADES),
				new Card(CardRank.ACE, CardSuit.CLUBS)
		);
		
		assertTrue(validate.isFullHouse(handCards, playerCards));
	}

	@Test
	public void isFlush_Test() {
		List<Card> playerCards = Arrays.asList(
				new Card(CardRank.SEVEN, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.SPADES)
		);

		List<Card> handCards = Arrays.asList(
				new Card(CardRank.SEVEN, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.QUEEN, CardSuit.SPADES),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.NINE, CardSuit.SPADES),
				new Card(CardRank.ACE, CardSuit.CLUBS)
		);
		
		assertTrue(validate.isFlush(handCards, playerCards));
	}

	@Test
	public void isStraight_Test() {
		List<Card> playerCards = Arrays.asList(
				new Card(CardRank.EIGHT, CardSuit.SPADES),
				new Card(CardRank.KING, CardSuit.CLUBS)
		);

		List<Card> handCards = Arrays.asList(
				new Card(CardRank.EIGHT, CardSuit.SPADES),
				new Card(CardRank.KING, CardSuit.CLUBS),
				new Card(CardRank.QUEEN, CardSuit.DIAMONDS),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.NINE, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.CLUBS)
		);
		
		assertTrue(validate.isStraight(handCards, playerCards));
	}

	@Test
	public void isThreeOfAKind_Test() {
		List<Card> playerCards = Arrays.asList(
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.CLUBS)
		);

		List<Card> handCards = Arrays.asList(
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.CLUBS),
				new Card(CardRank.QUEEN, CardSuit.DIAMONDS),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.NINE, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.DIAMONDS)
		);
		
		assertTrue(validate.isThreeOfAKind(handCards, playerCards));
	}

	@Test
	public void isTwoPair_Test() {
		List<Card> playerCards = Arrays.asList(
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.CLUBS)
		);

		List<Card> handCards = Arrays.asList(
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.CLUBS),
				new Card(CardRank.QUEEN, CardSuit.DIAMONDS),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.NINE, CardSuit.SPADES),
				new Card(CardRank.NINE, CardSuit.DIAMONDS)
		);
		
		assertTrue(validate.isTwoPair(handCards, playerCards));
	}

	@Test
	public void isPair_Test() {
		List<Card> playerCards = Arrays.asList(
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.CLUBS)
		);

		List<Card> handCards = Arrays.asList(
				new Card(CardRank.TWO, CardSuit.SPADES),
				new Card(CardRank.TWO, CardSuit.CLUBS),
				new Card(CardRank.QUEEN, CardSuit.DIAMONDS),
				new Card(CardRank.JACK, CardSuit.SPADES),
				new Card(CardRank.TEN, CardSuit.SPADES),
				new Card(CardRank.THREE, CardSuit.SPADES),
				new Card(CardRank.SIX, CardSuit.DIAMONDS)
		);
		
		assertTrue(validate.isPair(handCards, playerCards));
	}

}
