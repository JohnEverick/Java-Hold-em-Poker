package com.sample.poker.hand.types;

import java.util.List;
import java.util.stream.Collectors;

import com.sample.poker.card.Card;
import com.sample.poker.hand.Hand;
import com.sample.poker.hand.HandType;

/**
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/List_of_poker_hands#One_pair">What is a
 *      One Pair?</a>
 */
public class OnePair extends Hand {

	private List<Card> pairCards;
	private List<Card> otherCards;

	public OnePair(List<Card> pairCards, List<Card> otherCards) {
		this.pairCards = pairCards;
		this.otherCards = otherCards;
	}

	public HandType getHandType() {
		return HandType.ONE_PAIR;
	}

	/**
	 * @return The name of the hand plus kickers ordered by descending rank, e.g.
	 *         One Pair (2) - A,K,Q High, or the name of the hand and rank if there
	 *         are no community cards yet in play, e.g. One Pair (2)
	 */
	@Override
	public String toString() {
		String output = "";

		if (!pairCards.isEmpty()) {
			output = "One Pair (" + pairCards.get(0).getRank() + ")";

			if (otherCards.size() > 0) {
				output += " - " + otherCards.subList(0, 3).stream().map(card -> card.getRank().toString())
						.collect(Collectors.joining(",")) + " High";
			}
		}

		return output;
	}

}
