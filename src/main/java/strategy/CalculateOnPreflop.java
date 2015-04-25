package strategy;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandLevel;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;
import strategy.determinebet.Calculator;

/**
 * Here we determine the bet for the preflop gamestate. Fields are in the
 * BaseFields class. Taut Aggressive TAG - Feszes agresszív játék Loose
 * Aggressive LAG - Laza agresszív játék
 *
 * @author gergo
 */
public class CalculateOnPreflop extends Calculator implements Evaluate {

    private int baseHoldValue = 60;

    public CalculateOnPreflop(GameState gs, Hand hand) {
        super(gs, hand);
    }

    @Override
    public Integer getBet() {
        if (HandRank.PAIR.equals(hand.getRank())) {
            return holdUntilLimit(hand.getLevel(), 3);
        } else if (HandRank.HIGH_CARD.equals(hand.getRank())) {
            return holdUntilLimit(hand.getLevel(), 2);
        } else {
            return holdUntilLimit(hand.getLevel(), 1);
        }

    }

    private Integer holdUntilLimit(HandLevel level, int factor) {
        int holdLimit = (level.ordinal() + 1) * baseHoldValue;
        if (bet < holdLimit * (factor * 3 / 100 + 1)) {
            return riseORHoldBylevel(level);
        } else {
            return throwCards();
        }
    }

    private Integer riseORHoldBylevel(HandLevel level) {
        if (HandLevel.HIGH.equals(level)) {
            return riseBy(20);
        } else if (HandLevel.HIGH.equals(level)) {
            return riseBy(10);
        }
        return hold();
    }

    private Integer riseBy(int raise) {
        return minimalbet+raise;
    }

}
