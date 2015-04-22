package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;
import com.wcs.poker.hand.work.HandRankingService;
import java.util.ArrayList;
import java.util.List;
import strategy.CalculateOnFlop;
import strategy.CalculateOnPreflop;
import strategy.CalculateOnRiver;
import strategy.CalculateOnTurn;
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
        int finalBet = 0;
        List<Card> cards = gameState.cardsInTheGame();
        HandRank hr = cardAnalysis(cards);
        finalBet = determineByNumberOfCards(cards.size(),gameState, hr);
        return finalBet;
    }

    /**
     * evaluets the cards in the current gamestate and returns the best of them
     *
     * @param cards
     * @return
     */
    public HandRank cardAnalysis(List<Card> cards) {
        HandRankingService hrs = new HandRankingService();
        Hand evaledCards = hrs.evaulate(cards);
        return evaledCards.getRank();
    }

    public void showdown(GameState gameState) {
    }
    
    
    

    private int determineByNumberOfCards(int size,GameState gs, HandRank hr) {
        int retVal=1;
        if (size == 2 ) retVal = new CalculateOnPreflop(gs, hr).getBet();
        if (size == 5 ) retVal = new CalculateOnFlop(gs, hr).getBet();
        if (size == 6 ) retVal = new CalculateOnTurn(gs, hr).getBet();
        if (size == 7 ) retVal = new CalculateOnRiver(gs, hr).getBet();
        return  retVal;
    }
}
