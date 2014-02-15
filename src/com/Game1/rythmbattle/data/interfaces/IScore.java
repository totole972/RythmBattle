package com.Game1.rythmbattle.data.interfaces;

import com.Game1.rythmbattle.data.implementations.Item;

/**
 * Created by totole on 07/02/14.
 */
public interface IScore {

    public void updateScore(IItem item);
    public int getScore();
    public void finalizeScore();
}
