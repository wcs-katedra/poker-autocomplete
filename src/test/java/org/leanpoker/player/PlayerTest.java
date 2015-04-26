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

import org.leanpoker.player.helper.GameStateFactory;
import org.leanpoker.player.helper.SuperGameState;
import org.leanpoker.player.helper.GameTurn;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.enums.Rank;
import com.wcs.poker.gamestate.enums.Suit;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;
import com.wcs.poker.jsonconverter.JsonConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
        assertTrue(true);
    }

    @Test
    public void testBetRequestWithJSONFile() throws IOException {
        // arrange
        List<SuperGameState> gstates = readGameStatesFromLogFile();
        Player player = new Player();
        int inAction = 0;
        int dealer;

        // act
        for (SuperGameState gstate : gstates) {
            dealer = gstate.getGamestate().getDealer();
            int index = dealer + inAction;
            if (index < 8) {
                gstate.getGamestate().setInAction(index);
            } else {
                index = index % 8;
                gstate.getGamestate().setInAction(index);
            }
            inAction++;
            if (isValidSuperGameState(gstate)) {
                System.out.println(gstate);
                doBetTest(gstate.getGamestate(), player);
            }

        }

        // assert
        assertTrue(true);
    }

    private static boolean isValidSuperGameState(SuperGameState gstate) {
        boolean retVal = true;
        retVal &= gstate != null;
        if (!retVal) {
            return false;
        }
        retVal &= gstate.getMessage() != null;
        if (!retVal) {
            return false;
        }
        retVal &= gstate.getMessage().contains("Autocomplete");
        return retVal;
    }

    /**
     * Test of betRequest method, of class Player.
     */
    @Ignore
    @Test
    public void testBetRequestWithFixedCards() throws IOException {
        // arrange
        List<Card> playWith = getRank(HandRank.STRAIGHT);
        GameStateFactory.setFixedCards(playWith.iterator());
        GameStateFactory gsf = new GameStateFactory(GameTurn.RIVER);
        Player player = new Player();

        simulateTurnament(gsf, player);

        // assert
        assertTrue(true);
    }

    @Ignore
    @Test
    public void testBetRequestWithFixedCardsFromFile() throws IOException {
        // arrange
        List<Card> playWith = getRank(HandRank.STRAIGHT);
        GameStateFactory.setFixedCards(playWith.iterator());
        GameStateFactory gsf = new GameStateFactory(GameTurn.RIVER);
        Player player = new Player();

        simulateTurnament(gsf, player);

        // assert
        assertTrue(true);
    }

    @Ignore
    @Test
    public void testBetRequestWithTheseCards() {
        List<Card> cards = new ArrayList<>();
        Card card = new Card();
        card.setSuit(Suit.CLUBS);
        card.setRank(Rank.J);
        Card card2 = new Card();
        card2.setSuit(Suit.CLUBS);
        card2.setRank(Rank.Q);

        cards.add(card);
        cards.add(card2);

        testWithRandomGameStates(cards);
    }

    public void testWithRandomGameStates(List<Card> cards) {
        // arrange
        GameStateFactory.setFixedCards(cards.iterator());
        GameStateFactory gsf = new GameStateFactory(GameTurn.PRE_FLOP);
        Player player = new Player();

        simulateTurnament(gsf, player);

        // assert
        assertTrue(true);
    }

    private void simulateTurnament(GameStateFactory gsf, Player player) {
        GameState gs;
        // act
        while (gsf.hasMoreGameState()) {
            gs = gsf.getNextGameState();
            doBetTest(gs, player);
        }
    }

    private void doBetTest(GameState gs, Player player) {
        int bet;
        Hand result;
        System.out.print("starting -> ");
        List<Card> cardsInTheGame = gs.cardsInTheGame();
        System.out.print("\n\tcards in the current gameState : " + cardsInTheGame);
        bet = player.betRequest(gs);
        System.out.print("\n\tthe bet is :  " + bet);
        result = player.cardAnalysis(cardsInTheGame);
        System.out.print("\n\tthe evald cards is:  " + result.getRank() + "\t" + result.getLevel() + "\n");
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

    private List<SuperGameState> readGameStatesFromLogFile() throws MalformedURLException, IOException {
        BufferedReader bufferedReader = downloadFrom();
        JsonConverter<SuperGameState[]> jsonConverter = new JsonConverter<>(SuperGameState[].class);
        List<SuperGameState> gamestates = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            readSingleLine(jsonConverter, line, gamestates);
        }

        return gamestates;
    }

    private void readSingleLine(JsonConverter<SuperGameState[]> jsonConverter, String line, List<SuperGameState> gamestates) {
        SuperGameState[] superGameStates = jsonConverter.fromJson(line);
        gamestates.addAll(Arrays.asList(superGameStates));
    }

    private BufferedReader downloadFrom() throws MalformedURLException, IOException {
        URL url = new URL("http://poker.webstar.hu/json?log=log/game_2015_04_26_09_40_12");
        InputStream openStream = url.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openStream));
        return bufferedReader;
    }

}
