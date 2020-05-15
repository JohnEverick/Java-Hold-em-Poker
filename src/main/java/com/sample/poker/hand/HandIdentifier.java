package com.sample.poker.hand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sample.poker.card.Card;
import com.sample.poker.hand.types.Flush;
import com.sample.poker.hand.types.FourOfAKind;
import com.sample.poker.hand.types.FullHouse;
import com.sample.poker.hand.types.HighCard;
import com.sample.poker.hand.types.OnePair;
import com.sample.poker.hand.types.Straight;
import com.sample.poker.hand.types.StraightFlush;
import com.sample.poker.hand.types.ThreeOfAKind;
import com.sample.poker.hand.types.TwoPair;
import com.sample.poker.hand.utility.GetHelpers;
import com.sample.poker.hand.utility.SortHelpers;
import com.sample.poker.hand.utility.ValidationHelpers;

/**
 * A service that is to used to identify the {@link Hand} given the player's
 * cards and the community cards.
 */
@Component
public class HandIdentifier {
	private ValidationHelpers validator = new ValidationHelpers();
	private GetHelpers getHelper = new GetHelpers();
	private SortHelpers sortHelper = new SortHelpers();

	/**
	 * Given the player's cards and the community cards, identifies the player's
	 * hand.
	 *
	 * @param playerCards
	 * @param communityCards
	 * @return The player's {@link Hand} or `null` if no Hand was identified.
	 */
	public Hand identifyHand(List<Card> playerCards, List<Card> communityCards) {
		List<Card> combinedCards = new ArrayList<Card>();
		combinedCards.addAll(playerCards);
		combinedCards.addAll(communityCards);

		if (validator.isStraightFlush(combinedCards, playerCards)) {

			List<Card> straightFlushCards = getHelper.getStraightFlush(combinedCards);

			return new StraightFlush(straightFlushCards);

		} else if (validator.isFourOfAKind(combinedCards, playerCards)) {

			List<Card> fourOfAKindCards = getHelper.getFourOfAKind(combinedCards);
			List<Card> highCards = combinedCards.stream().filter(card -> !fourOfAKindCards.contains(card))
					.collect(Collectors.toList());

			return new FourOfAKind(fourOfAKindCards, sortHelper.sortByRank(highCards));

		} else if (validator.isFullHouse(combinedCards, playerCards)) {

			List<Card> threeOfAKindCards = getHelper.getThreeOfAKind(combinedCards);
			List<Card> pairCards = getHelper.getPair(combinedCards);

			return new FullHouse(threeOfAKindCards, pairCards);

		} else if (validator.isFlush(combinedCards, playerCards)) {

			return new Flush(getHelper.getFlush(combinedCards));

		} else if (validator.isStraight(combinedCards, playerCards)) {

			return new Straight(getHelper.getStraight(combinedCards));

		} else if (validator.isThreeOfAKind(combinedCards, playerCards)) {

			List<Card> threeOfAKindCards = getHelper.getThreeOfAKind(combinedCards);
			List<Card> highCards = combinedCards.stream().filter(card -> !threeOfAKindCards.contains(card))
					.collect(Collectors.toList());

			return new ThreeOfAKind(threeOfAKindCards, sortHelper.sortByRank(highCards));

		} else if (validator.isTwoPair(combinedCards, playerCards)) {

			List<Card> twoPairCards = sortHelper.sortByRank(getHelper.getTwoPair(combinedCards));
			List<Card> highCards = combinedCards.stream().filter(card -> !twoPairCards.contains(card))
					.collect(Collectors.toList());

			List<Card> firstPair = new ArrayList<Card>();
			firstPair.add(twoPairCards.get(0));
			firstPair.add(twoPairCards.get(1));
			List<Card> secondPair = new ArrayList<Card>();
			secondPair.add(twoPairCards.get(2));
			secondPair.add(twoPairCards.get(3));

			return new TwoPair(firstPair, secondPair, sortHelper.sortByRank(highCards));

		} else if (validator.isPair(combinedCards, playerCards)) {

			List<Card> pairCards = getHelper.getPair(combinedCards);
			List<Card> highCards = combinedCards.stream().filter(card -> !pairCards.contains(card))
					.collect(Collectors.toList());

			return new OnePair(pairCards, sortHelper.sortByRank(highCards));

		} else {

			return new HighCard(combinedCards);

		}
	}

}
