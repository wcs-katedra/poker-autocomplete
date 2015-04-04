package com.wcs.poker.gamestate;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Card {

    @Expose
    private String rank;
    @Expose
    private String suit;

    /**
     *
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * set the rank to
     *
     * @param rank
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * set the suit to
     *
     * @param suit
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" + "rank=" + rank + ", suit=" + suit + "}";
    }

    public boolean hasEqualRank(Card card) {
        if (this.getRank().equals(card.getRank())) {
            return true;
        }
        return false;
    }

}
