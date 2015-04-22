/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import com.sun.management.GarbageCollectionNotificationInfo;
import com.wcs.poker.gamestate.GameState;

/**
 *
 * @author gergo
 */
public class AGameStateValue {

    protected GameState gs;

    public AGameStateValue(GameState gs) {
        this.gs = gs;
    }

}
