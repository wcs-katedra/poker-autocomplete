/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.cardAnalysis;

import com.wcs.poker.gamestate.Card;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.leanpoker.player.cardAnalysis.enums.CardClass;

/**
 *
 * @author boss
 */
public class CardAnalysisThomasTest {
    
    public CardAnalysisThomasTest() {
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
     * Test of evaluate method, of class CardAnalysisThomas.
     */
    @Test
    public void testRecognizeKingPair() {
        System.out.println("evaluate K = K ?");
        List<Card> cards = new ArrayList<>();
        
        Card king =  new Card();
        king.setRank("K");        
        cards.add(king);
        cards.add(king);
        
        CardAnalysisThomas analysis = new CardAnalysisThomas();
        CardClass expResult = CardClass.pair;
        CardClass result = analysis.classify(cards);
        assertEquals(expResult, result);
    }
    
}
