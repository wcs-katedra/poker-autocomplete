/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.hand.CountTables;

/**
 *
 * @author MártonZoltán
 */
public class SuitCount {

    private String suit;
    private int count = 0;

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }
}
