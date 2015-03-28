/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author gergo
 */
public class DetermineBet implements evaluate{

    private int bigBlind;
    private int minimumRaise;
    private int currentBuyIn;
    private int pot;
    private int stack;

    public DetermineBet(int bigBlind, int minimumRaise, int currentBuyIn, int pot, int stack) {
        this.bigBlind = bigBlind;
        this.minimumRaise = minimumRaise;
        this.currentBuyIn = currentBuyIn;
        this.pot = pot;
        this.stack = stack;
    }

    @Override
    public Integer getBet(String combo, String level) {
        return 0;
    }
    
    
    
    
}
