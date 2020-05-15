package com.sample.poker.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.sample.poker.card.Card;

/**
 * A complete set of {@link Card} without Jokers.
 */
public class Deck {

	private Set<Card> orderedCards = new LinkedHashSet<>();

	/**
	 * Add a {@link Card} to the deck
	 *
	 * @param card
	 */
	void addCard(Card card) {
		orderedCards.add(card);
	}

	/**
	 * Add a list of {@link Card} to the deck.
	 *
	 * @param cards
	 */
	void addCards(List<Card> cards) {
		orderedCards.addAll(cards);
	}

	/**
	 * Shuffles the deck.
	 */
	public void shuffle() {
		List<Card> cardList = new ArrayList<>(orderedCards);
		Collections.shuffle(cardList);
		orderedCards = new LinkedHashSet<>(cardList);
	}

	/**
	 * Removes a {@link Card} from the top of the deck. The removed card is returned to the client.
	 *
	 * @return The removed {@link Card}
	 * @throws RuntimeException if there are no more cards left in the deck
	 */
	public Card removeFromTop() {
		if (orderedCards.isEmpty()) {
			throw new RuntimeException("There are no cards remaining in the deck.");
		}

		Card card = orderedCards.iterator().next();
		orderedCards.remove(card);
		return card;
	}

	/**
	 * @return The number of cards currently in the deck.
	 */
	public int size() {
		return orderedCards.size();
	}

}
