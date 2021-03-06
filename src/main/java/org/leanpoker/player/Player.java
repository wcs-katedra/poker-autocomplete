package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;
import com.wcs.poker.hand.work.HandRankingService;
import java.util.List;
import strategy.CalculateOnFlop;
import strategy.CalculateOnPreflop;
import strategy.CalculateOnRiver;
import strategy.CalculateOnTurn;

public class Player {

    public final String VERSION = "bad run of the cards!";

    public Player() {
    }

    /**
     *
     * @param gameState
     * @return 0 -- ha bedobod ALL> -- aktuális tét ALL -- minden benn
     */
    public int betRequest(GameState gameState) {
        List<Card> cards = gameState.cardsInTheGame();
        Hand hr = cardAnalysis(cards);
        int finalBet = determineByNumberOfCards(cards.size(), gameState, hr);
        return finalBet;
    }

    /**
     * evaluets the cards in the current gamestate and returns the best of them
     *
     * @param cards
     * @return
     */
    public Hand cardAnalysis(List<Card> cards) {
        HandRankingService hrs = new HandRankingService();
        Hand evaledCards = hrs.evaulate(cards);
        return evaledCards;
    }

    public void showdown(GameState gameState) {
    }

    private int determineByNumberOfCards(int size, GameState gs, Hand hand) {
        if (size == 2) {
            return new CalculateOnPreflop(gs, hand).getBet();
        }
        if (size == 5) {
            return new CalculateOnFlop(gs, hand).getBet();
        }
        if (size == 6) {
            return new CalculateOnTurn(gs, hand).getBet();
        }
        if (size == 7) {
            return new CalculateOnRiver(gs, hand).getBet();
        }
        return 0;

    }

    private HandRank rankol(String combo) {
        if ("pair".equals(combo)) {
            return HandRank.PAIR;
        }

        return HandRank.HIGH_CARD;
    }
}
