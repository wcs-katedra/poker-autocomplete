/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.hand.CountTables;

import com.wcs.poker.gamestate.Suit;

/**
 *
 * @author MártonZoltán
 */
public class SuitCount {

    private Suit suit;
    private int count = 0;

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public int getCount() {
        return count;
    }

     public void incrementCount() {
        this.count++;
    }
}
