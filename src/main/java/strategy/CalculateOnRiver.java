/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.work.Hand;
import strategy.determinebet.Calculator;

/**
 *
 * @author gergo
 */
public class CalculateOnRiver extends Calculator implements Evaluate {

    public CalculateOnRiver(GameState gameState, Hand hand) {
        super(gameState, hand);
    }

    @Override
    public Integer getBet() {
        return getFinalBet(400);
    }

}
