package org.leanpoker.player;

import com.wcs.poker.gamestate.GameState;

public class Player {

    static final String VERSION = "Default Java folding player";

    /**
     * mennyi kártya ment el az osztótol ?
     *
     * @return db ra
     */
    public static Integer getNumberOfCardInTheGame(GameState gameState) {
        Integer cards = 0;

        for (com.wcs.poker.gamestate.Player player : gameState.getPlayers()) {
            for (com.wcs.poker.gamestate.Card card : player.getHoleCards()) {
                if (card != null) {
                    cards++;
                }
            }
        }
        for (com.wcs.poker.gamestate.Card card : gameState.getCommunityCards()) {
            if (card != null) {
                cards++;
            }
        }

        return cards;
    }

    public static int betRequest(GameState gameState) {
        Integer cardsOut = getNumberOfCardInTheGame(gameState);

        return 0;
    }

    public static void showdown(GameState gameState) {
    }
}
