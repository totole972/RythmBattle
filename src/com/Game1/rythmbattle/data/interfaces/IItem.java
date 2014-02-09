package com.Game1.rythmbattle.data.interfaces;

import com.Game1.rythmbattle.listener.interfaces.IItemListener;

/**
 * Created by totole on 07/02/14.
 */
public interface IItem {
	
    public void start();
    
    public void stop();
    
    public int getTimeLeft();

    
    public int getTimestamp();
    
    public int getPositionX();
    
    public int getPositionY();
    
    public int getOrdre();
    
    public int getDuration();
    
    public int getTaille();
    

    public void addListener(IItemListener listener);
    
    public void removeListener(IItemListener listener);
    
}
