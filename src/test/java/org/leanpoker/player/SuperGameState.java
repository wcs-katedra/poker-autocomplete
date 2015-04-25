/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wcs.poker.gamestate.GameState;
import java.util.List;

/**
 *
 * @author boss
 */
public class SuperGameState {

    
    @Expose
    private String type;
    
    @Expose
    private String message;
    @SerializedName("game_state")
    @Expose
    private GameState gamestate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(GameState gamestate) {
        this.gamestate = gamestate;
    }

}
