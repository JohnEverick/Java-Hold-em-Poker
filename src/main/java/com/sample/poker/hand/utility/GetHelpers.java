package com.sample.poker.hand.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sample.poker.card.Card;
import com.sample.poker.card.CardRank;
import com.sample.poker.card.CardSuit;

@Service
public class GetHelpers {
	private SortHelpers sortHelper = new SortHelpers();

	public List<Card> getStraightFlush(List<Card> handCards) {
		List<Card> straightFlushCards = new ArrayList<Card>();
		List<Card> filteredCards = new ArrayList<Card>();
		List<CardSuit> suits = handCards.stream().map(card -> card.getSuit()).distinct().collect(Collectors.toList());

		for (int ctr = 0; ctr < suits.size(); ctr++) {
			CardSuit suit = suits.get(ctr);
			if (handCards.stream().filter(card -> card.getSuit().equals(suit)).count() >= 5) {
				filteredCards = sortHelper.sortByRank(
						handCards.stream().filter(card -> card.getSuit().equals(suit)).collect(Collectors.toList()));
			}
		}

		for (int ctr = 0; ctr < filteredCards.size() && straightFlushCards.size() < 5; ctr++) {
			boolean isFirstElement = (ctr == 0)
					&& (filteredCards.get(ctr).getRank().compareTo(filteredCards.get(ctr + 1).getRank()) == 1);
			boolean isMiddleElement = (ctr > 0 && ctr < filteredCards.size() - 1) && (straightFlushCards.isEmpty()
					&& filteredCards.get(ctr).getRank().compareTo(filteredCards.get(ctr + 1).getRank()) == 1
					|| (straightFlushCards.size() > 0 && straightFlushCards.get(straightFlushCards.size() - 1).getRank()
							.compareTo(filteredCards.get(ctr).getRank()) == 1));
			boolean isFinalElement = (ctr == filteredCards.size() - 1)
					&& (filteredCards.get(ctr).getRank().compareTo(filteredCards.get(ctr - 1).getRank()) == -1);

			if (isFirstElement || isMiddleElement || isFinalElement) {
				straightFlushCards.add(filteredCards.get(ctr));
			}
		}

		return sortHelper.sortByRank(straightFlushCards);
	}

	public List<Card> getFlush(List<Card> handCards) {
		List<CardSuit> suits = handCards.stream().map(card -> card.getSuit()).distinct().collect(Collectors.toList());
		List<Card> flushCards = new ArrayList<Card>();

		for (int ctr = 0; ctr < suits.size() && flushCards.size() <= 5; ctr++) {
			CardSuit suit = suits.get(ctr);
			if (handCards.stream().filter(card -> card.getSuit().equals(suit)).count() >= 5) {
				flushCards.addAll(
						handCards.stream().filter(card -> card.getSuit().equals(suit)).collect(Collectors.toList()));
			}
		}
		return sortHelper.sortByRank(flushCards);
	}

	public List<Card> getStraight(List<Card> handCards) {
		List<Card> sortedCards = sortHelper.sortByRank(handCards);
		List<Card> straightCards = new ArrayList<Card>();

		for (int ctr = 0; ctr < sortedCards.size() && straightCards.size() < 5; ctr++) {
			boolean isFirstElement = (ctr == 0)
					&& (sortedCards.get(ctr).getRank().compareTo(sortedCards.get(ctr + 1).getRank()) == 1);
			boolean isMiddleElement = (ctr > 0 && ctr < sortedCards.size() - 1) && (straightCards.isEmpty()
					&& sortedCards.get(ctr).getRank().compareTo(sortedCards.get(ctr + 1).getRank()) == 1
					|| (straightCards.size() > 0 && straightCards.get(straightCards.size() - 1).getRank()
							.compareTo(sortedCards.get(ctr).getRank()) == 1));
			boolean isFinalElement = (ctr == sortedCards.size() - 1)
					&& (sortedCards.get(ctr).getRank().compareTo(sortedCards.get(ctr - 1).getRank()) == -1);

			if (isFirstElement || isMiddleElement || isFinalElement) {
				straightCards.add(sortedCards.get(ctr));
			}
		}

		return sortHelper.sortByRank(straightCards);
	}

	public List<Card> getFourOfAKind(List<Card> handCards) {
		List<Card> fourOfAKindCards = new ArrayList<Card>();
		for (int ctr = 0; ctr <= handCards.size() - 1; ctr++) {
			CardRank currentRank = handCards.get(ctr).getRank();
			if (handCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 4) {
				fourOfAKindCards.add(handCards.get(ctr));
			}
		}
		return fourOfAKindCards;
	}

	public List<Card> getThreeOfAKind(List<Card> handCards) {
		List<Card> threeOfAKindCards = new ArrayList<Card>();
		for (int ctr = 0; ctr <= handCards.size() - 1 && threeOfAKindCards.size() <= 3; ctr++) {
			CardRank currentRank = handCards.get(ctr).getRank();
			if (handCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 3) {
				threeOfAKindCards.add(handCards.get(ctr));
			}
		}
		return threeOfAKindCards;
	}

	public List<Card> getTwoPair(List<Card> handCards) {
		List<Card> twoPairCards = new ArrayList<Card>();

		for (int ctr = 0; ctr < handCards.size(); ctr++) {
			CardRank currentRank = handCards.get(ctr).getRank();
			if (handCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 2) {
				twoPairCards.add(handCards.get(ctr));
			}
		}

		return sortHelper.sortByRank(twoPairCards);
	}

	public List<Card> getPair(List<Card> handCards) {
		List<Card> pairedCards = new ArrayList<Card>();

		for (int ctr = 0; ctr <= handCards.size() - 1 && pairedCards.size() <= 2; ctr++) {
			CardRank currentRank = handCards.get(ctr).getRank();
			if (handCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 2) {
				pairedCards.add(handCards.get(ctr));
			}
		}
		return pairedCards;
	}
}
