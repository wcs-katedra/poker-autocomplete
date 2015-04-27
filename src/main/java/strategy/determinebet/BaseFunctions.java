/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.determinebet;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Tamás
 */
public class BaseFunctions extends BaseFields {

    private List<HandRank> extremeRanks = Arrays.asList(
            HandRank.ROYAL_FLUSH,
            HandRank.STRAIGHT_FLUSH,
            HandRank.FOUR_OF_A_KIND);
    protected List<HandRank> highRanks = Arrays.asList(
            HandRank.FULL_HOUSE,
            HandRank.FLUSH,
            HandRank.STRAIGHT);
    protected List<HandRank> mediumRanks = Arrays.asList(
            HandRank.THREE_OF_A_KIND,
            HandRank.TWO_PAIRS,
            HandRank.PAIR);

    protected int extremeMultiplier = 30;
    protected int highMultiplier = 20;
    protected int mediumMultiplier = 10;

    public BaseFunctions(GameState gameState, Hand hand) {
        super(gameState, hand);
    }

    protected Integer throwCards() {
        return 0;
    }

    protected Integer hold() {
        if (call > 0) {
            return call;
        } else {
            return 1;
        }
    }

    protected Integer allIn() {
        int random;
        do {
            random = new Random().nextInt(9);
        } while (smallBlind * random > stack);
        return stack - smallBlind * random;
    }

    protected boolean isExtremeCombination(Hand hand) {
        return isCombination(extremeRanks, hand);
    }

    protected boolean isHighCombination(Hand hand) {
        return isCombination(highRanks, hand);
    }

    protected boolean isMediumCombination(Hand hand) {
        return isCombination(mediumRanks, hand);
    }

    private boolean isCombination(List<HandRank> list, Hand hand) {
        return list.contains(hand.getRank());
    }
}
