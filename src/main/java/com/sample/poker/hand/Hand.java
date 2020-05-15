package com.sample.poker.hand;

/**
 * The base class of the different Hands such as {@link com.sample.poker.hand.types.Flush},
 * {@link com.sample.poker.hand.types.FullHouse}, etc.
 */
public abstract class Hand {

    /**
     * @return The {@link HandType}
     */
    public abstract HandType getHandType();

}
