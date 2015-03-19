/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.cardAnalysis.enums;

/**
 * Ez az enumerátor definiálja a Rankokat
 * A (ász), 2, 3, 4, 5, 6, 7, 8, 9, 10, J (bubi), Q (dáma), K (király)
 *
 * @author boss ;)
 */
public enum Rank {

    A(1), _2(2), _3(3), _4(4), _5(5), _6(6), _7(7), _8(8), _9(9), J(10), D(11), K(12);

    private int rankValue;

    private Rank(int rankValue) {
        this.rankValue = rankValue;
    }

    /**
     * a gson miat string be jön de enumba kéne mert egyszerűbb rendezni
     *
     * @param str -- a gsonban tárolt string
     * @return a stringnek megfelelő RANK
     */
    public Rank transformator(String str) {
        Rank returnRank = null;
        switch (str) {
            case "K":
                returnRank = Rank.K;
                break;
            case "D":
                returnRank = Rank.D;
                break;
            case "J":
                returnRank = Rank.J;
                break;
            case "9":
                returnRank = Rank._9;
                break;
            case "8":
                returnRank = Rank._8;
                break;
            case "7":
                returnRank = Rank._7;
                break;
            case "6":
                returnRank = Rank._6;
                break;
            case "5":
                returnRank = Rank._5;
                break;
            case "4":
                returnRank = Rank._4;
                break;
            case "3":
                returnRank = Rank._3;
                break;
            case "2":
                returnRank = Rank._2;
                break;
            case "A":
                returnRank = Rank.A;
                break;
                

        }
        return returnRank;

    }

}
