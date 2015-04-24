/*
 * To change this
 @Override
 public int read() throws IOException {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }
 }license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.jsonconverter.JsonConverter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author boss
 */
public class PlayerTest {

    private final String simple = "testSimple.txt";

    private GameState readSingleGameStateFromFile() {
        // read into the variable 
        String gameStateText = "";
        try {
            gameStateText = IOUtils.toString(this.getClass().getResourceAsStream(simple));

        } catch (IOException ex) {
            Logger.getLogger(PlayerTest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Cannot open the given file!!:\n\t" + simple);
        }

        // create a game state of it ...
        return new JsonConverter<>(GameState.class).fromJson(gameStateText);

    }

    @Ignore
    @Test
    public void testBetRequestWithSingleGamestateFile() {
        // arrange
        Integer bet;
        Player player = new Player();
        GameState gs = readSingleGameStateFromFile();

        // act
        bet = player.betRequest(gs);

        // assert
    }

    /**
     * Test of betRequest method, of class Player.
     */
    @Test
    public void testBetRequestWithFixedCards() throws IOException {
        // arrange
        int state = 0;
        List<Card> playWith = getRank(HandRank.ROYAL_FLUSH);
        GameStateFactory.setFixedCards(playWith.iterator());
        GameStateFactory gsf = new GameStateFactory(GameTurn.RIVER);
        Player player = new Player();

        simulateTurnament(gsf, state, player);

        // assert
        assertTrue(true);
    }

    /**
     * Test of betRequest method, of class Player.
     */
    @Test
    public void testBetRequestWithRandomGameStates() {
        // arrange
        int state = 0;
        GameStateFactory gsf = new GameStateFactory(GameTurn.FLOP);
        Player player = new Player();

        simulateTurnament(gsf, state, player);

        // assert
        assertTrue(true);
    }

    private void simulateTurnament(GameStateFactory gsf, int state, Player player) {
        GameState gs;
        int bet;
        HandRank result;
        // act
        while (gsf.hasMoreGameState()) {
            gs = gsf.getNextGameState();
            System.out.print("starting -> " + GameTurn.getTrun(state++));
            List<Card> cardsInTheGame = gs.cardsInTheGame();
            System.out.print("\n\tcards in the current gameState : " + cardsInTheGame);
            bet = player.betRequest(gs);
            System.out.print("\n\tthe bet is :  " + bet);
            result = player.cardAnalysis(cardsInTheGame).getRank();
            System.out.print("\n\tthe evald cards is:  " + result + "\n");
        }
    }

    private List<Card> getRank(HandRank handRank) throws IOException {
        List<Card> retVal = new ArrayList<>();
        switch (handRank) {
            case HIGH_CARD:
                retVal = loadCards("highCardHand.json");
                break;
            case PAIR:
                retVal = loadCards("pairHand.json");
                break;
            case TWO_PAIRS:
                retVal = loadCards("twoPairsHand.json");
                break;
            case THREE_OF_A_KIND:
                retVal = loadCards("threeOfAKindHand.json");
                break;
            case STRAIGHT:
                retVal = loadCards("straightHand.json");
                break;
            case FLUSH:
                retVal = loadCards("flushHand.json");
                break;
            case FULL_HOUSE:
                retVal = loadCards("fullHouseHand.json");
                break;
            case FOUR_OF_A_KIND:
                retVal = loadCards("fourOfAKindHand.json");
                break;
            case STRAIGHT_FLUSH:
                retVal = loadCards("straightFlush.json");
                break;
            case ROYAL_FLUSH:
                retVal = loadCards("royalFlushHand.json");
                break;
        }
        return retVal;
    }

    private List<Card> loadCards(String name) throws IOException {
        InputStream resource = getClass().getResourceAsStream(name);
        String json = IOUtils.toString(resource);

        Type cardListType = new TypeToken<List<Card>>() {
        }.getType();
        return new Gson().fromJson(json, cardListType);
    }

}
