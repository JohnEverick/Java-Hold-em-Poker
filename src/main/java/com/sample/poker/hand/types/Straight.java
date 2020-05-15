package com.sample.poker.hand.types;

import java.util.List;

import com.sample.poker.card.Card;
import com.sample.poker.hand.Hand;
import com.sample.poker.hand.HandType;

/**
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/List_of_poker_hands#Straight">What is a
 *      Straight?</a>
 */
public class Straight extends Hand {

	private List<Card> cards;

	public Straight(List<Card> cards) {
		this.cards = cards;
	}

	public HandType getHandType() {
		return HandType.STRAIGHT;
	}

	public List<Card> getCards() {
		return cards;
	}

	/**
	 * @return The name of the hand and the high card, e.g. Straight (A High)
	 */
	@Override
	public String toString() {

		if (!cards.isEmpty()) {
			return "Straight (" + cards.get(0).getRank() + " High)";
		}

		return "";
	}

}
