/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.cardAnalysis.enums;

/**
 *a kártyák osztályozása 1. a legértékesebb
    1 Rojálflös (royal flush)
    2 Színsor (straight flush)
    3 Póker (four of a kind)
    4 Full (full house)
    5 Flös (flush)
    6 Sor (straight)
    7 Drill (three of a kind)
    8 Két Pár (two pairs)
    9 Egy Pár (pair)
    10 Magas lap (high card)
 * @author boss
 */
public enum CardClass {
    
    high_card,
    pair,
    two_pairs,
    three_of_a_kind,//drill
    straight,
    flush,
    full_house,
    four_of_a_kind,
    straight_flush,
    royal_flush
    
}
