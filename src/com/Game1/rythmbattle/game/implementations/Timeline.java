package com.Game1.rythmbattle.game.implementations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import android.os.Handler;

import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.game.interfaces.ITimeline;
import com.Game1.rythmbattle.listener.interfaces.ITimelineListener;

public class Timeline implements ITimeline {

	private Handler handler;
	
	private LinkedList<IItem> itemQueue;

	private List<ITimelineListener> listeners = new ArrayList<ITimelineListener>();
	
	
	public void setItemList(List<IItem> itemList) {
		
		itemQueue = new LinkedList<IItem>();
		for(int i=0;i<itemList.size();i++){
			itemQueue.add(itemList.get(i));
		}
	}

	public void start() {
		handler = new Handler();
		nextItem();
	}

	@Override
	public void addListener(ITimelineListener listener) {
		listeners.add(listener);
	}

	public void removeListener(ITimelineListener listener) {
		// TODO Auto-generated method stub

	}

	private void nextItem(){
		if(itemQueue.size() == 0) return;
		
		int nextIn = itemQueue.peek().getTimestamp();
		
		handler.postDelayed(watchNextItem, nextIn);
		
	}
	
	private void nextItemFound() {
		// On recupere le premier élément
		IItem item = itemQueue.poll();
		notifyListener(item);
		
		// On remove tous les items qui doivent appraître en même temps que l'autre
		while(itemQueue.size() > 0 && itemQueue.peek().getTimestamp() == item.getTimestamp()){
			item = itemQueue.poll();
			notifyListener(item);
		}
		
		nextItem();
	}
	
	private void notifyListener(IItem item){
		for(int i=0;i<listeners.size();i++){
			listeners.get(i).newItem(item);
		}
	}
	
	private Runnable watchNextItem = new Runnable(){
		public void run() {
			nextItemFound();
		}
	};
	
}
