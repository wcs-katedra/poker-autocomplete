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
        String cardsCombo = "";
        String cardsLevel = "";
        int finalBet = 0;

        // mine data for the class
        int bigBlind = gameState.getBigBlind();
        int minimumRaise = gameState.getMinimumRaise();
        int currentBuyIn = gameState.getCurrentBuyIn();
        int pot = gameState.getPot();
        int stack = gameState.getCurrentPlayerStack();

        // init the neseseary classes
        DetermineBet determineBet = new DetermineBet(bigBlind, minimumRaise, currentBuyIn, pot, stack);
        CardAnalysis analysis = new CardAnalysis();

        // get tha cards in the current game
        List<Card> cards = gameState.cardsInTheGame();
        
        // send them to analysis
        analysis.evaluateCards(cards);
        
        // recieve the result from the calss
        cardsCombo = analysis.getCombo();
        cardsLevel = analysis.getLevel();
        
        // calculate the right bet whit the given card value
        finalBet = determineBet.getBet(cardsCombo, cardsLevel);

        return finalBet;
    }

    public void showdown(GameState gameState) {
    }
}
