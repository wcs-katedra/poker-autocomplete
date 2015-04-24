/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.determinebet;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.enums.PlayerState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;

/**
 *
 * @author gergo
 */
public class BaseFields {

    /**
     * A kis vak kétszerese.
     */
    protected final int bigBlind;
    /**
     * A kis vak értéke.
     */
    protected final int smallBlind;
    /**
     * Az az összeg ami a legkisebb emeléshez kell.
     */
    protected final int minimumRaise;
    /**
     * A legmagasabb tét értéke, amit meg kell adni.
     */
    protected final int currentBuyIn;
    /**
     * A pénzhalom nagysága az asztalon.
     */
    protected final int pot;
    /**
     * A játékos zsetonjai.
     */
    protected final int stack;
    /**
     * Ennyiszer ért körbe az osztókorong.
     */
    protected final int orbits;
    /**
     * Az ebben a körben tétnek feltett zsetoinok összege.
     */
    protected final int bet;
    /**
     * Call értékének számítása: current_buy_in - players[in_action][bet] TODO
     * írd meg rendesen hogy mi a ** ez :D
     */
    protected final int call;
    /**
     * ez mi ez meg ez :D
     */
    protected final int minimalbet;
    /**
     * Az aktuális játékállapotban aktív játékososk száma.
     */
    protected final int numberOfActivePlayers;
    /**
     * Az aktuális játékállapotban már bedobott játékososk száma.
     */
    protected final int numberOfFoldedPlayers;
    /**
     * Az aktuális játékállapotban a játékon kívüli játékososk száma.
     */
    protected final int numberOfOutPlayers;

    protected Hand hand;

    public BaseFields(GameState gameState, Hand hand) {

        bigBlind = gameState.getBigBlind();
        smallBlind = gameState.getSmallBlind();
        minimumRaise = gameState.getMinimumRaise();
        currentBuyIn = gameState.getCurrentBuyIn();
        pot = gameState.getPot();
        stack = gameState.getCurrentPlayerStack();
        call = gameState.calculateCall();
        minimalbet = gameState.calculateMinimalBet();
        orbits = gameState.getOrbits();
        bet = gameState.getCurrentPlayerbBet();
        numberOfActivePlayers = gameState.getNumberOfPlayers(PlayerState.ACTIVE);
        numberOfFoldedPlayers = gameState.getNumberOfPlayers(PlayerState.FOLDED);
        numberOfOutPlayers = gameState.getNumberOfPlayers(PlayerState.OUT);

        this.hand = hand;
    }

    protected Integer throwCards() {
        return 0;
    }

    protected Integer holdCards() {
        return minimalbet;
    }

    protected Integer raiseBet(int amount) {
        return minimalbet + amount;
    }

    protected Integer allIn() {
        return stack-smallBlind;
    }

    protected Integer getDoubleBigBlind() {
        return 2 * bigBlind;
    }

    protected Integer getTripleBigBlind() {
        return 3 * bigBlind;
    }

    protected Integer getAmountOfBigBlind(int number) {
        return bigBlind * number;
    }

    protected boolean LowCombination(Hand hand) {
        if (hand.equals(HandRank.HIGH_CARD)) {
            return true;
        } else if (hand.equals(HandRank.PAIR)) {
            return true;
        } else {
            return hand.equals(HandRank.TWO_PAIRS);
        }
    }

    protected boolean MediumCombination(Hand hand) {
        if (hand.equals(HandRank.THREE_OF_A_KIND)) {
            return true;
        } else if (hand.equals(HandRank.STRAIGHT)) {
            return true;
        } else if (hand.equals(HandRank.FLUSH)) {
            return true;
        } else {
            return hand.equals(HandRank.FULL_HOUSE);
        }
    }

    protected Integer getLowCombination(Hand hand) {
        if (hand.equals(HandRank.HIGH_CARD)) {
            return highCardBet();
        } else if (hand.equals(HandRank.PAIR)) {
            return pairBet();
        } else {
            return twoPairBet();
        }
    }

    protected Integer getMediumCombination(Hand hand) {
        if (hand.equals(HandRank.THREE_OF_A_KIND)) {
            return threeOfAKindBet();
        } else if (hand.equals(HandRank.STRAIGHT)) {
            return straightBet();
        } else if (hand.equals(HandRank.FLUSH)) {
            return flushBet();
        } else {
            return fullHouseBet();
        }
    }

    protected Integer getHighCombination(Hand hand) {
        if (hand.equals(HandRank.FOUR_OF_A_KIND)) {
            return fourOfAKindBet();
        } else if (hand.equals(HandRank.STRAIGHT_FLUSH)) {
            return straightFlushBet();
        } else {
            return royalFlushBet();
        }
    }

    protected Integer highCardBet() {
        return minimalbet;
    }

    protected Integer pairBet() {
        return minimalbet;
    }

    protected Integer twoPairBet() {
        return minimalbet;
    }

    private Integer threeOfAKindBet() {
        return minimalbet;
    }

    private Integer straightBet() {
        return minimalbet;
    }

    private Integer flushBet() {
        return minimalbet;
    }

    private Integer fullHouseBet() {
        return minimalbet;
    }

    private Integer fourOfAKindBet() {
        return minimalbet;
    }

    private Integer royalFlushBet() {
        return minimalbet;
    }

    private Integer straightFlushBet() {
        return minimalbet;
    }

}
