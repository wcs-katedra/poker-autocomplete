package com.wcs.poker.hand.work;



import com.wcs.poker.gamestate.Card;
import com.wcs.poker.hand.enums.HandRank;
import java.util.List;

/**
 *
 * @author thomas
 */
public class HandRankingService {

    
    public Hand evaulate(List<Card> loadCards) {
        FinalResult finalResult = new FinalResult();
        
        finalResult.evaluateCards(loadCards);
        
        HandRank rank = finalResult.getCombo();
        
        Hand hand = new Hand(rank, loadCards);
        
        return hand;
    }
    
}
