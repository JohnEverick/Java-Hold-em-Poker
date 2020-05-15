package com.sample.poker.hand.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sample.poker.card.Card;
import com.sample.poker.card.CardRank;
import com.sample.poker.card.CardSuit;

@Service
public class ValidationHelpers {
	private SortHelpers sortHelper = new SortHelpers();

	public boolean isStraightFlush(List<Card> handCards, List<Card> playerCards) {
		List<Card> straightFlushCards = new ArrayList<Card>();
		List<Card> filteredCards = new ArrayList<Card>();
		List<CardSuit> suits = handCards.stream().map(card -> card.getSuit()).distinct().collect(Collectors.toList());
		boolean inPlayerCards = false;

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
				if (!inPlayerCards) {
					inPlayerCards = playerCards.contains(handCards.get(ctr));
				}
			}
		}
		return inPlayerCards && straightFlushCards.size() == 5 && (straightFlushCards.size() == 5
				&& straightFlushCards.stream().map(card -> card.getSuit()).distinct().count() == 1);
	}

	public boolean isFourOfAKind(List<Card> handCards, List<Card> playerCards) {
		for (int ctr = 0; ctr < handCards.size(); ctr++) {
			CardRank currentRank = handCards.get(ctr).getRank();
			if (handCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 4) {
				return playerCards.contains(handCards.get(ctr));
			}
		}
		return false;
	}

	public boolean isFullHouse(List<Card> handCards, List<Card> playerCards) {
		boolean isThreeOfAKind = false;
		boolean isPair = false;
		boolean inPlayerCards = false;
		List<Card> sortedCards = sortHelper.sortByRank(handCards);

		for (int ctr = 0; ctr < sortedCards.size(); ctr++) {
			CardRank currentRank = sortedCards.get(ctr).getRank();
			if (sortedCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 3) {
				isThreeOfAKind = true;
				if (!inPlayerCards) {
					inPlayerCards = playerCards.contains(sortedCards.get(ctr));
				}
			}
		}

		for (int ctr = 0; ctr < sortedCards.size(); ctr++) {
			CardRank currentRank = sortedCards.get(ctr).getRank();
			if (sortedCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 2) {
				isPair = true;
				if (!inPlayerCards) {
					inPlayerCards = playerCards.contains(sortedCards.get(ctr));
				}
			}
		}

		return inPlayerCards && isThreeOfAKind && isPair;
	}

	public boolean isFlush(List<Card> handCards, List<Card> playerCards) {
		List<CardSuit> suits = handCards.stream().map(card -> card.getSuit()).distinct().collect(Collectors.toList());

		for (int ctr = 0; ctr < suits.size(); ctr++) {
			CardSuit suit = suits.get(ctr);
			if (handCards.stream().filter(card -> card.getSuit().equals(suit)).count() >= 5) {
				return playerCards.stream().filter(card -> card.getSuit().equals(suit)).count() > 0;
			}
		}
		return false;
	}

	public boolean isStraight(List<Card> handCards, List<Card> playerCards) {
		List<Card> straightCards = new ArrayList<Card>();
		List<Card> sortedCards = sortHelper.sortByRank(handCards);
		boolean inPlayerCards = false;

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
				if (!inPlayerCards) {
					inPlayerCards = playerCards.contains(handCards.get(ctr));
				}
			}
		}

		return inPlayerCards && straightCards.size() == 5;
	}

	public boolean isThreeOfAKind(List<Card> handCards, List<Card> playerCards) {
		for (int ctr = 0; ctr < handCards.size(); ctr++) {
			CardRank currentRank = handCards.get(ctr).getRank();
			if (handCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 3) {
				return playerCards.contains(handCards.get(ctr));
			}
		}
		return false;
	}

	public boolean isTwoPair(List<Card> handCards, List<Card> playerCards) {
		List<CardRank> pairedRanks = new ArrayList<CardRank>();
		boolean inPlayerCards = false;

		for (int ctr = 0; ctr < handCards.size(); ctr++) {
			CardRank currentRank = handCards.get(ctr).getRank();
			if (handCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 2) {
				pairedRanks.add(currentRank);
				if (!inPlayerCards) {
					inPlayerCards = playerCards.contains(handCards.get(ctr));
				}
			}
		}
		return inPlayerCards && pairedRanks.size() > 2;
	}

	public boolean isPair(List<Card> handCards, List<Card> playerCards) {
		List<CardRank> pairedRanks = new ArrayList<CardRank>();
		boolean inPlayerCards = false;

		for (int ctr = 0; ctr < handCards.size(); ctr++) {
			CardRank currentRank = handCards.get(ctr).getRank();
			if (handCards.stream().filter(comparedCard -> comparedCard.getRank().equals(currentRank)).count() == 2) {
				pairedRanks.add(currentRank);
				if (!inPlayerCards) {
					inPlayerCards = playerCards.contains(handCards.get(ctr));
				}
			}
		}
		return inPlayerCards && pairedRanks.size() == 2;
	}
}
