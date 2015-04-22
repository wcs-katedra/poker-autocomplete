/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.gamestate;

import com.google.gson.annotations.SerializedName;

/**
 * Ez az enumerátor definiálja a Rankokat
 * A (ász), 2, 3, 4, 5, 6, 7, 8, 9, 10, J (bubi), Q (dáma), K (király)
 *
 * @author boss ;)
 */
public enum Rank {

    @SerializedName("A")
    A(1),
    @SerializedName("2")
    _2(2),
    @SerializedName("3") 
    _3(3),
    @SerializedName("4") 
    _4(4),
    @SerializedName("5")
    _5(5),
    @SerializedName("6")
    _6(6),
    @SerializedName("7")
    _7(7),
    @SerializedName("8")
    _8(8),
    @SerializedName("9")
    _9(9),
    @SerializedName("10")
    _10(10),
    @SerializedName("J")
    J(11),
    @SerializedName("Q")
    Q(12),
    @SerializedName("K")
    K(13);

    private int rankValue;

    private Rank(int rankValue) {
        this.rankValue = rankValue;
    }
    
    public int getRankValue() {
        return rankValue;
    }

}
