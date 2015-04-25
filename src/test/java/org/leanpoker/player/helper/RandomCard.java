/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.helper;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.enums.Rank;
import com.wcs.poker.gamestate.enums.Suit;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author boss
 */
public class RandomCard {

    private Set<Card> sentCards = new HashSet<Card>();
    private final Rank[] ranks = Rank.values();
    private final Suit[] suits =Suit.values();
    
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
