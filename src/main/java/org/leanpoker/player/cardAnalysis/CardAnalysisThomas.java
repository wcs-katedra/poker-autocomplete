/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.cardAnalysis;

import org.leanpoker.player.cardAnalysis.enums.CardsValue;
import com.wcs.poker.gamestate.Card;
import java.util.ArrayList;
import java.util.List;
import org.leanpoker.player.cardAnalysis.enums.CardClass;
import org.leanpoker.player.cardAnalysis.propertys.Pair;
import org.leanpoker.player.cardAnalysis.propertys.Property;

/**
 *
 * @author boss ;)
 */
public class CardAnalysisThomas {

    private List<Property> propertys = new ArrayList<>();

    public CardAnalysisThomas() {

        // vizsgálati szabály hozzáadása
        // fontos hogy a többit ez elé szúrlyuk be (lásd List.add manual)
        propertys.add(new Pair());

    }

    /**
     *
     * @return a paraméterül kapott kártyák értéke
     */
    public CardsValue evaluate(List<Card> cards) {
        // Todo geri :)  
        CardsValue returnValue = null;

        // a tesztelés miatt kerül külön függvénybe
        switch (classify(cards)) {
            case royal_flush:
            case straight_flush:
            case four_of_a_kind:
            case full_house:
            case flush:
            case straight:
            case three_of_a_kind:
            case two_pairs:
            case pair:
            case high_card:
                returnValue = CardsValue.LOW;

        }

        return returnValue;
    }

    /**
     * a paraméterben megkapott kártyákat osztályozza
     *
     * @param cards -- a látható kártyák
     * @return a kapott kártyák legmagasabb osztálya
     */
    public CardClass classify(List<Card> cards) {
        // TODO a kártyákat Rank szerint rendezni !!!

        CardClass highestCardClass = CardClass.high_card;

        for (Property property : propertys) {
            if (property.isValid(cards)) {
                highestCardClass = property.currentClass();
            }
        }

        return highestCardClass;
    }

}
