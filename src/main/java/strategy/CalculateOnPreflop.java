package strategy;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;
import strategy.determinebet.Calculator;

/**
 * Here we determine the bet for the preflop gamestate. Fields are in the DetermineBetBaseFields class. 
 Taut Aggressive TAG - Feszes agresszív játék Loose
 Aggressive LAG - Laza agresszív játék
 *
 * @author gergo
 */
public class CalculateOnPreflop extends Calculator implements Evaluate {

    public CalculateOnPreflop(GameState gs, Hand hand){
        super(gs, hand);
    }

    @Override
    public Integer getBet() {
        return minimalbet;
    }





}
