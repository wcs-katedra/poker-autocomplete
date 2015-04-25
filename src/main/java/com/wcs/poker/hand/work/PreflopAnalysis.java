/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.hand.work;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.hand.enums.HandLevel;
import java.util.List;

/**
 * egymás
 *
 * @author MártonZoltán
 */
public class PreflopAnalysis {

    public HandLevel doPreFlopAnalysis(List<Card> cards) {
        int sideBySide = sideBySide(cards);
        int sameColor = sameColor(cards);
        int aceIn = aceIn(cards);

        int value = sideBySide * sameColor * aceIn;

        return getHandLevelBy(value);
    }

    /**
     *
     * @param cards
     * @return 2 if is else 1
     */
    private int sideBySide(List<Card> cards) {
        return 1;
    }

    /**
     *
     * @param cards
     * @return 2 if is else 1
     */
    private int sameColor(List<Card> cards) {
        return 1;
    }

    /**
     *
     * @param cards
     * @return 2 if is else 1
     */
    private int aceIn(List<Card> cards) {
        return 1;
    }

    private HandLevel getHandLevelBy(int value) {
        if (8 < value) { // 12 nél biztosan kisebb
            return HandLevel.HIGH;
        } else if (4 < value && value < 8) {
            return HandLevel.MEDIUM;
        } else {
            return HandLevel.LOW;
        }

    }

}
