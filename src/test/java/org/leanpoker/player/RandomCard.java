/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author boss
 */
public class RandomCard {

    private Set<Card> sentCards = new HashSet<Card>();
    private final String[] ranks = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"};
    private final String[] suits = {"heart", "diamond", "spade", "clubs"};
    
    /**
     * Genereta a random card. Returns it only if it was not sended out earlyer
     * @return a random card
     */
    public Card getRandomCard() {
        Random rnd = new Random();
        int rndRank;
        int rndSuit;
        Card card = new Card();
        
        do{           
            rndRank = rnd.nextInt(ranks.length);
            card.setRank(ranks[rndRank]);
            
            rndSuit = rnd.nextInt(suits.length);
            card.setSuit(suits[rndSuit]);
        }while(sentCards.contains(card));
        sentCards.add(card);

        return card;
    }

}
