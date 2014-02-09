package com.Game1.rythmbattle.data.implementations;

import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.data.interfaces.IScore;

/**
 * Created by totole on 07/02/14.
 */
public class Score implements IScore {

    private int Score = 0;

    private int FLAWLESS = 100;
    private int PERFECT = 80;
    private int GREAT = 70;
    private int GOOD = 60;
    private int AVERAGE = 45 ;
    private int BAD  =  -25;
    private int MISS =  -50;


    @Override
    public void updateScore(IItem item) {

    }

    @Override
    public void calculateCombo() {

    }



    private class Combo {

    }
}
