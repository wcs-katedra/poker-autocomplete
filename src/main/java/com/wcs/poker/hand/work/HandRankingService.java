package com.wcs.poker.hand.work;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.hand.enums.HandLevel;
import com.wcs.poker.hand.enums.HandRank;
import java.util.List;

/**
 *
 * @author thomas
 */
public class HandRankingService {

    public Hand evaulate(List<Card> loadCards) {
        if (loadCards.size() < 2 || loadCards.size() > 7) {
            throw new IllegalArgumentException();
        }
        FinalResult finalResult = new FinalResult();

        finalResult.evaluateCards(loadCards);

        HandRank rank = finalResult.getCombo();
        HandLevel level = finalResult.getLevel();

        Hand hand;

        hand = new Hand(rank, level, loadCards);

        return hand;
    }

}
