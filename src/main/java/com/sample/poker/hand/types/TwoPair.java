package com.sample.poker.hand.types;

import java.util.List;

import com.sample.poker.card.Card;
import com.sample.poker.hand.Hand;
import com.sample.poker.hand.HandType;

/**
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/List_of_poker_hands#Two_pair">What is a
 *      Two Pair?</a>
 */
public class TwoPair extends Hand {

	private List<Card> firstPairCards;
	private List<Card> secondPairCards;
	private List<Card> otherCards;

	public TwoPair(List<Card> firstPairCards, List<Card> secondPairCards, List<Card> otherCards) {
		this.firstPairCards = firstPairCards;
		this.secondPairCards = secondPairCards;
		this.otherCards = otherCards;
	}

	public HandType getHandType() {
		return HandType.TWO_PAIR;
	}

	/**
	 * @return The name of the hand with kicker ranked in descending order, e.g. Two
	 *         Pair (4,3) - A High
	 */
	@Override
	public String toString() {
		String output = "";

		if (!firstPairCards.isEmpty() && !secondPairCards.isEmpty() && !otherCards.isEmpty()) {
			output = "Two Pair (" + firstPairCards.get(0).getRank() + "," + secondPairCards.get(0).getRank() + ") - "
					+ otherCards.get(0).getRank() + " High";
		}

		return output;
	}

}
