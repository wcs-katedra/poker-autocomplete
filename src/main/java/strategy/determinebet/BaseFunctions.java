/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.determinebet;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Tamás
 */
public class BaseFunctions extends BaseFields {

    private List<HandRank> highRanks = new ArrayList<>();
    private List<HandRank> mediumRanks = new ArrayList<>();

    public BaseFunctions(GameState gameState, Hand hand) {
        super(gameState, hand);
        initHighRanks();
        initMediumRanks();
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
        return isCombination(highRanks, hand);
    }

    protected boolean isMediumCombination(Hand hand) {
        return isCombination(mediumRanks, hand);
    }

    private boolean isCombination(List<HandRank> list, Hand hand) {
        for (HandRank highRank : list) {
            if (highRank.equals(hand.getRank())) {
                return true;
            }
        }
        return false;
    }

    private void initHighRanks() {
        highRanks.add(HandRank.ROYAL_FLUSH);
        highRanks.add(HandRank.STRAIGHT_FLUSH);
        highRanks.add(HandRank.FOUR_OF_A_KIND);
        highRanks.add(HandRank.FULL_HOUSE);
    }

    private void initMediumRanks() {
        mediumRanks.add(HandRank.FLUSH);
        mediumRanks.add(HandRank.STRAIGHT);
        mediumRanks.add(HandRank.THREE_OF_A_KIND);
    }

}