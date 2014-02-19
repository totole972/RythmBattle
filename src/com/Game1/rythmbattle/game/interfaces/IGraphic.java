package com.Game1.rythmbattle.game.interfaces;

import android.view.View;

import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.listener.interfaces.IGraphicListener;

/**
 * Created by totole on 07/02/14.
 */
public interface IGraphic {
	
	public void add(IItem item);
	
	public void remove(IItem item, boolean isTouched);
	
	public void addListener(IGraphicListener listener);
	
	public void removeListener(IGraphicListener listener);
	
}
