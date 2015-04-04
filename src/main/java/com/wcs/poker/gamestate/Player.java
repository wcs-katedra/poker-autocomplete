
package com.wcs.poker.gamestate;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Player {

    @Expose
    private Integer id;
    @Expose
    private Rank name;
    @Expose
    private Rank status;
    @Expose
    private Rank version;
    @Expose
    private Integer stack;
    @Expose
    private Integer bet;
    @SerializedName("hole_cards")
    @Expose
    private List<Card> holeCards = new ArrayList<Card>();

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public Rank getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(Rank name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The status
     */
    public Rank getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(Rank status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The version
     */
    public Rank getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(Rank version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The stack
     */
    public Integer getStack() {
        return stack;
    }

    /**
     * 
     * @param stack
     *     The stack
     */
    public void setStack(Integer stack) {
        this.stack = stack;
    }

    /**
     * 
     * @return
     *     The bet
     */
    public Integer getBet() {
        return bet;
    }

    /**
     * 
     * @param bet
     *     The bet
     */
    public void setBet(Integer bet) {
        this.bet = bet;
    }

    /**
     * 
     * @return
     *     The holeCards
     */
    public List<Card> getHoleCards() {
        return holeCards;
    }

    /**
     * 
     * @param holeCards
     *     The hole_cards
     */
    public void setHoleCards(List<Card> holeCards) {
        this.holeCards = holeCards;
    }

}
