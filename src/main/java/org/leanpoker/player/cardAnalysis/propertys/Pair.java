/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.cardAnalysis.propertys;

import com.wcs.poker.gamestate.Card;
import java.util.Iterator;
import java.util.List;
import org.leanpoker.player.cardAnalysis.enums.CardClass;

/**
 *ez az osztály reprezentálja a bármilyen pár létezését. 
 * @author boss
 */
public class Pair implements Property {

    /**
     * meghatározza hogy a paraméterben megadott rank szerint rendezett listában
     * van e pár
     *
     * @param cards -- rank szerint rendezett lista a számunkra látható
     * kártyákról
     * @return van pár ?
     */
    @Override
    public boolean isValid(List<Card> cards) {

        // mégig kell menni a listán erre a leg megfelelőbb választás az iterátor
        Iterator iterator = cards.iterator();

        // azért a jelenlegi kártya megy ide hogy egy kört megspóroljunk :)
        Card current = (Card) iterator.next();
        Card last;
        // az iterátor végigmegy a listán 
        while (iterator.hasNext()) {
            // amikor újabb elemet kel figyelembe venni akkor léptetünk egyet
            last = current;
            current = (Card) iterator.next();

            // ha a két elem rankja egyenlő akkor van 1 párunk
            if (last.getRank().equals(current.getRank())) {
                return true;
            }
        }

        return false;
    }

    /**
     * megadja a kártyát vizsgált osztályát 
     * @return 
     */
    @Override
    public CardClass currentClass() {
        return CardClass.pair;
    }

}
