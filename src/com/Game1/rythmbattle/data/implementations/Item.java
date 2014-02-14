package com.Game1.rythmbattle.data.implementations;

import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.listener.interfaces.IItemListener;

public class Item implements IItem {

    public static final int TAILLE_MAX = 50; //TODO Modify depending on how the size of an item is determined

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTimeLeft() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isTimeout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTimestamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOrdre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTaille() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addListener(IItemListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListener(IItemListener listener) {
		// TODO Auto-generated method stub

	}

}
