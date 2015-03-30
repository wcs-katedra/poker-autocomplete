/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.gamestate;

import com.google.gson.annotations.SerializedName;

/**
 * ez az enumerátor definiálja a suitokat 
♣ treff (CLUBS) ♦ káró (DIAMONDS) ♥ kőr (HEARTS) ♠ pikk (SPADES).
 * @author boss ;)
 */
public enum Suits {
    
    @SerializedName("clubs")
    CLUBS,
    @SerializedName("diamonds")
    DIAMONDS,
    @SerializedName("hearts")
    HEARTS,
    @SerializedName("spades")
    SPADES,
    
}
