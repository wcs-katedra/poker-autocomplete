package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;

public class Player {

    public final String VERSION = "Default+ Java folding player";

    public Player() {
    }
    
    /**
     * mennyi kártya ment el az osztótol ?
     *
     * @return db ra
     */
    public Integer getNumberOfCardInTheGame(GameState gameState) {
        Integer cards = 0;

        // a járékosoknál lévő lapok száma
        for (com.wcs.poker.gamestate.Player player : gameState.getPlayers()) {
            if ("active".equals(player.getStatus())) {
                cards+=2;
            }
        }
        // az asztalon lévő lapok száma
        cards+=gameState.getCommunityCards().size();

        return cards;
    }

    /**
     * 
     * @param gameState
     * @return 0 -- ha bedobod
     *         ALL> -- aktuális tét
     *          ALL -- minden benn
     */
    public int betRequest(GameState gameState) {
        // Create new instance of the CardAnalysis
        
        return 0;
    }

    public void showdown(GameState gameState) {
    }
}
