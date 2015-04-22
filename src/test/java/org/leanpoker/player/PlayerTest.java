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

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.jsonconverter.JsonConverter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testBetRequestWithMultipleGamestateFiles() {

    }

    /**
     * Test of betRequest method, of class Player.
     */
    @Test
    public void testBetRequestWithRandomGameStates() {
        // arrange
        int bet;
        int state = 0;
        GameStateFactory gsf = new GameStateFactory(GameTurn.RIVER);
        GameState gs;
        HandRank result;
        Player player = new Player();

        // act
        while (gsf.hasMoreGameState()) {
            gs = gsf.getNextGameState();
            System.out.print("starting -> " + GameTurn.getTrun(state++));
            List<Card> cardsInTheGame = gs.cardsInTheGame();
            System.out.print("\n\tcards in the current gameState : " + cardsInTheGame);
            bet = player.betRequest(gs);
            System.out.print("\n\tthe bet is :  " + bet);
            result = player.cardAnalysis(cardsInTheGame);
            System.out.print("\n\tthe evald cards is:  " + result + "\n");
        }
    }

        // assert
}
