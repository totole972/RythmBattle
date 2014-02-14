package com.Game1.rythmbattle.data.implementations;

import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.data.interfaces.IScore;

import java.util.HashMap;

/**
 * Created by totole on 07/02/14.
 */
public class Score implements IScore {

    private int Score = 0;
    private Combo combo = new Combo();

    HashMap<String,Integer> Stats = new HashMap<String, Integer>(8);
    HashMap<String,Integer> StatsScore = new HashMap<String, Integer>(8);

    public Score(){
        for(Scores sc : Scores.values()){
            Stats.put(sc.name(),0);
        }

        for(Scores sc : Scores.values()){
            StatsScore.put(sc.name(),0);
        }
    }

    @Override
    public void updateScore(IItem item) {
        this.Score += calculateItemScore(item);
    }

    private void calculateCombo(Scores score) {
        if(combo.getScore().getValue() == score.getValue()){
            combo.increaseCombo();
        }else{
            this.Score += getMultiplier(combo.getRepeat()) * combo.getScore().getValue();
            int interScore = StatsScore.get(score.name());
            interScore += getMultiplier(combo.getRepeat()) * combo.getScore().getValue();
            StatsScore.put(score.name(),interScore);
            this.combo.resetCombo(score);
        }
    }

    private int getMultiplier(int repeat){
        int multiplier = 0;
        if(multiplier > 1){
            if(repeat < 5){
                multiplier = 2;
            }else if(repeat < 10){
                multiplier = Math.round(repeat * 3.14F / 4);
            }else if(repeat < 10){
                multiplier = Math.round(repeat * 3.14F / 2);
            }else if(repeat < 10){
                multiplier = Math.round(repeat * 3 * 3.14F / 4);
            }else{
                multiplier = Math.round(repeat * 3.14F);
            }
        }
        return multiplier;
    }

    private int calculateItemScore(IItem item){
        int sizeMultiplicator = calculateSizeMultiplicator(item.getTaille());
        Scores sc = calculateScoreFromTime(item);
        this.Score += sc.getValue() * sizeMultiplicator;
        calculateCombo(sc);
        updateStats(sc);
        return 0;
    }

    private void updateStats(Scores score){
        int nb = Stats.get(score.name());
        nb++;
        Stats.put(score.name(),nb);
    }


    public int getScore(){
        return this.Score;
    }

    public HashMap<String,Integer> getStats(){
        return Stats;
    }

    private int calculateSizeMultiplicator(int itemSize){
        Float sizePercentage = (itemSize/Item.TAILLE_MAX)*1.0F;
        int multiplier = 1;
        if(sizePercentage < 0.2){
            multiplier = 5;
        }else if(sizePercentage < 0.4){
            multiplier = 4;
        }else if(sizePercentage < 0.6){
            multiplier = 3;
        }else if(sizePercentage < 0.8){
            multiplier = 2;
        }
        return multiplier;
    }

    private Scores calculateScoreFromTime(IItem item){
        Scores score =Scores.NORMAL;
        if(item.isTimeout()){
            score = Scores.MISS;
        }else{
            Float percentageTimeLeft = (item.getTimeLeft()/item.getDuration())*1.0F;
            if(percentageTimeLeft < 0.2){
                score = Scores.FLAWLESS;
            }else if(percentageTimeLeft < 0.4){
                score = Scores.PERFECT;
            }else if(percentageTimeLeft < 0.5){
                score = Scores.GREAT;
            }else if(percentageTimeLeft < 0.6){
                score = Scores.GOOD;
            }else if(percentageTimeLeft < 0.7){
                score = Scores.AVERAGE;
            }else if(percentageTimeLeft < 0.8){
                score = Scores.NORMAL;
            }else{
                score = Scores.BAD;
            }
        }
        return score;
    }

    @Override
    public void finalizeScore() {
        this.Score += getMultiplier(combo.getRepeat()) * combo.getScore().getValue();
        int interScore = StatsScore.get(combo.getScore().name());
        interScore += getMultiplier(combo.getRepeat()) * combo.getScore().getValue();
        StatsScore.put(combo.getScore().name(),interScore);
        this.combo.closeCombo();
    }


    private class Combo {
        private Scores score = Scores.NORMAL;
        private int repeat = 0;

        public Scores getScore(){
            return score;
        }
        public int getRepeat(){
            return repeat;
        }

        public void increaseCombo(){
            repeat++;
        }

        public void resetCombo(Scores score){
            this.score = score;
            this.repeat = 1;
        }

        public void closeCombo(){
            score = Scores.NORMAL;
            repeat =0;
        }

    }

    enum Scores{
        FLAWLESS(100),
        PERFECT(80),
        GREAT(70),
        GOOD(60),
        AVERAGE(45),
        NORMAL(0),
        BAD(-25),
        MISS(-50);

        private final int value;

        Scores(int valeur){
            this.value = valeur;
        }

        public int getValue(){
            return this.value;
        }
    }
}
