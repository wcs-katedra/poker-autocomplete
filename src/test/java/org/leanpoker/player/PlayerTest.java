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

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.jsonconverter.JsonConverter;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author boss
 */
public class PlayerTest {

    private final String simple = "testSimple.txt";
    private final String advanced = "testSimple.txt";
    private final String testFile = simple;

    private InputStream ins = null;
    private GameState testGameState = null;

    /**
     * runs before calling the any test procedure. reads the 'testFile' -s
     * content to the testGameState variable. exeptions handeled here.
     */
    @Before
    public void setUp() {
        init();
    }

    /**
     * read the file given in the testFile field
     */
    private void init() {
        // read into the variable 
        String gameStateText = "";
        try {
            gameStateText = IOUtils.toString(this.getClass().getResourceAsStream(testFile));

        } catch (IOException ex) {
            Logger.getLogger(PlayerTest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Cannot open the given file!!:\n\t" + testFile);
        }

        // create a game state of it ...
        testGameState = new JsonConverter<>(GameState.class).fromJson(gameStateText);
    }

    /**
     * Test of betRequest method, of class Player.
     */
    @Test
    public void testBetRequest() {
        // arrange
        Integer bet;
        Player player = new Player();

        // act
        bet = player.betRequest(testGameState);

        // assert
        assertTrue(0 == bet);
    }

}
