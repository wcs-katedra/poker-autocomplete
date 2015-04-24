/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.hand.CountTables;

import com.wcs.poker.gamestate.enums.Rank;
import com.wcs.poker.hand.enums.HandLevel;



/**
 *
 * @author MártonZoltán
 */
public class RankCount {

    private Rank rank;
    private HandLevel level;
    private int count = 0;

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    public HandLevel getLevel() {
        return level;
    }

    public void setLevel(HandLevel level) {
        this.level = level;
    }
}
