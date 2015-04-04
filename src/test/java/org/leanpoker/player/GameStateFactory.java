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

    /**
     * create on full turnament round by the given turnament points. it is good
     * for testing.
     *
     * @param state the turnament states the needs to be tested
     */
    public void createGameStateByRound(String[] state) {
        GameState templateGameState = createGameState();
        modifyGameStateByRound(state, templateGameState);
        doneCreatingGameStates();
    }

    /**
     * 
     * @param state how many turnament round should be generated ?
     * @param gs template gamestate
     */
    private void modifyGameStateByRound(String[] state, GameState gs) {
        List<Card> lastCommonCards = null;
        for (String currentState : state) {
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

    /**
     * create a number of gamestates given in the field and adds them to the
     * gamestate list.
     */
    private void createSpecifiedNumberOfGameStates() {
        GameState gs;
        for (int i = 0; i < theNumberOfGameStates; i++) {
            gs = createGameState();
            gameStates.add(gs);
        }
    }

    /**
     * Create a default gamestate. Create new gamestate instace and sets the
     * fields.
     *
     * @return a new gamestate.
     */
    private GameState createGameState() {
        GameState gs = new GameState();
        gs = setTheStartingValues(gs);
        gs = setThePlayer(gs);
        return gs;
    }

    /**
     * Init the "table". loads a gamestate fields
     *
     * @param gs
     * @return
     */
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

    /**
     * Adds a player to the given gamestate. the two cards will be the same
     * every time. cause we get it in the first "round" and after there is no
     * change in it
     *
     * @param gs
     * @return
     */
    private GameState setThePlayer(GameState gs) {
        // stack,bet, c1,c2
        gs.setPlayer(1590, 80, card1, card2);

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
