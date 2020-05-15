package com.sample.poker.hand.types;

import java.util.List;

import com.sample.poker.card.Card;
import com.sample.poker.hand.Hand;
import com.sample.poker.hand.HandType;

/**
 * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Flush">What
 *      is a flush?</a>
 */
public class Flush extends Hand {

	private List<Card> cards;

	public Flush(List<Card> cards) {
		this.cards = cards;
	}

	public HandType getHandType() {
		return HandType.FLUSH;
	}

	public List<Card> getCards() {
		return cards;
	}

	/**
	 * @return Returns the name of the hand and the highest card, e.g. Flush (K
	 *         High)
	 */
	@Override
	public String toString() {

		if (!cards.isEmpty()) {
			return "Flush (" + cards.get(0).getRank() + " High)";
		}

		return "";
	}

}
