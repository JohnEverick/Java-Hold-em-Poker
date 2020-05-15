package com.sample.poker.hand.utility;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.poker.card.Card;

@Service
public class SortHelpers {
	public List<Card> sortBySuit(List<Card> handCards) {
		handCards.sort(new Comparator<Card>() {

			@Override
			public int compare(Card arg0, Card arg1) {
				return arg0.getSuit().compareTo(arg1.getSuit());
			}

		});
		return handCards;

	}

	public List<Card> sortByRank(List<Card> handCards) {
		handCards.sort(new Comparator<Card>() {

			@Override
			public int compare(Card arg0, Card arg1) {
				return arg1.getRank().compareTo(arg0.getRank());
			}

		});
		return handCards;

	}
}
