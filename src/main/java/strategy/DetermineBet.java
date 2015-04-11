/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import com.wcs.poker.gamestate.GameState;

/**
 *
 * @author gergo
 */
public class DetermineBet implements evaluate {

    /**
     * A kis vak kétszerese.
     */
    private final int bigBlind;
    /**
     *  A kis vak értéke.
     */
    private final int smallBlind;
    /**
     *  Az az összeg ami a legkisebb emeléshez kell.
     */
    private final int minimumRaise;
    /**
     * A legmagasabb tét értéke, amit meg kell adni.
     */
    private final int currentBuyIn;
    /**
     *  A pénzhalom nagysága az asztalon.
     */
    private final int pot;
    /**
     *  A játékos zsetonjai.
     */
    private final int stack;
    /**
     * Ennyiszer ért körbe az osztókorong.
     */
    private final int orbits;
    /**
     * Az ebben a körben tétnek feltett zsetoinok összege.
     */
    private final int bet;
    /**
     * Call értékének számítása: current_buy_in - players[in_action][bet]
     * TODO írd meg rendesen hogy mi a ** ez :D
     */
    private final int call;
    /**
     *  ez mi ez meg ez :D
     */
    private final int minimalbet;
    /**
     * Az aktuális játékállapotban aktív játékososk száma.
     */
    private final int numberOfActivePlayers;
    /**
     * Az aktuális játékállapotban már bedobott játékososk száma.
     */
    private final int numberOfFoldedPlayers;
    /**
     * Az aktuális játékállapotban a játékon kívüli játékososk száma.
     */
    private final int numberOfOutPlayers;

    public DetermineBet(GameState gameState) {
        
        bigBlind = gameState.getBigBlind();
        smallBlind = gameState.getSmallBlind();
        minimumRaise = gameState.getMinimumRaise();
        currentBuyIn = gameState.getCurrentBuyIn();
        pot = gameState.getPot();
        stack = gameState.getCurrentPlayerStack();
        call = gameState.calculateCall();
        minimalbet =  gameState.calculateMinimalBet();
        orbits = gameState.getOrbits();
        bet = gameState.getCurrentPlayerbBet();
        numberOfActivePlayers = gameState.getNumberOfPlayers('a');
        numberOfFoldedPlayers = gameState.getNumberOfPlayers('f');
        numberOfOutPlayers = gameState.getNumberOfPlayers('o');
    }

    /**
     * @param combo
     * @param level
     * @return bet
     */
    //Versenytaktikák használata, a cashgame strarégiák itt nem nagyon játszanak
    @Override
    public Integer getBet(String combo, String level) {
        int currentTurn = orbits;
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
