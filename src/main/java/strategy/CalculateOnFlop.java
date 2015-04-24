package strategy;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.work.Hand;
import strategy.determinebet.Calculator;

/**
 *
 * @author gergo
 */
public class CalculateOnFlop extends Calculator implements Evaluate {

    public CalculateOnFlop(GameState gameState, Hand hand) {
        super(gameState, hand);
    }

    @Override
    public Integer getBet() {
        if (LowCombination(hand)) {
            return throwCards();
        } else if (MediumCombination(hand)) {
            return getMediumCombination(hand);
        } else {
            return getHighCombination(hand);
        }
    }

}
