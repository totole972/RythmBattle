package com.Game1.rythmbattle.data.interfaces;

import com.Game1.rythmbattle.listener.interfaces.IItemListener;

/**
 * Created by totole on 07/02/14.
 */
public interface IItem {
	
    public void start();
    
    public void stop();
    
    public int getTimeLeft();
    
    public boolean isTimeout();

    
    public int getTimestamp();
    
    public int getPositionX();
    
    public int getPositionY();
    
    public int getOrdre();
    
    public int getDuration();
    
    public int getTaille();

    
    public void setTimestamp(int timestamp);
    
    public void setPositionX(int positionX);
    
    public void setPositionY(int positionY);
    
    public void setOrdre(int ordre);
    
    public void setDuration(int duration);
    
    public void setTaille(int taille);
    

    public void addListener(IItemListener listener);
    
    public void removeListener(IItemListener listener);
    
}
