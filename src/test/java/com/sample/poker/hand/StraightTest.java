package com.sample.poker.hand;

import org.junit.Test;

import com.sample.poker.card.Card;
import com.sample.poker.card.CardRank;
import com.sample.poker.card.CardSuit;
import com.sample.poker.hand.types.Straight;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StraightTest {

    @Test
    public void toString_withAceHighStraight() {
        List<Card> cards = Arrays.asList(
                new Card(CardRank.ACE, CardSuit.CLUBS),
                new Card(CardRank.KING, CardSuit.DIAMONDS),
                new Card(CardRank.QUEEN, CardSuit.SPADES),
                new Card(CardRank.JACK, CardSuit.CLUBS),
                new Card(CardRank.TEN, CardSuit.CLUBS)
        );

        Straight straight = new Straight(cards);

        assertEquals("Straight (A High)", straight.toString());
    }

    @Test
    public void toString_withKingHighStraight() {
        List<Card> cards = Arrays.asList(
                new Card(CardRank.KING, CardSuit.CLUBS),
                new Card(CardRank.QUEEN, CardSuit.DIAMONDS),
                new Card(CardRank.JACK, CardSuit.SPADES),
                new Card(CardRank.TEN, CardSuit.CLUBS),
                new Card(CardRank.NINE, CardSuit.CLUBS)
        );

        Straight straight = new Straight(cards);

        assertEquals("Straight (K High)", straight.toString());
    }

    @Test
    public void toString_withFiveHighStraight() {
        List<Card> cards = Arrays.asList(
                new Card(CardRank.FIVE, CardSuit.CLUBS),
                new Card(CardRank.FOUR, CardSuit.DIAMONDS),
                new Card(CardRank.THREE, CardSuit.SPADES),
                new Card(CardRank.TWO, CardSuit.CLUBS),
                new Card(CardRank.ACE, CardSuit.CLUBS)
        );

        Straight straight = new Straight(cards);

        assertEquals("Straight (5 High)", straight.toString());
    }

}