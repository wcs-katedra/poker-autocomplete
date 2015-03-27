package org.leanpoker.player;

import cardAnalysis.CardAnalysis;
import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.List;
import strategy.DetermineBet;

public class Player {

    public final String VERSION = "Default+ Java folding player";

    public Player() {
    }

    /**
     *
     * @param gameState
     * @return 0 -- ha bedobod ALL> -- aktuális tét ALL -- minden benn
     */
    public int betRequest(GameState gameState) {
        String evaluatedCards = "";
        int finalBet = 0;

        // mine data for the claass
        int bigBlind = gameState.getBigBlind();
        int minimumRaise = gameState.getMinimumRaise();
        int currentBuyIn = gameState.getCurrentBuyIn();
        int pot = gameState.getPot();
        int stack = gameState.getCurrentPlayerStack();

        // Create new instances
        DetermineBet determineBet = new DetermineBet(bigBlind, minimumRaise, currentBuyIn, pot, stack);
        CardAnalysis analysis = new CardAnalysis();

        // do the neseseary calls
        List<Card> cards = gameState.cardsInTheGame();
        evaluatedCards = analysis.evaluateCards(cards);
        finalBet = determineBet.getBet(evaluatedCards);

        return finalBet;
    }

    public void showdown(GameState gameState) {
    }
}
