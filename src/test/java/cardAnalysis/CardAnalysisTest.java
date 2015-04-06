/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardAnalysis;

import com.wcs.poker.gamestate.Card;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MártonZoltán
 */
public class CardAnalysisTest {

    private CardAnalysis instance = new CardAnalysis();

    public CardAnalysisTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of evaluateCards method, of class CardAnalysis.
     */
    //@Test
    public void testEvaluateCards() {
        System.out.println("evaluateCards");

        List<Card> cards = new ArrayList<>();

        Card card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "pair";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "high";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);

    }

}
