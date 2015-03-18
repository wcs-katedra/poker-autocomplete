package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;

public class Player {

    static final String VERSION = "Default+ Java folding player";

    /**
     * mennyi kártya ment el az osztótol ?
     *
     * @return db ra
     */
    public static Integer getNumberOfCardInTheGame(GameState gameState) {
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
    public static int betRequest(GameState gameState) {

        return 0;
    }

    public static void showdown(GameState gameState) {
    }
}
