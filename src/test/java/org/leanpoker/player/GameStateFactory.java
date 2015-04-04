/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author boss
 */
public class GameStateFactory {

    private List<GameState> gameStates = new ArrayList<GameState>();
    private int theNumberOfGameStates;
    private Iterator<GameState> iterator;

    private RandomCard rc = new RandomCard();
    private Card card1 = rc.getRandomCard();
    private Card card2 = rc.getRandomCard();

    /**
     * default
     */
    public GameStateFactory() {

    }

    /**
     * creates the given number of gameStates with default cards and values
     *
     * @param theNumberOfGameStates how many gamestates will be created
     */
    public GameStateFactory(int theNumberOfGameStates) {
        this.theNumberOfGameStates = theNumberOfGameStates;
        createSpecifiedNumberOfGameStates();
        doneCreatingGameStates();
    }

    public void createGameStateByRound(String[] state) {
        modifyGameStateByRound(state);
        doneCreatingGameStates();
    }

    private void modifyGameStateByRound(String[] state) {
        
        List<Card> lastCommonCards = null;
        for (String currentState : state) {
            GameState gs = createGameState();
            switch (currentState) {
                case "pre-flop":
                    break;
                case "flop":
                    // add 3 cards
                    gs.setCommunityCards(lastCommonCards);
                    gs.addCard(rc.getRandomCard());
                    gs.addCard(rc.getRandomCard());
                    gs.addCard(rc.getRandomCard());
                    break;
                case "turn":
                    // add the 4. card
                    gs.setCommunityCards(lastCommonCards);
                    gs.addCard(rc.getRandomCard());
                    break;
                case "river":
                    // add the 5. card
                    gs.setCommunityCards(lastCommonCards);
                    gs.addCard(rc.getRandomCard());
                    break;
            }
            gameStates.add(gs);
            lastCommonCards = gs.getCommunityCards();
        }
    }

    private void createSpecifiedNumberOfGameStates() {
        GameState gs;
        for (int i = 0; i < theNumberOfGameStates; i++) {
            gs = createGameState();
            gameStates.add(gs);
        }
    }

    private GameState createGameState() {
        GameState gs = new GameState();
        gs = setTheStartingValues(gs);
        gs = setThePlayer(gs);
        return gs;
    }

    private GameState setTheStartingValues(GameState gs) {
        gs.setSmallBlind(10);
        gs.setCurrentBuyIn(320);
        gs.setPot(100 * gameStates.size());
        gs.setMinimumRaise(240);
        gs.setDealer(1);
        gs.setOrbits(gameStates.size());
        gs.setInAction(0);

        return gs;
    }

    private GameState setThePlayer(GameState gs) {
        int stack = 1590;
        int bet = 80;
        gs.setPlayer(stack, bet, card1, card2);

        return gs;
    }

    private void doneCreatingGameStates() {
        iterator = gameStates.iterator();
    }

    public List<GameState> getGameStates() {
        return gameStates;
    }

    public GameState getNextGameState() {
        return iterator.next();
    }

    public GameState getFirstGameState() {
        return gameStates.get(0);
    }

}
