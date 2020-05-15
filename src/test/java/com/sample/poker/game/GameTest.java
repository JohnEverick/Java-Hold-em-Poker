package com.sample.poker.game;

import org.junit.Test;

import com.sample.poker.deck.DeckBuilder;
import com.sample.poker.game.Game;
import com.sample.poker.hand.HandIdentifier;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class GameTest {

    @Test
    public void afterConstructorInit_eachPlayerHasTwoCards() {
        DeckBuilder deckBuilder = new DeckBuilder();
        HandIdentifier handIdentifier = mock(HandIdentifier.class);

        Game game = new Game(deckBuilder, handIdentifier);

        assertPlayersHaveTwoCardsEach(game);
    }

    @Test
    public void startNewGame_eachPlayerHasTwoCards() {
        DeckBuilder deckBuilder = new DeckBuilder();
        HandIdentifier handIdentifier = mock(HandIdentifier.class);

        Game game = new Game(deckBuilder, handIdentifier);

        assertPlayersHaveTwoCardsEach(game);
    }

    private void assertPlayersHaveTwoCardsEach(Game game) {
        game.getPlayers().forEach(player ->
                assertEquals("Players should have 2 cards each",
                        2,
                        player.getHand().size()));
    }

    @Test
    public void nextAction_dealCommunityCards() {
        DeckBuilder deckBuilder = new DeckBuilder();
        HandIdentifier handIdentifier = mock(HandIdentifier.class);

        Game game = new Game(deckBuilder, handIdentifier);

        game.nextAction();
        assertEquals("Deal three community cards at the start", 3, game.getCommunityCards().size());

        game.nextAction();
        assertEquals("Expecting four community cards", 4, game.getCommunityCards().size());

        game.nextAction();
        assertEquals("Expecting 5 community cards", 5, game.getCommunityCards().size());
    }
}
