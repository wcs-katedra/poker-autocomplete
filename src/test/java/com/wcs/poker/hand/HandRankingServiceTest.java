package com.wcs.poker.hand;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wcs.poker.gamestate.Card;
import com.wcs.poker.hand.enums.HandRank;
import com.wcs.poker.hand.work.Hand;
import com.wcs.poker.hand.work.HandRankingService;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertThat;

/**
 *
 * @author thomas
 */
public class HandRankingServiceTest {

    private HandRankingService handRankingService;

    @Before
    public void setUp() {
        handRankingService = new HandRankingService();
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testNotLessThenFiveCardsAreAccepted() {
        handRankingService.evaulate(Collections.nCopies(4, (Card) null));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testNotMoreThenSevenCardsAreAccepted() {
        handRankingService.evaulate(Collections.nCopies(8, (Card) null));
    }

    @Test
    public void testEvaulateRoyalFlushHand() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("royalFlushHandTestDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.ROYAL_FLUSH));
        //assertThat(hand.getCards(), Is.is((Collection) loadCards("royalFlushHand.json")));
    }

    @Test
    public void testEvaulateStraightFlush() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("straightFlushHandTestDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.STRAIGHT_FLUSH));
        //assertThat(hand.getCards(), Is.is((Collection) loadCards("straightFlush.json")));
    }

    @Test
    public void testEvaulateFourOfAKind() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("fourOfAKindTestDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.FOUR_OF_A_KIND));
        // assertThat(hand.getCards(), Is.is((Collection) loadCards("fourOfAKindHand.json")));
    }

    @Test
    public void testEvaulateFullHouse() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("fullHouseTestDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.FULL_HOUSE));
        //assertThat(hand.getCards(), Is.is((Collection) loadCards("fullHouseHand.json")));
    }

    @Test
    public void testEvaulateFlush() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("flushTestDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.FLUSH));
        // assertThat(hand.getCards(), Is.is((Collection) loadCards("flushHand.json")));
    }

    @Test
    public void testEvaulateStraight() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("straightTestDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.STRAIGHT));
        // assertThat(hand.getCards(), Is.is((Collection) loadCards("straightHand.json")));
    }

    @Test
    public void testEvaulateThreeOfAKind() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("threeOfAKindTestDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.THREE_OF_A_KIND));
        //assertThat(hand.getCards(), Is.is((Collection) loadCards("threeOfAKindHand.json")));
    }

    @Test
    public void testEvaulateTwoPairs() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("twoPairsTestDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.TWO_PAIRS));
        //assertThat(hand.getCards(), Is.is((Collection) loadCards("twoPairsHand.json")));
    }

    @Test
    public void testEvaulatePair() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("pairTestDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.PAIR));
        //assertThat(hand.getCards(), Is.is((Collection) loadCards("pairHand.json")));
    }

    @Test
    public void testTest() throws Exception {
        assertThat(loadCards("royalFlushHand.json"), Is.is((Collection) loadCards("royalFlushHand.json")));
    }

    @Test
    public void testEvaulateHighCard() throws Exception {
        Hand hand = handRankingService.evaulate(loadCards("highCardDataSet.json"));

        assertThat(hand.getRank(), Is.is(HandRank.HIGH_CARD));
        //  assertThat(hand.getCards(), Is.is((Collection) loadCards("highCardHand.json")));
    }

    private List<Card> loadCards(String name) throws IOException {
        InputStream resource = getClass().getResourceAsStream(name);
        String json = IOUtils.toString(resource);

        Type cardListType = new TypeToken<List<Card>>() {
        }.getType();
        return new Gson().fromJson(json, cardListType);
    }
}
