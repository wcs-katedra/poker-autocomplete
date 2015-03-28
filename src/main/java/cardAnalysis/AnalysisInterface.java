/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardAnalysis;

import com.wcs.poker.gamestate.Card;
import java.util.List;

/**
 *
 * @author MártonZoltán
 */
public interface AnalysisInterface {
    
    //kapom a kártyákat
    void evaluateCards(List<Card> cards);
    
    //megkapod az eredményt (none,pair,drill,full,poker,2pair,straight,straight flush(itt nincs level meg :())
    String getCombo();
    //high,low,medium,none
    String getLevel();
    
}
