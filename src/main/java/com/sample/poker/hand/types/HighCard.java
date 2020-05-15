package com.sample.poker.hand.types;

import java.util.List;
import java.util.stream.Collectors;

import com.sample.poker.card.Card;
import com.sample.poker.hand.Hand;
import com.sample.poker.hand.HandType;
import com.sample.poker.hand.utility.SortHelpers;

/**
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/List_of_poker_hands#High_card">What is a
 *      High Card?</a>
 */
public class HighCard extends Hand {

	private List<Card> cards;

	public HighCard(List<Card> cards) {
		this.cards = cards;
	}

	public HandType getHandType() {
		return HandType.HIGH_CARD;
	}

	/**
	 * @return The cards ordered by descending rank, e.g. A,K,Q,3,2
	 */
	@Override
	public String toString() {
		SortHelpers sortHelpers = new SortHelpers();
		sortHelpers.sortByRank(cards);

		String output = "";

		if (cards.size() >= 5) {
			output = cards.subList(0, 5).stream().map(card -> card.getRank().toString())
					.collect(Collectors.joining(",")).toString();
		} else {
			output = cards.subList(0, 2).stream().map(card -> card.getRank().toString())
					.collect(Collectors.joining(",")).toString();
		}

		return output;
	}

}
