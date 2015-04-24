/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;


/**
 *
 * @author boss
 */
enum GameTurn {

    ERROR(-1,"hiba"),
    PRE_FLOP(0,"pre-flop"),
    FLOP(1,"flop"),
    TURN(2,"turn"),
    RIVER(3,"river");

    private int val;
    private String nev;

    private GameTurn(int val,String nev) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public static GameTurn getTrun(int i) {
        GameTurn returnVal;
        switch (i) {
            case 0:
                returnVal = PRE_FLOP;
                break;
            case 1:
                returnVal = FLOP;
                break;
            case 2:
                returnVal = TURN;
                break;
            case 3:
                returnVal = RIVER;
                break;
            default:
                returnVal = ERROR;
        }
        return returnVal;
    }

      
}
