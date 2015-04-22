/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.poker.hand.work;

import com.wcs.poker.gamestate.Card;
import com.wcs.poker.hand.CountTables.RankCount;
import com.wcs.poker.hand.CountTables.SuitCount;
import com.wcs.poker.hand.CountTables.UploadList;
import com.wcs.poker.hand.enums.HandLevel;
import com.wcs.poker.hand.enums.HandRank;
import java.util.List;

/**
 *
 * @author MártonZoltán
 */
public class FinalResult {

    private HandRank combo;
    private HandLevel level;

    public void evaluateCards(List<Card> cards) {
        UploadList uploadlist = new UploadList();
        Counting counting = new Counting();

        List<RankCount> rankCount = uploadlist.RankCountUpload();
        List<SuitCount> suitCount = uploadlist.SuitCountUpload();

        for (Card card : cards) {
            for (RankCount rankCount1 : rankCount) {
                if (rankCount1.getRank().equals(card.getRank())) {
                    rankCount1.setCount();
                }
            }
        }

        for (Card card : cards) {
            for (SuitCount suitCount1 : suitCount) {
                if (suitCount1.getSuit().equals(card.getSuit())) {
                    suitCount1.setCount();
                }
            }
        }

        HandRank suitAnalysisResult = null;
        HandRank analysisRankListResult = null;
        HandLevel analysisRankListLevelResult = null;

        combo = null;
        level = null;

        analysisRankListResult = counting.analysisRankList(rankCount);
        analysisRankListLevelResult = counting.getLevelresult();

        suitAnalysisResult = counting.suitAnalysis(suitCount);

        if (suitAnalysisResult == null || (suitAnalysisResult == HandRank.FLUSH && analysisRankListResult == HandRank.FOUR_OF_A_KIND)) {
            combo = analysisRankListResult;
        } else {
            combo = suitAnalysisResult;
        }

        if (analysisRankListResult == HandRank.STRAIGHT && suitAnalysisResult == HandRank.FLUSH) {
            combo = HandRank.STRAIGHT_FLUSH;
        }

        if (analysisRankListResult == HandRank.ROYAL && suitAnalysisResult == HandRank.FLUSH) {
            combo = HandRank.ROYAL_FLUSH;
        }

        level = analysisRankListLevelResult;

        if (combo == HandRank.FLUSH) {
            level = counting.getFlushLevel();
        }

        if (combo == null) {
            level = counting.getFlushLevel();
        }

    }

    public HandRank getCombo() {
        return combo;
    }

    public HandLevel getLevel() {
        return level;
    }

}
