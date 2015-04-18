/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.hand.CountTables;

import com.wcs.poker.hand.enums.HandLevel;



/**
 *
 * @author MártonZoltán
 */
public class RankCount {

    private String rank;
    private HandLevel level;
    private int count = 0;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }

    public HandLevel getLevel() {
        return level;
    }

    public void setLevel(HandLevel level) {
        this.level = level;
    }
}
