/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.determinebet;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.work.Hand;

/**
 *
 * @author Tamás
 */
public class Calculator extends BaseFunctions {

    public Calculator(GameState gameState, Hand hand) {
        super(gameState, hand);
    }

    protected Integer hold(Hand hand) {
        return minimalbet;
    }

    protected Integer raise(Hand hand) {
        return minimalbet;
    }
}