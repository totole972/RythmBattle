package com.Game1.rythmbattle.game.interfaces;

import java.util.List;

import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.listener.interfaces.ITimelineListener;

/**
 * Created by totole on 07/02/14.
 */
public interface ITimeline {
	
	public void setItemList(List<IItem> itemList);
	
	public void start();

	public void addListener(ITimelineListener listener);
	
	public void removeListener(ITimelineListener listener);
	
}
