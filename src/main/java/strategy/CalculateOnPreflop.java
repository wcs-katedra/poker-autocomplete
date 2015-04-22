package strategy;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;

/**
 * Here we determine the bet for the preflop gamestate. Fields are in the DetermineBet class. 
 * Taut Aggressive TAG - Feszes agresszív játék Loose
 * Aggressive LAG - Laza agresszív játék
 *
 * @author gergo
 */
public class CalculateOnPreflop extends DetermineBet implements Evaluate {

    public CalculateOnPreflop(GameState gs, HandRank handRank) {
        super(gs, handRank);
    }

    @Override
    public Integer getBet() {
        if (handRank == HandRank.HIGH_CARD) {
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
            return throwCards();
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
