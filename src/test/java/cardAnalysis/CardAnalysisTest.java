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
