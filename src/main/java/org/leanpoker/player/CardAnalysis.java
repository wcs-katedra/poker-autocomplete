/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import java.util.ArrayList;
import java.util.List;
import javax.faces.convert.Converter;

/**
 *
 * @author MártonZoltán
 */
public class CardAnalysis {
    
    /**
     * RankCountha & SuitCount
     */
    private List<RankCount> rankCount;
    private List<SuitCount> suitCount;
    
    
    private void uploadList(){
        rankCount= new ArrayList<>();
        suitCount= new ArrayList<>();
        
        SuitCount suit = new SuitCount();
        
        suit.setSuit("heart");
        suitCount.add(suit);
        suit.setSuit("spade");
        suitCount.add(suit);
        suit.setSuit("diamonds");
        suitCount.add(suit);
        suit.setSuit("clubs");
        suitCount.add(suit);
        
        
        
        RankCount rank= new RankCount();
        for (int i = 0; i < 9; i++) {
            
           rank.setRank(Integer.toString(i));
           rankCount.add(rank);
        }
      
        rank.setRank("j");
        rankCount.add(rank);
        rank.setRank("d");
        rankCount.add(rank); 
        rank.setRank("k");
        rankCount.add(rank); 
        rank.setRank("a");
        rankCount.add(rank);
        
        
       
        
    }
    
    
    
    public String analysisRankList(List<RankCount> rankcount){
       
        String result="none";
        int drill=0;
        int pair=0;
        
        for (RankCount rankcount1 : rankcount) {
             result=analysisRank(rankcount1.getCount(), drill, pair);
        }
        
        return result;
        
    }
    
    private String analysisRank(int count, int drill, int pair){
        String result="";
        switch(count){
            case 2: result="pair";
                    pair++;
            case 3: result="drill";
                    drill++;
            case 4: result="poker";
               
        }
        if(drillAnalysis(pair, drill)) 
            result="full";
        
        return result;
         }
    
    private boolean drillAnalysis(int value1, int value2){
        if(value1>0 && value2>0){
            return true;
         }
        return false;
    }
}

class RankCount{
    
   private String rank;
   private Integer count=0;

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


class SuitCount{
    
    private String suit;
    private int count=0;

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