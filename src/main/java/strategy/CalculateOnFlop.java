package strategy;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;

/**
 *
 * @author gergo
 */
public class CalculateOnFlop extends DetermineBet implements Evaluate {

    public CalculateOnFlop(GameState gameState, HandRank handRank) {
        super(gameState, handRank);
    }

    @Override
    public Integer getBet() {
        if (LowCombination(handRank)) {
            return throwCards();
        } else if (MediumCombination(handRank)) {
            return getMediumCombination(handRank);
        } else {
            return getHighCombination(handRank);
        }
    }

}
