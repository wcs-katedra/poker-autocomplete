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
        if (isHighCombination(hand)) {
            return raise(hand);
        } else if (isMediumCombination(hand)) {
            return hold(hand);
        }
        return throwCards();
    }

    private Integer raise(Hand hand) {
        return super.raise(hand, null);
    }

    private Integer hold(Hand hand) {
        return super.raise(hand, null);
    }

}
