/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import java.util.ArrayList;
import java.util.List;
import javax.faces.convert.Converter;

/**
 *
 * @author MártonZoltán
 */
public class CardAnalysis {
    
    /**
     * RankCount & SuitCount
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
   
   

}


class SuitCount{
    
    private String suit;
    private Integer count=0;

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    
    
}