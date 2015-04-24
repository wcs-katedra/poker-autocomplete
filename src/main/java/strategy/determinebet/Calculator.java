/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.determinebet;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;

/**
 *
 * @author Tamás
 */
public class Calculator extends BaseFunctions {

    public Calculator(GameState gameState, Hand hand) {
        super(gameState, hand);
    }

    protected Integer getBetPre() {
        if (isExtremeCombination(hand)) {
            return allIn();
        } else if (isHighCombination(hand)) {
            return raise(hand);
        } else if (isMediumCombination(hand)) {
            return hold();
        }
        return -1;
    }

    protected Integer getFinalBet(int limit) {
        Integer bet = getBetPre();
        if (bet.equals(-1)) {
            return holdByStack(limit);
        }
        return throwCards();
    }

    protected Integer holdByStack(int limit) {
        if (stack < limit) {
            return throwCards();
        }
        return hold();
    }

    protected Integer raise(Hand hand) {
        HandRank base = highRanks.get(highRanks.size()-1);
        HandRank rank = hand.getRank();
        int value = base.ordinal()-rank.ordinal();        
        int level = 3-hand.getLevel().ordinal();
        return (stack-minimalbet)/100*highMultiplier*(value*level)+minimalbet;
    }
}
