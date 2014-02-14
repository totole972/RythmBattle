package com.Game1.rythmbattle.data.implementations;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import android.os.Handler;

import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.listener.interfaces.IItemListener;

public class Item implements IItem {

    public static final int TAILLE_MAX = 50; //TODO Modify depending on how the size of an item is determined
	private int timestamp = 0;
	private int positionX = 0;
	private int positionY = 0;
	private int ordre = 0;
	private int duration = 0;
	private int taille = 0;
	
	private Handler handler;
	
	private List<IItemListener> listeners = new ArrayList<IItemListener>();
	
	private long globalTimestampStart;
	
	private boolean hasStopped;
	private int timeEllapsed;

	public void start() {
		handler = new Handler();
		handler.postDelayed(watchEnd, duration);
		
		// On enregistre le timestamp au début
		globalTimestampStart = new Date().getTime();
	}

	public void stop() {
		handler.removeCallbacks(watchEnd);
		
		// On met à jour le moment où l'objet a été stopé
		computeTimeEllapsed();
	}
	
	/**
	 * Retourne le temps restant avant le timeout
	 */
	public int getTimeLeft() {
		if(!hasStopped){
			computeTimeEllapsed();
		}
		return duration - timeEllapsed;
	}

	/**
	 * Retourne si l'objet est en timeout
	 */
	public boolean isTimeout() {
		return getTimeLeft() <= 0;
	}

	public int getTimestamp() {
		return this.timestamp;
	}

	public int getPositionX() {
		return this.positionX;
	}

	public int getPositionY() {
		return this.positionY;
	}

	public int getOrdre() {
		return this.ordre;
	}

	public int getDuration() {
		return this.duration;
	}
	
	public int getTaille() {
		return this.taille;
	}
	

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	
	public void addListener(IItemListener listener) {
		listeners.add(listener);
	}
	
	public void removeListener(IItemListener listener) {
		// TODO
	}
	
	private void computeTimeEllapsed(){
		long globalTimstampCurrent = new Date().getTime();
		timeEllapsed = (int)(globalTimstampCurrent - globalTimestampStart);
	}
	
	private void itemEnded(){
		// Ici on notifie les listeners de la fin de notre objet
		for(int i=0;i<listeners.size();i++){
			listeners.get(i).timeout(this);
		}
	}
	
	private Runnable watchEnd = new Runnable() {
		public void run() {
			itemEnded();
		}
	};

}
