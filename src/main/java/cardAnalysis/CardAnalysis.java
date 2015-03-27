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

    public CardAnalysis() {
        uploadList();
    }

    /*Táblák feltöltése*/
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

            rank.setRank(Integer.toString(i));
            rankCount.add(rank);
        }

        rank.setRank("J");
        rankCount.add(rank);
        rank.setRank("Q");
        rankCount.add(rank);
        rank.setRank("K");
        rankCount.add(rank);
        rank.setRank("A");
        rankCount.add(rank);

    }
    //---------------------------------------

    /*Értékek analizálása*/
    public String analysisRankList(List<RankCount> rankcount) {

        String result = "none";
        int drill = 0;
        int pair = 0;
        int straight = 0;

        for (RankCount rankcount1 : rankcount) {
            result = "none";
            switch (rankcount1.getCount()) {
                case 2:
                    result = "pair";
                    pair++;
                    break;
                case 3:
                    result = "drill";
                    drill++;
                    break;
                case 4:
                    result = "poker";
                    break;

            }
            if (fullAnalysis(pair, drill)) {
                result = "full";
            }
            if (pair==2) {
                result= "2pair";
            }
            if (rankcount1.getCount() > 0) {
                straight++;
            } else {
                straight = 0;
            }
            
            if(rankcount1.getCount()>=5){
                result="straight";
            }
        }

        return result;

    }

    //full vizsgálat
    private boolean fullAnalysis(int value1, int value2) {
        if (value1 > 0 && value2 > 0) {
            return true;
        }
        return false;
    }

    //---------------------------------------------------
    @Override
    public String evaluateCards(List<Card> cards) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class RankCount {

    private String rank;
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

    public void setCount(int count) {
        this.count = count;
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

    public void setCount(int count) {
        this.count = count;
    }

}
