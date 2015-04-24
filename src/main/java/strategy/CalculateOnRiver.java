/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;

/**
 *
 * @author gergo
 */
public class CalculateOnRiver extends DetermineBet implements Evaluate{

    public CalculateOnRiver(GameState gameState,HandRank handRank) {
        super(gameState,handRank);
    }

    @Override
    public Integer getBet() {
        return 0;
    }
    
}
