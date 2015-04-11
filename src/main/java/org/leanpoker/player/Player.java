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

        // init the neseseary classes
        DetermineBet determineBet = new DetermineBet(gameState);
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
    
    public String cardAnalysisForTest(GameState gameState){
        String cardsCombo = "";
        String cardsLevel = "";  
        CardAnalysis analysis = new CardAnalysis();
        
        // get tha cards in the current game
        List<Card> cards = gameState.cardsInTheGame();
        
        // send them to analysis
        analysis.evaluateCards(cards);
        
        // recieve the result from the calss
        cardsCombo = analysis.getCombo();
        cardsLevel = analysis.getLevel();
        
        return "\" "+cardsCombo+" / "+cardsLevel+" \"";
    }

    public void showdown(GameState gameState) {
    }
}
