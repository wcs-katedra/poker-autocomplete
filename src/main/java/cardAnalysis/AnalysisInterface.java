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
    
    String evaluateCards(List<Card> cards);
    
}
