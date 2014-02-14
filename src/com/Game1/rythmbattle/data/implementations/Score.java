package com.Game1.rythmbattle.data.implementations;

import com.Game1.rythmbattle.data.interfaces.IScore;

import java.util.HashMap;

/**
 * Created by totole on 07/02/14.
 */
public class Score implements IScore {

    private int Score = 0;
    private Combo combo = new Combo();

    HashMap<Scores,Integer> Stats = new HashMap<Scores, Integer>(8);

    Score(){
        for(Scores sc : Scores.values()){
            Stats.put(sc,0);
        }
    }

    @Override
    public void updateScore(Item item) {
        this.Score += calculateItemScore(item);
    }

    @Override
    public void updateScoreonTimeOut() {
        this.Score += Scores.MISS.getValue();
        calculateCombo(Scores.MISS);
    }


    private void calculateCombo(Scores score) {
        if(combo.getScore().getValue() == score.getValue()){
            combo.increaseCombo();
        }else{
            this.Score += getMultiplier(combo.repeat) * combo.getScore().getValue();
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

    private int calculateItemScore(Item item){
        return 0;
    }

    @Override
    public void saveScore() {

    }


    private class Combo {
        private Scores score = Scores.NORMAL;
        private int repeat = 0;

        public Scores getScore(){
            return score;
        }

        public void increaseCombo(){
            repeat++;
        }

        public void resetCombo(Scores score){
            this.score = score;
            this.repeat = 1;
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
