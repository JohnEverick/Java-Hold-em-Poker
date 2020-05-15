package com.sample.poker.card;

/**
 * The suit of a {@link Card}. A combination of the suit <code>value</code> and <code>color</code>.
 *
 * <h2>Value</h2>
 * <ul>
 *     <li>Spades</li>
 *     <li>Clubs</li>
 *     <li>Diamonds</li>
 *     <li>Hearts</li>
 * </ul>
 *
 * <h2>Color</h2>
 * <ul>
 *     <li>black</li>
 *     <li>red</li>
 * </ul>
 */
public enum CardSuit {

	SPADES("&spades;", "black"), CLUBS("&clubs;", "black"), DIAMONDS("&diams;", "red"), HEARTS("&hearts;", "red");

	private String value;
	private String color;

	CardSuit(String value, String color) {
		this.value = value;
		this.color = color;
	}

	/**
	 * @return The color of the suit, e.g. red or black
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return The suit as HTML character reference, e.g. &spades;
	 * @see <a href="https://en.wikipedia.org/wiki/List_of_XML_and_HTML_character_entity_references">Character entity references in HTML</a>
	 */
	@Override
	public String toString() {
		return value;
	}

}
