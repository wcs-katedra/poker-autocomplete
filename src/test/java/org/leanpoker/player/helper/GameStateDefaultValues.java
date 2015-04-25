/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.helper;

/**
 *
 * @author boss
 */
public class GameStateDefaultValues {
    
    private static final int smallBlind=10;
    private static final int currentBuyIn=320;
    private static final int pot=100;
    private static final int minimumRaise=240;
    private static final int dealer=1;

    public static int getSmallBlind() {
        return smallBlind;
    }

    public static int getCurrentBuyIn() {
        return currentBuyIn;
    }

    public static int getPot() {
        return pot;
    }

    public static int getMinimumRaise() {
        return minimumRaise;
    }

    public static int getDealer() {
        return dealer;
    }

    
    
}
