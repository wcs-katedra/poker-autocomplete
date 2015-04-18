/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.hand.work;


import com.wcs.poker.hand.CountTables.RankCount;
import com.wcs.poker.hand.CountTables.SuitCount;
import com.wcs.poker.hand.enums.HandLevel;
import com.wcs.poker.hand.enums.HandRank;
import java.util.List;

/**
 *
 * @author MártonZoltán
 */
public class Counting {

    private HandLevel flushLevel;
    private HandLevel levelresult;

    public HandRank analysisRankList(List<RankCount> rankcount) {

        HandRank result = null;
        levelresult = null;

        HandLevel pair2Lelvel = null;
        flushLevel = null;
        HandLevel fullLevel = null;

        boolean a = false;
        boolean k = false;
        boolean q = false;
        boolean j = false;
        boolean ten = false;

        int drill = 0;
        int pair = 0;
        int straight = 1;
        int index = 0;

        for (RankCount rankcount1 : rankcount) {
            if (rankcount1.getCount() > 0) {
                flushLevel = rankcount1.getLevel();
                switch (rankcount1.getRank()) {
                    case "A":
                        a = true;
                        break;
                    case "K":
                        k = true;
                        break;
                    case "Q":
                        q = true;
                        break;
                    case "J":
                        j = true;
                        break;
                    case "10":
                        ten = true;
                        break;

                }
            }

            switch (rankcount1.getCount()) {
                case 2:
                    result = HandRank.PAIR;
                     levelresult = rankcount1.getLevel();
                     pair2Lelvel = rankcount1.getLevel();
                    pair++;
                    break;
                case 3:
                    result = HandRank.THREE_OF_A_KIND;
                       levelresult = rankcount1.getLevel();
                       fullLevel = rankcount1.getLevel();
                    drill++;
                    break;
                case 4:
                    result = HandRank.FOUR_OF_A_KIND;
                    levelresult = rankcount1.getLevel();
                    break;

            }
            if (fullAnalysis(pair, drill)) {
                result = HandRank.FULL_HOUSE;
                levelresult = fullLevel;
            }
            if (pair == 2) {
                result = HandRank.TWO_PAIRS;
                levelresult = pair2Lelvel;
            }
            if (rankcount1.getCount() > 0 && index != 0 && rankcount.get(index - 1).getCount() != 0) {
                straight++;

                if (straight >= 5) {
                    result = HandRank.STRAIGHT;
                    levelresult = rankcount1.getLevel();
                }
            }
            index++;
        }

        if (a && k && q && j && ten) {
            result = HandRank.ROYAL;
        }

        return result;

    }

    //full vizsgĂˇlat
    private boolean fullAnalysis(int value1, int value2) {
        return value1 > 0 && value2 > 0;
    }

    //---------------------------------------------------
    /*Suit analizĂˇlĂˇsĂˇla  */
    public HandRank suitAnalysis(List<SuitCount> suitcount) {
        HandRank result = null;
        for (SuitCount suitcount1 : suitcount) {
            if (suitcount1.getCount() >= 5) {
                result = HandRank.FLUSH;
            }
        }

        return result;
    }

    public HandLevel getLevelresult() {
        return levelresult;
    }

    public HandLevel getFlushLevel() {
        return flushLevel;
    }
    
    
    
    
}
