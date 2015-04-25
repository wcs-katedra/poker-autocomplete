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

    private Integer holdLimit = 1000;

    public CalculateOnPreflop(GameState gs, Hand hand) {
        super(gs, hand);
    }

    @Override
    public Integer getBet() {
        if (HandRank.PAIR.equals(hand.getRank())) {
            return betByPair(hand.getLevel());
        } else if (HandRank.HIGH_CARD.equals(hand.getLevel())) {
            return betByHighCard(hand.getLevel());
        } else {
            return holdUntilLimit(null);
        }

    }

    private Integer holdUntilLimit(Integer limit) {
        // we got nothing
        limit = limitWhenLimitNull(limit);
        if (bet < limit.intValue()) {
            return minimalbet;
        } else {
            return throwCards();
        }
    }

    private Integer betByPair(HandLevel level) {
        if (HandLevel.HIGH.equals(level)) {
            return minimalbet + (HandLevel.HIGH.ordinal() + 1) * mediumMultiplier;
        }
        int limit = (level.ordinal() + 1) * 15;
        return holdUntilLimit(limit);

    }

    private Integer betByHighCard(HandLevel level) {
        int limit = (level.ordinal() + 1) * 10;
        return holdUntilLimit(limit);
    }

    private Integer limitWhenLimitNull(Integer limit) {
        if (limit == null) {
            if (stack > holdLimit) {
                return minimalbet;
            } else {
                return throwCards();
            }
        }
        return limit;
    }

}
