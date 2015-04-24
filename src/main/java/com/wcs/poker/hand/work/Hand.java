package com.wcs.poker.hand.work;



import com.wcs.poker.gamestate.Card;
import com.wcs.poker.hand.enums.HandLevel;
import com.wcs.poker.hand.enums.HandRank;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author thomas
 */
public class Hand {

    private final HandRank rank;
    private final HandLevel level;
    private final Collection<Card> cards;

    
     public Hand(HandRank rank,HandLevel level, List<Card> cards) {
        this.rank = rank;
        this.level=level;
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Hand{" + "rank=" + rank + ", level=" + level + ", cards=" + cards + '}';
    }

   

    
    public HandRank getRank() {
        return rank;
    }

    public HandLevel getLevel() {
        return level;
    }

    
    public Collection<Card> getCards() {
        return cards;
    }
}
