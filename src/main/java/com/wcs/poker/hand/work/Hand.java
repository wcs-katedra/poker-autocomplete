package com.wcs.poker.hand.work;



import com.wcs.poker.gamestate.Card;
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
    private final Collection<Card> cards;

    public Hand(HandRank rank, List<Card> cards) {
        this.rank = rank;
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Hand{" + "rank=" + rank + ", cards=" + cards + '}';
    }

    
    public HandRank getRank() {
        return rank;
    }

    public Collection<Card> getCards() {
        return cards;
    }
}
