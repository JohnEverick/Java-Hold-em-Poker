package com.sample.poker.hand.types;

import java.util.List;

import com.sample.poker.card.Card;
import com.sample.poker.card.CardRank;
import com.sample.poker.hand.HandType;

/**
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/List_of_poker_hands#Straight_flush">What
 *      is a Straight Flush?</a>
 */
public class StraightFlush extends Straight {

	public StraightFlush(List<Card> cards) {
		super(cards);
	}

	@Override
	public HandType getHandType() {
		return HandType.STRAIGHT_FLUSH;
	}

	/**
	 * @return Royal Flush if the hand is a royal flush, or Straight Flush with the
	 *         highest rank card, e.g. Straight Flush (K High)
	 */
	@Override
	public String toString() {
		String output = "";

		if (!this.getCards().isEmpty()) {
			if (this.getCards().get(0).getRank() == CardRank.ACE) {
				output = "Royal Flush";
			} else {
				output = "Straight Flush (" + this.getCards().get(0).getRank() + " High)";
			}
		}

		return output;
	}

}
