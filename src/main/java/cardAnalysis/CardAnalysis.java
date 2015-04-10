/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardAnalysis;

import com.wcs.poker.gamestate.Card;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MĂˇrtonZoltĂˇn
 */
public class CardAnalysis implements AnalysisInterface {

    /**
     * RankCountha & SuitCount
     */
    private List<RankCount> rankCount;
    private List<SuitCount> suitCount;

    // kombo Ă©s szint
    private String combo;
    private String level;
    private String flushLevel;

    public CardAnalysis() {
        uploadList();
    }

    /*TĂˇblĂˇk feltĂ¶ltĂ©se*/
    private void uploadList() {
        rankCount = new ArrayList<>();
        suitCount = new ArrayList<>();

        SuitCount suit = new SuitCount();

        suit.setSuit("heart");
        suitCount.add(suit);

        suit = new SuitCount();
        suit.setSuit("spade");
        suitCount.add(suit);

        suit = new SuitCount();
        suit.setSuit("diamonds");
        suitCount.add(suit);

        suit = new SuitCount();
        suit.setSuit("clubs");
        suitCount.add(suit);

        RankCount rank = new RankCount();
        for (int i = 2; i < 11; i++) {
            if (i < 7) {
                rank = new RankCount();
                rank.setLevel("low");
            } else {
                rank = new RankCount();
                rank.setLevel("medium");
            }
            rank.setRank(Integer.toString(i));
            rankCount.add(rank);

        }

        rank = new RankCount();
        rank.setRank("J");
        rank.setLevel("high");
        rankCount.add(rank);

        rank = new RankCount();
        rank.setRank("Q");
        rank.setLevel("high");
        rankCount.add(rank);

        rank = new RankCount();
        rank.setRank("K");
        rank.setLevel("high");
        rankCount.add(rank);

        rank = new RankCount();
        rank.setRank("A");
        rank.setLevel("high");
        rankCount.add(rank);

    }
    //---------------------------------------

    /*Ă‰rtĂ©kek analizĂˇlĂˇsa*/
    private String analysisRankList(List<RankCount> rankcount) {

        String result = "none";
        String levelresult = "none";

        String pair2Lelvel = "none";
        flushLevel = "none";
        String fullLevel = "none";

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
                    result = "pair";
                    levelresult = rankcount1.getLevel();
                    pair2Lelvel = rankcount1.getLevel();
                    pair++;
                    break;
                case 3:
                    result = "drill";
                    levelresult = rankcount1.getLevel();
                    fullLevel = rankcount1.getLevel();
                    drill++;
                    break;
                case 4:
                    result = "poker";
                    levelresult = rankcount1.getLevel();
                    break;

            }
            if (fullAnalysis(pair, drill)) {
                result = "full";
                levelresult = fullLevel;
            }
            if (pair == 2) {
                result = "2pair";
                levelresult = pair2Lelvel;
            }
            if (rankcount1.getCount() > 0 && index != 0 && rankcount.get(index - 1).getCount() != 0) {
                straight++;

                if (straight >= 5) {
                    result = "straight";
                    levelresult = rankcount1.getLevel();
                }
            }
            index++;
        }

        if (a && k && q && j && ten) {
            result = "royal";
        }

        return result + "," + levelresult;

    }

    //full vizsgĂˇlat
    private boolean fullAnalysis(int value1, int value2) {
        return value1 > 0 && value2 > 0;
    }

    //---------------------------------------------------
    /*Suit analizĂˇlĂˇsĂˇla  */
    private String suitAnalysis(List<SuitCount> suitcount) {
        String result = "none";
        for (SuitCount suitcount1 : suitcount) {
            if (suitcount1.getCount() >= 5) {
                result = "flush";
            }
        }

        return result;
    }
    //------------------

    public void evaluateCards(List<Card> cards) {

        for (Card card : cards) {
            for (RankCount rankCount1 : rankCount) {
                if (rankCount1.getRank().equals(card.getRank())) {
                    rankCount1.setCount();
                }
            }
        }

        for (Card card : cards) {
            for (SuitCount suitCount1 : suitCount) {
                if (suitCount1.getSuit().equals(card.getSuit())) {
                    suitCount1.setCount();
                }
            }
        }

        String suitAnalysisResult;
        String analysisRankListResult;
        String analysisRankListLevelResult;

        combo = "none";
        level = "none";
        String[] splitString = analysisRankList(rankCount).split(",");

        analysisRankListResult = splitString[0];
        analysisRankListLevelResult = splitString[1];

        suitAnalysisResult = suitAnalysis(suitCount);

        if ("none".equals(suitAnalysisResult)) {
            combo = analysisRankListResult;
        } else {
            combo = suitAnalysisResult;
        }

        if ("straight".equals(analysisRankListResult) && "flush".equals(suitAnalysisResult)) {
            combo = "straight flush";
        }

        if ("royal".equals(analysisRankListResult) && "flush".equals(suitAnalysisResult)) {
            combo = "royal flush";
        }

        level = analysisRankListLevelResult;

        if ("flush".equals(combo)) {
            level = flushLevel;
        }

        if ("none".equals(combo)) {
            level = flushLevel;
        }
    }

    public String getCombo() {
        return combo;
    }

    public String getLevel() {
        return level;
    }
}

class RankCount {

    private String rank;
    private String level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}

class SuitCount {

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
