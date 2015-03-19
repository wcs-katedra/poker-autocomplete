/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.cardAnalysis.propertys;

import com.wcs.poker.gamestate.Card;
import java.util.List;
import org.leanpoker.player.cardAnalysis.enums.CardClass;

/**
 * erre az interface-re azért van szükség hogy a megfogalmazott kritériumok egy
 * listába kerülhessenek
 *
 * @author boss
 */
public interface Property {

    boolean isValid(List<Card> cards);
    CardClass currentClass();

}
