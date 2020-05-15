package com.sample.poker.hand.types;

import java.util.List;
import java.util.stream.Collectors;

import com.sample.poker.card.Card;
import com.sample.poker.hand.Hand;
import com.sample.poker.hand.HandType;

/**
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/List_of_poker_hands#Three_of_a_kind">What
 *      is a Three of a Kind?</a>
 */
public class ThreeOfAKind extends Hand {

	private List<Card> threeOfAKindCards;
	private List<Card> otherCards;

	public ThreeOfAKind(List<Card> threeOfAKindCards, List<Card> otherCards) {
		this.threeOfAKindCards = threeOfAKindCards;
		this.otherCards = otherCards;
	}

	public HandType getHandType() {
		return HandType.THREE_OF_A_KIND;
	}

	/**
	 * @return The name of the hand plus kickers in descending rank, e.g. Trips (4)
	 *         - A,2 High
	 */
	@Override
	public String toString() {
		String output = "";

		if (!threeOfAKindCards.isEmpty() && !otherCards.isEmpty()) {
			output = "Trips (" + threeOfAKindCards.get(0).getRank() + ") - " + otherCards.subList(0, 2).stream()
					.map(card -> card.getRank().toString()).collect(Collectors.joining(",")) + " High";
		}

		return output;
	}

}
