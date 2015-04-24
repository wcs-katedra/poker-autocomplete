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

    public CalculateOnPreflop(GameState gs, Hand hand) {
        super(gs, hand);
    }

    @Override
    public Integer getBet() {
        if (HandRank.PAIR.equals(hand.getRank())) {
            return betByPair(hand.getLevel());
        } else if (HandRank.HIGH_CARD.equals(hand.getLevel())) {
            return betByHighCard(hand.getLevel());
        } else { // we got nothing
            return minimalbet;
        }

    }

    private Integer betByPair(HandLevel level) {
        return minimalbet + level.ordinal()*2;
    }

    private Integer betByHighCard(HandLevel level) {
        return minimalbet + level.ordinal();
    }

}
