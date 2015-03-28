/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import com.wcs.poker.gamestate.Card;

/**
 *
 * @author gergo
 */
public class DetermineBet implements evaluate{

    private int bigBlind;
    private int minimumRaise;
    private int currentBuyIn;
    private int pot;
    private int stack;

    public DetermineBet(int bigBlind, int minimumRaise, int currentBuyIn, int pot, int stack) {
        this.bigBlind = bigBlind;
        this.minimumRaise = minimumRaise;
        this.currentBuyIn = currentBuyIn;
        this.pot = pot;
        this.stack = stack;
    }
    
    /**
     * Ezek a valtozók nekem kellenének, nem az én oszátályom adja át, ezekből kellene meghatároznom a pontos Bet-et, 
     * ha nem tudom mennyivel kell minimum emelni vagy mennyi van bent akkor igazából csak számokkal dobálózok. :D
     * Egyenlőre brutefocre taktika, ha van valami emelünk, minnél jobb annál többet. Ha átvariáljuk akkor sokkal jobban
     * ki tudom majd számolni a pontos bet-et.
     * 
     * @param combo
     * @param level
     * @return bet
     */
    
    

    @Override
    public Integer getBet(String combo, String level)
    {
        Integer bet = 0;
        CardString firstCard = new CardString();
        CardString secondCard = new CardString();
        
        String pokerHand = combo+","+level;
        
        switch(pokerHand){
            case "none,low": bet = 0; break;
            case "none,medium": bet = 0; break;
            case "none,high": bet = 0; break;
                
            case "pair,low": bet = bigBlind+100; break;
            case "pair,medium": bet = bigBlind+100; break;
            case "pair,high": bet = bigBlind+150; break;
                
            case "2pair,low": bet = bigBlind+200; break;
            case "2pair,medium": bet = bigBlind+200; break;
            case "2pair,high": bet = bigBlind+200; break;
                
            case "drill,low": bet = bigBlind+300; break;
            case "drill,medium": bet = bigBlind+300; break;
            case "drill,high": bet = bigBlind+300; break;
                
            case "straight,low": bet = bigBlind+300; break;
            case "straight,medium": bet = bigBlind+300; break;
            case "straight,high": bet = bigBlind+300; break;
                
            case "full,low": bet = bigBlind+300; break;
            case "full,medium": bet = bigBlind+300; break;
            case "full,high": bet = bigBlind+300; break; 
                
            case "poker,low": bet = bigBlind+300; break;
            case "poker,medium": bet = bigBlind+300; break;
            case "poker,high": bet = bigBlind+300; break;
                
            case "flush,low": bet = bigBlind+400; break;
            case "flsuh,medium": bet = bigBlind+400; break;
            case "flush,high": bet = bigBlind+400; break;
            
            case "straight flush,low": bet = bigBlind+500; break;
            case "straight flush,medium": bet = bigBlind+500; break;
            case "straight flush,high": bet = bigBlind+500; break;
//               Még hiányzik a CardAnalisis-ből.
                
//            case "royal flush,low": bet = bigBlind+500; break;
//            case "royal flush,medium": bet = bigBlind+500; break;
//            case "royal flush": bet = bigBlind+500; break;                            
        }           
        return bet;
    }  
}
