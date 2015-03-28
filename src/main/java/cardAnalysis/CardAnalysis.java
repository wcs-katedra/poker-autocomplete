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
        suit.setSuit("spade");
        suitCount.add(suit);
        suit.setSuit("diamonds");
        suitCount.add(suit);
        suit.setSuit("clubs");
        suitCount.add(suit);

        RankCount rank = new RankCount();
        for (int i = 2; i < 11; i++) {
            if (i < 6) {
                rank.setLevel("low");
            } else {
                rank.setLevel("medium");
            }
            rank.setRank(Integer.toString(i));
            rankCount.add(rank);
        }

        rank.setRank("J");
        rank.setLevel("high");
        rankCount.add(rank);
        rank.setRank("Q");
        rank.setLevel("high");
        rankCount.add(rank);
        rank.setRank("K");
        rank.setLevel("high");
        rankCount.add(rank);
        rank.setRank("A");
        rank.setLevel("high");
        rankCount.add(rank);

    }
    //---------------------------------------

    /*Ă‰rtĂ©kek analizĂˇlĂˇsa*/
    private String analysisRankList(List<RankCount> rankcount) {

        String result = "none";
        String levelresult = "none";
        int drill = 0;
        int pair = 0;
        int straight = 0;

        for (RankCount rankcount1 : rankcount) {
            result = "none";
            switch (rankcount1.getCount()) {
                case 2:
                    result = "pair";
                    levelresult = rankcount1.getLevel();
                    pair++;
                    break;
                case 3:
                    result = "drill";
                    levelresult = rankcount1.getLevel();
                    drill++;
                    break;
                case 4:
                    result = "poker";
                    levelresult = rankcount1.getLevel();
                    break;

            }
            if (fullAnalysis(pair, drill)) {
                result = "full";
                levelresult = rankcount1.getLevel();
            }
            if (pair == 2) {
                result = "2pair";
                levelresult = rankcount1.getLevel();
            }
            if (rankcount1.getCount() > 0) {
                straight++;
            } else {
                straight = 0;
            }

            if (rankcount1.getCount() >= 5) {
                result = "straight";
                levelresult = rankcount1.getLevel();
            }
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
            if (suitcount1.getCount() == 5) {
                result = "flush";
            }
        }

        return result;
    }
    //------------------

    @Override

    public void evaluateCards(List<Card> cards) {

        for (int i = 0; i < cards.indexOf(cards.size() - 1); i++) {
            for (int j = 0; j < rankCount.indexOf(rankCount.size() - 1); j++) {
                if (cards.get(i).getRank().equals(rankCount.get(j))) {
                    rankCount.get(j).setCount();

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

        level = analysisRankListLevelResult;
    }

    @Override
    public String getCombo() {
        return combo;
    }

    @Override
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
