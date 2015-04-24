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
        if (hand.getRank() == HandRank.HIGH_CARD) {
            return highCardBet();
        } else {
            return pairBet();
        }
    }

    @Override
    protected Integer highCardBet() {
        if (currentBuyIn == bigBlind) {
            return bigBlind;
        } else if (currentBuyIn == getDoubleBigBlind()) {
            return getTripleBigBlind();
        } else {
            return holdCards();
        }
    }

    //limperek kiszórása emelés 4bb-8bb-vel, afölött valószínű jó lapja van

    @Override
    protected Integer pairBet() {
        if (currentBuyIn <= getTripleBigBlind()) {
            return getAmountOfBigBlind(8);
        } else {
            return holdCards();
        }
    }

}
