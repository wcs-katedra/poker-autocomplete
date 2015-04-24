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
public class CalculateOnTurn extends Calculator implements Evaluate{

    public CalculateOnTurn(GameState gameState,Hand hand) {
        super(gameState,hand);
    }

    @Override
    public Integer getBet() {
        if (LowCombination(hand)) {
             return throwCards();
        } else if (MediumCombination(hand)) {
            return holdCards();
        } else {
            return getHighCombination(hand);
        }
    }
    
}
