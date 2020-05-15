package com.sample.poker.hand.types;

import java.util.List;

import com.sample.poker.card.Card;
import com.sample.poker.hand.Hand;
import com.sample.poker.hand.HandType;

/**
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/List_of_poker_hands#Full_house">What is a
 *      Full House?</a>
 */
public class FullHouse extends Hand {

	private List<Card> threeOfAKindCards;
	private List<Card> pairCards;

	public FullHouse(List<Card> threeOfAKindCards, List<Card> pairCards) {
		this.threeOfAKindCards = threeOfAKindCards;
		this.pairCards = pairCards;
	}

	public HandType getHandType() {
		return HandType.FULL_HOUSE;
	}

	/**
	 * @return The name of the hand with rank of the three pair and two pair, e.g.
	 *         444AA - Full House (4,A)
	 */
	@Override
	public String toString() {
		
		if (!threeOfAKindCards.isEmpty() && !pairCards.isEmpty()) {
			return "Full House (" + threeOfAKindCards.get(0).getRank() + "," + pairCards.get(0).getRank() + ")";
		}

		return "";
	}

}
