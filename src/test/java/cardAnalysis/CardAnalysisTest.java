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
    @Test
    public void testEvaluateCards() {
        System.out.println("evaluateCards");
        
        List<Card> cards = new ArrayList<>();
        
        Card card = new Card();
        
        card.setRank("K");
        card.setSuit("heart");
        
        cards.add(card);
        
        card= new Card();
        card.setRank("K");
        card.setSuit("heart");
        
        cards.add(card);
        
        CardAnalysis instance = new CardAnalysis();
        instance.evaluateCards(cards);
       
        
    }

    /**
     * Test of getCombo method, of class CardAnalysis.
     */
    @Test
    public void testGetCombo() {
        System.out.println("getCombo");
        CardAnalysis instance = new CardAnalysis();
        String expResult = "pair";
        String result = instance.getCombo();
        assertEquals(expResult, result);
        
       
    }

    /**
     * Test of getLevel method, of class CardAnalysis.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        CardAnalysis instance = new CardAnalysis();
        String expResult = "high";
        String result = instance.getLevel();
        assertEquals(expResult, result);
        
       
    }
    
}
