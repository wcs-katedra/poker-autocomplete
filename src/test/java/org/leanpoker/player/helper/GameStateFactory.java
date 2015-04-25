package org.leanpoker.player.helper;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class that create GameStates. It can generate a number of gamestates whith
 * the int constructor or with the GameTrun constructor can make a gamestates
 * until the Gameturn is reached
 *
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
    private static Iterator<Card> fixedCards;

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
     * create gamestates until the state. example state = turn then create
     * pre-flop,flop,turn..
     *
     * @param turn
     */
    public GameStateFactory(GameTurn turn) {
        createGamesStatesToTrun(turn);
        doneCreatingGameStates();
    }

    private void createGamesStatesToTrun(GameTurn turn) {
        for (int i = 0; i <= turn.getVal(); i++) {
            createGameState(GameTurn.getTrun(i));
        }
    }

    /**
     * Calls the right constructor by the given turn
     *
     * @param gameStateToCreate
     */
    private void createGameState(GameTurn gameStateToCreate) {
        switch (gameStateToCreate) {
            case PRE_FLOP:
                createPreFlopGameState();
                break;
            case FLOP:
                GameState preFlopGs = gameStates.get(0);
                createFlopGameState(preFlopGs);
                break;
            case TURN:
                GameState flopGs = gameStates.get(1);
                createTurnGameState(flopGs);
                break;
            case RIVER:
                GameState turnGs = gameStates.get(2);
                createRiverGameState(turnGs);
                break;
        }
    }

    private void createPreFlopGameState() {
        GameState gs = new GameState();
        gs = initPreFlopGameState(gs);
        gs = setThePlayer(gs);
        gameStates.add(gs);
    }

    /**
     * copy the template gamestate values to a new gamesate.
     *
     * @param template which gamestate will be the copyed
     * @return a new gamestate filled with the template parameters
     */
    private GameState copyToNewGameState(GameState template) {
        GameState gs = new GameState();

        gs.setSmallBlind(template.getSmallBlind());
        gs.setMinimumRaise(template.getMinimumRaise());
        gs.setPot(template.getPot());
        gs.setCurrentBuyIn(template.getCurrentBuyIn());
        gs.setPlayers(template.getPlayers());
        gs.setInAction(template.getInAction());
        gs.setOrbits(template.getOrbits() + 1);
        gs.setDealer(template.getDealer());

        return gs;
    }

    private void createFlopGameState(GameState preFlopGs) {
        List<Card> cards = new ArrayList<Card>();
        cards.add(getCard());
        cards.add(getCard());
        cards.add(getCard());

        GameState gs = copyToNewGameState(preFlopGs);
        gs.setCommunityCards(cards);
        gameStates.add(gs);
    }

    private void createTurnGameState(GameState flopGs) {
        List<Card> cards = new ArrayList<Card>();
        cards.addAll(flopGs.getCommunityCards());
        cards.add(getCard());

        GameState gs = copyToNewGameState(flopGs);
        gs.setCommunityCards(cards);
        gameStates.add(gs);
    }

    private void createRiverGameState(GameState turnGs) {
        List<Card> cards = new ArrayList<>();
        cards.addAll(turnGs.getCommunityCards());
        cards.add(getCard());

        GameState gs = copyToNewGameState(turnGs);
        gs.setCommunityCards(cards);
        gameStates.add(gs);
    }

    private Card getCard() {
        boolean hasNext = GameStateFactory.fixedCards.hasNext();
        if (!hasNext) {
            return rc.getRandomCard();
        }
        return GameStateFactory.fixedCards.next();

    }

    /**
     * Init the gamestate with the values of the GameStateDefaultValues class.
     *
     * @param gs the gamestate what to init
     * @return the inicialized gamestate
     */
    private GameState initPreFlopGameState(GameState gs) {
        gs.setSmallBlind(GameStateDefaultValues.getSmallBlind());
        gs.setCurrentBuyIn(GameStateDefaultValues.getCurrentBuyIn());
        gs.setPot(GameStateDefaultValues.getPot());
        gs.setMinimumRaise(GameStateDefaultValues.getMinimumRaise());
        gs.setDealer(1);
        gs.setOrbits(1);
        gs.setInAction(0);

        return gs;
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
     * Init the gamestate with default values.
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
     * @param gs the gamestate what needs a player
     * @return the gamestate with the player
     */
    private GameState setThePlayer(GameState gs) {
        Card testCard1 = new Card();
        Card testCard2 = new Card();
        if (GameStateFactory.fixedCards.hasNext()) {
            testCard1 = fixedCards.next();
            if (GameStateFactory.fixedCards.hasNext()) {
                testCard2 = fixedCards.next();
            } else {
                testCard2 = card2;
            }            
        } else {
            testCard1 = card1;
        }
        gs.setPlayer(1590, 80, testCard1, testCard2);

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

    public boolean hasMoreGameState() {
        return iterator.hasNext();
    }

    public static void setFixedCards(Iterator<Card> fixedCards) {
        GameStateFactory.fixedCards = fixedCards;
    }
}
