/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.determinebet;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;
import java.util.Random;

/**
 *
 * @author Tamás
 */
public class BaseFunctions extends BaseFields {

    public BaseFunctions(GameState gameState, Hand hand) {
        super(gameState, hand);
    }

    /**
     *
     * @return
     */
    protected Integer throwCards() {
        return 0;
    }

    protected Integer allIn() {
        return stack - smallBlind * new Random().nextInt(9);
    }

    protected boolean isHighCombination(Hand hand) {
        if (hand.equals(HandRank.HIGH_CARD)) {
            return true;
        } else if (hand.equals(HandRank.PAIR)) {
            return true;
        } else {
            return hand.equals(HandRank.TWO_PAIRS);
        }
    }

    protected boolean isMediumCombination(Hand hand) {
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
    

}
