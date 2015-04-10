/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import com.wcs.poker.gamestate.Card;

/**
 *
 * @author gergo
 */
public class DetermineBet implements evaluate {

    private int bigBlind;
    private int minimumRaise;
    private int currentBuyIn;
    private int pot;
    private int stack;
    private int turns;
    private int orbits;

    public DetermineBet(int bigBlind, int minimumRaise, int currentBuyIn, int pot, int stack, int rounds, int orbits) {
        this.bigBlind = bigBlind;
        this.minimumRaise = minimumRaise;
        this.currentBuyIn = currentBuyIn;
        this.pot = pot;
        this.stack = stack;
        this.turns = rounds;
        this.orbits = orbits;
    }

    public DetermineBet(int bigBlind, int minimumRaise, int currentBuyIn, int pot, int stack) {
        this.bigBlind = bigBlind;
        this.minimumRaise = minimumRaise;
        this.currentBuyIn = currentBuyIn;
        this.pot = pot;
        this.stack = stack;
    }

    /**
     * @param combo
     * @param level
     * @return bet
     */
    //Versenytaktikák használata, a cashgame strarégiák itt nem nagyon játszanak
    @Override
    public Integer getBet(String combo, String level) {
        int currentTurn = turns;
        Integer bet = 0;

        String pokerHand = combo + "," + level;

        //Számok alkalmazása nem ajánlott mivel a vakok értéke változik
        //A játék elejét jelenti ha az orbits kisebb mint 3
        if (orbits < 3) {
            //preflop
            if (currentTurn == 0) {
                switch (pokerHand) {
                    // Ha emelnek a preflopnál akkor dobjuk a gyenge lapokat
                    case "none,low":
                        bet = currentBuyIn == 0 ? bigBlind : 0;
                        break;
                    // Ha emelnek a preflopnál akkor dobjuk a közepes lapokat, ha az emelés több mint 2BB
                    case "none,medium":
                        bet = currentBuyIn >= bigBlind + bigBlind * 1 ? bigBlind + bigBlind * 1 : 0;
                        break;
                    //Jó magaslapokra tartjuk, vagy emelünk 2BB+BB-t
                    case "none,high":
                        if (currentBuyIn == 0) {
                            bet = bigBlind + bigBlind * 2;
                        } else if (currentBuyIn > bigBlind * 2) {
                            bet = 0;
                        } else {
                            bet = bigBlind + bigBlind * 2;
                        }

                        break;

                    //limperek kiszórása emelés 4bb-8bb-vel, afölött valószínű jó lapja van
                    case "pair,low":
                        bet = bigBlind + bigBlind * 4;
                        break;
                    case "pair,medium":
                        bet = currentBuyIn >= bigBlind * 6 ? bigBlind + bigBlind * 6 : 0;
                        break;
                    case "pair,high":
                        bet = bigBlind + bigBlind * 8;
                        break;

                }
                //flop
                if (currentTurn == 1) {

                    switch (pokerHand) {

                        case "none,low":
                            bet = currentBuyIn == 0 ? bigBlind : 0;
                            break;

                        case "none,medium":
                            bet = bigBlind;
                            break;
                        case "none,high":
                            bet = bigBlind;
                            break;

                        case "pair,low":
                            bet = bigBlind + 100;
                            break;
                        case "pair,medium":
                            bet = bigBlind + 100;
                            break;
                        case "pair,high":
                            bet = bigBlind + 150;
                            break;

                        case "2pair,low":
                            bet = bigBlind + 200;
                            break;
                        case "2pair,medium":
                            bet = bigBlind + 200;
                            break;
                        case "2pair,high":
                            bet = bigBlind + 200;
                            break;

                        case "drill,low":
                            bet = bigBlind + 300;
                            break;
                        case "drill,medium":
                            bet = bigBlind + 300;
                            break;
                        case "drill,high":
                            bet = bigBlind + 300;
                            break;

                        case "straight,low":
                            bet = bigBlind + 300;
                            break;
                        case "straight,medium":
                            bet = bigBlind + 300;
                            break;
                        case "straight,high":
                            bet = bigBlind + 300;
                            break;

                        case "full,low":
                            bet = bigBlind + 300;
                            break;
                        case "full,medium":
                            bet = bigBlind + 300;
                            break;
                        case "full,high":
                            bet = bigBlind + 300;
                            break;

                        case "poker,low":
                            bet = bigBlind + 300;
                            break;
                        case "poker,medium":
                            bet = bigBlind + 300;
                            break;
                        case "poker,high":
                            bet = bigBlind + 300;
                            break;

                        case "flush,low":
                            bet = bigBlind + 400;
                            break;
                        case "flsuh,medium":
                            bet = bigBlind + 400;
                            break;
                        case "flush,high":
                            bet = bigBlind + 400;
                            break;

                        case "straight flush,low":
                            bet = bigBlind + 500;
                            break;
                        case "straight flush,medium":
                            bet = bigBlind + 500;
                            break;
                        case "straight flush,high":
                            bet = bigBlind + 500;
                            break;

                        case "royal flush,low":
                            bet = bigBlind + 500;
                            break;
                        case "royal flush,medium":
                            bet = bigBlind + 500;
                            break;
                        case "royal flush":
                            bet = bigBlind + 500;
                            break;
                    }

                    //turn
                    if (currentTurn == 2) {

                    }//river
                    if (currentTurn == 3) {

                    }
                }
            }

        }

        /**
         * -----------------------------------------------------------------------------
         * Eddig tart a verseny első- és közép szakasza 3-szor ért körbe a
         * dealer korong. Tehát a körök száma = csapatok * az orbits-al. 6*3=18
         */
        if (orbits > 3) //A verseny közepe-vége felé megadjuk az all-in-t a preflopnál, a flop kiszorítás ellen
        {
            //preflop
            if (currentTurn == 0) {
                switch (pokerHand) {
                    // Ha emelnek a preflopnál akkor dobjuk a gyenge lapokat
                    case "none,low":
                        bet = currentBuyIn == 0 ? bigBlind : 0;
                        break;
                    // Ha emelnek a preflopnál akkor dobjuk a közepes lapokat, ha az emelés több mint 2BB
                    case "none,medium":
                        bet = currentBuyIn >= bigBlind + bigBlind * 1 ? bigBlind + bigBlind * 1 : 0;
                        break;
                    //Jó magaslapokra tartjuk, vagy emelünk 2BB+BB-t
                    case "none,high":
                        bet = stack / 2; // Blöffölés, de 38.8%, hogy lesz belőle 2 pár, drill: 15.3%
                        break;

                    //limperek kiszórása emelés 4bb-8bb-vel, afölött valószínű jó lapja van
                    case "pair,low":
                        bet = bigBlind + bigBlind * 4;
                        break;
                    case "pair,medium":
                        bet = currentBuyIn >= bigBlind * 6 ? bigBlind + bigBlind * 6 : 0;
                        break;
                    case "pair,high":
                        bet = stack;
                        break;
                }

            }
            
        }
        return bet;
    }
}
