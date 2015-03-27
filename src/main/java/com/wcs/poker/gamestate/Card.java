package com.wcs.poker.gamestate;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Card {

    @Expose
    private Rank rank;
    @Expose
    private Suits suit;

    /**
     *
     * @return the rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * set the rank to
     *
     * @param rank
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * @return the suit
     */
    public Suits getSuit() {
        return suit;
    }

    /**
     * set the suit to
     *
     * @param suit
     */
    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public boolean hasEqualRank(Card card) {
        if (this.getRank().equals(card.getRank())) {
            return true;
        }
        Rank.A.getRankValue();
        return false;
    }

}
