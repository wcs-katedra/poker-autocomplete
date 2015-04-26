/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.hand.work;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.enums.Rank;
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

        int value = sideBySide + sameColor + aceIn;

        return getHandLevelBy(value);
    }

    /**
     *
     * @param cards
     * @return 2 if is else 1
     */
    private int sideBySide(List<Card> cards) {
        int cardOrdinal1 = cards.get(0).getRank().ordinal();
        int cardOrdinal2 = cards.get(1).getRank().ordinal();

        int difference = Math.abs(cardOrdinal1 - cardOrdinal2);
        if (difference == 1) {
            return 3;
        }
        if (difference == 2) {
            return 2;
        }
        return 1;
    }

    /**
     *
     * @param cards
     * @return 2 if is else 1
     */
    private int sameColor(List<Card> cards) {
        if (cards.get(0).getSuit().equals(cards.get(1).getSuit())) {
            return 2;
        }
        return 1;

    }

    /**
     *
     * @param cards
     * @return 2 if is else 1
     */
    private int aceIn(List<Card> cards) {
        boolean a = false;
        for (Card card : cards) {
            if (card.getRank().equals(Rank.A)) {
                a = true;
            }
        }

        if (a) {
            return 2;
        }
        return 1;
    }

    private HandLevel getHandLevelBy(int value) {
        if (4 < value) {
            return HandLevel.HIGH;
        } else if (2 < value && value < 5) {
            return HandLevel.MEDIUM;
        } else {
            return HandLevel.LOW;
        }

    }

}
