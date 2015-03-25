package org.leanpoker.player;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.gamestate.GameState;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testgetNumberOfCardInTheGame() throws Exception {
        GameState gs = new GameState();
        
        List<Card> cards = new ArrayList();
        Card card = new Card();
        
        cards.add(card);
        cards.add(card);
        cards.add(card);
        
        gs.setCommunityCards(cards);
        
        Player player = new Player();
        assertEquals(new Integer(3), gs.getNumberOfCardInTheGame());

    }

}
