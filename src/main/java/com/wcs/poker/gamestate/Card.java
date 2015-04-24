package com.wcs.poker.gamestate;

import com.wcs.poker.gamestate.enums.Rank;
import com.wcs.poker.gamestate.enums.Suit;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import java.util.Objects;

@Generated("org.jsonschema2pojo")
public class Card implements Comparable<Card> {

    @Expose
    private Rank rank;
    @Expose
    private Suit suit;

    public String getRankS() {
        return rank.name();
    }

    public void setRankS(String rankS) {
        if (rankS.matches("\\d+")) {
            this.rank = Rank.valueOf("_" + rankS);
        } else {
            this.rank = Rank.valueOf(rankS);
        }

    }

    public String getSuitS() {
        return suit.name();
    }

    public void setSuitS(String suitS) {
        this.suit = Suit.valueOf(suitS.toUpperCase());
    }

    /**
     *
     * @return the rankE
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * set the rankE to
     *
     * @param rank
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     * @return the suitR
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * set the suitR to
     *
     * @param suit
     */
    public void setSuit(Suit suit) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.rank);
        hash = 41 * hash + Objects.hashCode(this.suit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.rank != other.rank) {
            return false;
        }
        if (this.suit != other.suit) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Card o) {
        int retVal;

        if (o.getRank().equals(rank)) {
            retVal = suit.compareTo(o.getSuit());
        } else {
            retVal = o.getRank().compareTo(rank);
        }

        return retVal;
    }

}
