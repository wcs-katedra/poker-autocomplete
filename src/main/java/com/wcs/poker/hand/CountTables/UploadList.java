/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.hand.CountTables;


import com.wcs.poker.hand.enums.HandLevel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MártonZoltán
 */
public class UploadList {

    public List<RankCount> RankCountUpload() {
        List<RankCount> rankCount = new ArrayList<>();

        RankCount rank = new RankCount();

        for (int i = 2; i < 11; i++) {
            if (i < 7) {
                rank = new RankCount();
                rank.setLevel(HandLevel.LOW);
            } else {
                rank = new RankCount();
                rank.setLevel(HandLevel.MEDIUM);
            }
            rank.setRank(Integer.toString(i));
            rankCount.add(rank);

        }

        rank = new RankCount();
        rank.setRank("J");
        rank.setLevel(HandLevel.HIGH);
        rankCount.add(rank);

        rank = new RankCount();
        rank.setRank("Q");
        rank.setLevel(HandLevel.HIGH);
        rankCount.add(rank);

        rank = new RankCount();
        rank.setRank("K");
        rank.setLevel(HandLevel.HIGH);
        rankCount.add(rank);

        rank = new RankCount();
        rank.setRank("A");
        rank.setLevel(HandLevel.HIGH);
        rankCount.add(rank);

        return rankCount;
    }

    public List<SuitCount> SuitCountUpload() {

        List<SuitCount> suitCount = new ArrayList<>();
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
        
        return suitCount;
    }

}
