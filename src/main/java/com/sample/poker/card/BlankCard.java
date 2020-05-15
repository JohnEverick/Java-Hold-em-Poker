package com.sample.poker.card;

/**
 * A blank card. Also, the back side of the card.
 */
public class BlankCard extends Card {

	public BlankCard() {
		super(null, null);
	}

	/**
	 *
	 * @return The CSS class <code>card-back</code>
	 */
	@Override
	public String styleClass() {
		return "card-back";
	}

	@Override
	public String toString() {
		return "&nbsp;";
	}

}
