/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.gamestate.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Ez az enumerátor definiálja a Rankokat
 * A (ász), 2, 3, 4, 5, 6, 7, 8, 9, 10, J (bubi), Q (dáma), K (király)
 *
 * @author boss ;)
 */
public enum Rank {

    @SerializedName("A")
    A,
    @SerializedName("2")
    _2,
    @SerializedName("3") 
    _3,
    @SerializedName("4") 
    _4,
    @SerializedName("5")
    _5,
    @SerializedName("6")
    _6,
    @SerializedName("7")
    _7,
    @SerializedName("8")
    _8,
    @SerializedName("9")
    _9,
    @SerializedName("10")
    _10,
    @SerializedName("J")
    J,
    @SerializedName("Q")
    Q,
    @SerializedName("K")
    K;

    private int rankValue;

}
