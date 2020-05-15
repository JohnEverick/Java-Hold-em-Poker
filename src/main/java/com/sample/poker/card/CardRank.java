package com.sample.poker.card;

/**
 * The rank of a {@link Card} from <em>2</em> to <em>Ace</em>. No jokers.
 */
public enum CardRank {

	TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"),
	SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"),
	JACK("J"), QUEEN("Q"), KING("K"), ACE("A");

	private String value;

	CardRank(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
