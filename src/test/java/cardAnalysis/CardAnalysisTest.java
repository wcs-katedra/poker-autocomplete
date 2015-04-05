/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardAnalysis;

import com.wcs.poker.gamestate.Card;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MártonZoltán
 */
public class CardAnalysisTest {

    private CardAnalysis instance = new CardAnalysis();
    private List<Card> cards = new ArrayList<>();
    private Card card = new Card();

    /**
     * parok testje : low,medium,high
     */
    @Test
    public void testPairLowEvaluateCards() {
        System.out.println("evaluateCards  pair,low");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "pair";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "low";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testPairMediumEvaluateCards() {
        System.out.println("evaluateCards  pair,medium");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "pair";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "medium";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testPairHighEvaluateCards() {
        System.out.println("evaluateCards  pair,high");

        cards = new ArrayList<>();

        card = new Card();
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

    /*
     2 par test : low,medium,high
     */
    @Test
    public void test2PairLowEvaluateCards() {
        System.out.println("evaluateCards  2pair,low");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");
        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "2pair";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "low";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void test2PairMediumEvaluateCards() {
        System.out.println("evaluateCards  2pair,medium");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("6");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("6");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");
        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "2pair";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "medium";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void test2PairHighEvaluateCards() {
        System.out.println("evaluateCards  2pair,high");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("A");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("A");
        card.setSuit("heart");
        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "2pair";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "high";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    /*
     teszt drill low medium high
     */
    @Test
    public void testDrillLowEvaluateCards() {
        System.out.println("evaluateCards  drill,low");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "drill";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "low";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testDrillMediumEvaluateCards() {
        System.out.println("evaluateCards  drill,medium");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "drill";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "medium";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testDrillHighEvaluateCards() {
        System.out.println("evaluateCards  drill,high");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "drill";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "high";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    /*
     teszt straight low,medium,high
     */
    @Test
    public void testStraightLowEvaluateCards() {
        System.out.println("evaluateCards  straight,low");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("4");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("5");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("6");
        card.setSuit("spade");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "straight";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "low";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testStraightmediumEvaluateCards() {
        System.out.println("evaluateCards  straight,medium");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("4");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("5");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("6");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("spade");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "straight";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "medium";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testStraightHighEvaluateCards() {
        System.out.println("evaluateCards  straight,high");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("8");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("9");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("10");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("J");
        card.setSuit("spade");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "straight";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "high";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    /*
     teszt flush low,medium,high
     */
    @Test
    public void testFlushLowEvaluateCards() {
        System.out.println("evaluateCards  flush,low");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("5");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("6");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "flush";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "low";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testFlushmediumEvaluateCards() {
        System.out.println("evaluateCards  flush,medium");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("5");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("6");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "flush";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "medium";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testFlushHighEvaluateCards() {
        System.out.println("evaluateCards  flush,high");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("5");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("6");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("Q");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "flush";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "high";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    /*
     teszt full low,medium,high
     */
    @Test
    public void testFulllowEvaluateCards() {

        System.out.println("evaluateCards  full,medium");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("3");
        card.setSuit("spade");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "full";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "low";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testFullMediumEvaluateCards() {

        System.out.println("evaluateCards  full,medium");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("spade");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "full";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "medium";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testFullHighEvaluateCards() {

        System.out.println("evaluateCards  full,high");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("spade");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "full";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "high";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    /*
     teszt poker low,medium,high
     */
    @Test
    public void testPokerLowEvaluateCards() {
        System.out.println("evaluateCards  poker,low");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("spade");

        cards.add(card);

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("4");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "poker";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "low";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);

    }

    @Test
    public void testPokerMediumEvaluateCards() {
        System.out.println("evaluateCards  poker,medium");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("spade");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("4");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "poker";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "medium";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);

    }

    @Test
    public void testPokerHighEvaluateCards() {
        System.out.println("evaluateCards  poker,high");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("spade");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("4");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "poker";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "high";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);

    }

    /*
     teszt straight flush low,medium,high
     */
    @Test
    public void testStraightFlushLowEvaluateCards() {
        System.out.println("evaluateCards  straight flush,low");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("2");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("4");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("5");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("6");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "straight flush";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "low";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testStraightFlushmediumEvaluateCards() {
        System.out.println("evaluateCards  straight flush,medium");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("3");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("4");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("5");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("6");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "straight flush";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "medium";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    @Test
    public void testStraightFlushHighEvaluateCards() {
        System.out.println("evaluateCards  straight flush,high");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("7");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("8");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("9");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("10");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("J");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "straight flush";
        String result = instance.getCombo();
        System.out.println("Kombo: " + result);
        assertEquals(expResult, result);

        System.out.println("getLevel");

        expResult = "high";
        result = instance.getLevel();
        System.out.println("Szint: " + result);
        assertEquals(expResult, result);
    }

    /*
     royal flush high
     */
    @Test
    public void testRoyalFlushHighEvaluateCards() {
        System.out.println("evaluateCards  royal flush,high");

        cards = new ArrayList<>();

        card = new Card();
        card.setRank("A");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("K");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("Q");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("10");
        card.setSuit("heart");

        cards.add(card);

        card = new Card();
        card.setRank("J");
        card.setSuit("heart");

        cards.add(card);

        instance.evaluateCards(cards);

        System.out.println("getCombo");

        String expResult = "royal flush";
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
