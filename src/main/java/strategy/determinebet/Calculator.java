/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.determinebet;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.Player;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;

/**
 *
 *
 * @author Tamás
 */
public class Calculator extends BaseFunctions {

    public Calculator(GameState gameState, Hand hand) {
        super(gameState, hand);
    }

    protected Integer getBetByCombination() {
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
        Integer actualBet = getBetByCombination();
        if (actualBet.equals(-1)) {
            return holdByStack(limit);
        }
        return actualBet;
    }

    protected Integer holdByStack(int limit) {
        if (stack < limit) {
            return throwCards();
        }
        return hold();
    }

    protected Integer raise(Hand hand) {
        HandRank base = highRanks.get(highRanks.size() - 1);
        HandRank rank = hand.getRank();
        int value = base.ordinal() - rank.ordinal();
        int level = 3 - hand.getLevel().ordinal();
        return highMultiplier * value * level + minimalbet;
    }

    protected Double getGivenPlayersPercent(Double givenPlayer) {
        return givenPlayer / numberOfPlayers;
    }

    protected boolean existBiggerBet(int i) {
        for (Player player : players) {
            if (player.getBet() > i * bet) {
                return true;
            }
        }
        return false;
    }
}
