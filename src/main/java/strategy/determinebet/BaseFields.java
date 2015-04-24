/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy.determinebet;

import com.wcs.poker.gamestate.GameState;
import com.wcs.poker.gamestate.enums.PlayerState;
import com.wcs.poker.hand.work.Hand;

/**
 * Jól van, akkor: Ahhoz, hogy tartsunk, azaz megadjuk a tétet ki kell
 * számolnunk a call értéket, ami a current_by_in mínusz a te bet értéked (a bet
 * az az összeg amennyit eddig betettél a közösbe), ha ez az érték 0-nak jön ki,
 * akkor az check-et jelent, ha ez 0>, akkor ez az az érték amit mindenképp meg
 * kell adni, hogy bent maradhass a játékban, ha nem tudsz ennyit megadni (azaz
 * a stack-ed kisebb ennél az éréknél, akkor az dobásnak minősül - ezt a szerver
 * lekezeli, nem kell foglalkoznod vele) Ahhoz, hogy emelni tudjál a call
 * értéken túl legalább a minimum_raise értékével kell többet betenned (azaz
 * minimális emelési összeg = call + minimum_raise) Remélem ezzel segítettem!
 *
 *
 * @author gergo
 */
public class BaseFields {

    /**
     * A kis vak kétszerese.
     */
    protected final int bigBlind;
    /**
     * A kis vak értéke.
     */
    protected final int smallBlind;
    /**
     * Az az összeg ami a legkisebb emeléshez kell.
     */
    protected final int minimumRaise;
    /**
     * A legmagasabb tét értéke, amit meg kell adni.
     */
    protected final int currentBuyIn;
    /**
     * A pénzhalom nagysága az asztalon.
     */
    protected final int pot;
    /**
     * A játékos zsetonjai.
     */
    protected final int stack;
    /**
     * Ennyiszer ért körbe az osztókorong.
     */
    protected final int orbits;
    /**
     * Az ebben a körben tétnek feltett zsetoinok összege.
     */
    protected final int bet;
    /**
     * Call értékének számítása: current_buy_in - players[in_action][bet] TODO
     * írd meg rendesen hogy mi a ** ez :D
     */
    protected final int call;
    /**
     * emelési minimum.
     */
    protected final int minimalbet;
    /**
     * Az aktuális játékállapotban aktív játékososk száma.
     */
    protected final int numberOfActivePlayers;
    /**
     * Az aktuális játékállapotban már bedobott játékososk száma.
     */
    protected final int numberOfFoldedPlayers;
    /**
     * Az aktuális játékállapotban a játékon kívüli játékososk száma.
     */
    protected final int numberOfOutPlayers;

    protected Hand hand;

    public BaseFields(GameState gameState, Hand hand) {

        bigBlind = gameState.getBigBlind();
        smallBlind = gameState.getSmallBlind();
        minimumRaise = gameState.getMinimumRaise();
        currentBuyIn = gameState.getCurrentBuyIn();
        pot = gameState.getPot();
        stack = gameState.getCurrentPlayerStack();
        call = gameState.calculateCall();
        minimalbet = gameState.calculateMinimalBet();
        orbits = gameState.getOrbits();
        bet = gameState.getCurrentPlayerbBet();
        numberOfActivePlayers = gameState.getNumberOfPlayers(PlayerState.ACTIVE);
        numberOfFoldedPlayers = gameState.getNumberOfPlayers(PlayerState.FOLDED);
        numberOfOutPlayers = gameState.getNumberOfPlayers(PlayerState.OUT);

        this.hand = hand;
    }

}
