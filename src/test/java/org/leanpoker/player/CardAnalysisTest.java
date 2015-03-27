/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import cardAnalysis.CardAnalysis;
import cardAnalysis.RankCount;
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
 * @author boss
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
     * Ez a teszt azt teszteli hogy két egyforma "Rank"(Jumbo) megadása esetén a
     * CardAnalísis osztály párként ismeri e fel.
     */
    @Test
    public void testTheTwoJumboIsPair() {
        /* kásőbb még hasznos lehet
         Card lap1 = new Card();
         Card lap2 = new Card();
        
         lap1.setRank("k");
         lap2.setRank("k");
        
         lap1.setSuit("spade");
         lap2.setSuit("heart");
         */

        // init for the test
        //  létrehozzuk az osztályt ami a kártyákat értékeli ki
        CardAnalysis analysis = new CardAnalysis();
        
        // segéd rank count az objektumok hozzáadása miatt
        RankCount rc = new RankCount();
        // a lista elő készítése
        List<RankCount> rankCount = new ArrayList();

        // a két jumbó hozzáadása..
        rc.setRank("j");
        rc.setCount(2);
        rankCount.add(rc);
        
        rc = new RankCount();
        rc.setRank("k");
        rc.setCount(3);
        rankCount.add(rc);
   
        
     

        // tényleges teszt
        assertEquals("full", analysis.analysisRankList(rankCount));

    }

}
