package com.Game1.rythmbattle.game.implementations;

import java.util.ArrayList;
import java.util.List;

import android.app.LauncherActivity.ListItem;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.game.interfaces.IGraphic;
import com.Game1.rythmbattle.listener.interfaces.IGraphicListener;

public class Graphic extends View {

	private List<IItem> itemList = new ArrayList<IItem>();
	private List<ShapeDrawable> shapeList = new ArrayList<ShapeDrawable>();
	private List<IGraphicListener> listeners = new ArrayList<IGraphicListener>();
	private View view;
	
	private Handler handler = new Handler();
	
	final private int REFRESH_DELAY = 100;

	public Graphic(Context context){
		super(context);
		init();
	}
	
	public Graphic(Context context, AttributeSet attrSet){
		super(context);
		init();
	}
	
	private void init(){
		handler.postDelayed(refreshFrame, REFRESH_DELAY);
		this.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				viewTouched(event);
				return true;
			}
		});
	}
	
	public void onDraw(Canvas canvas){
		IItem item;
		ShapeDrawable shape;
		for(int i=0;i<shapeList.size();i++){
			if(shapeList.get(i) == null) break;
			item = itemList.get(i);
			shape = shapeList.get(i);
			shape.setBounds(item.getPositionX(), item.getPositionY(), item.getPositionX() + item.getTaille(), item.getPositionY() + item.getTaille());
			shape.draw(canvas);
		}
	}

	public void add(IItem item) {
		itemList.add(item);
		
		ShapeDrawable shape = new ShapeDrawable(new OvalShape());
		shape.getPaint().setColor(0xffff0000);
	}

	public void remove(IItem item, boolean isTouched) {
		
	}

	public void addListener(IGraphicListener listener) {
		listeners.add(listener);
	}

	public void removeListener(IGraphicListener listener) {
		
	}

	private void viewTouched(MotionEvent evt) {
		int x = (int)evt.getX();
		int y = (int)evt.getY();
		
		// Check if an item has been touched
		IItem item;
		for(int i=0;i<itemList.size();i++){
			item = itemList.get(i);
			if(x <= item.getPositionX() + item.getTaille() / 2 // a gauche
					&& x >= item.getPositionX() - item.getTaille() / 2 // a droite
					&& y <= item.getPositionY() + item.getTaille() / 2 // en dessous
					&& y >= item.getPositionY() - item.getTaille() / 2) {
				// Alors touched
				notifyTouchItem(item);
				break;
			}
		}
		
	}
	
	private void notifyTouchItem(IItem item){
		for(int i=0;i<listeners.size();i++){
			listeners.get(i).itemTouched(item);
		}
	}
	
	private void renderItems(){
		
	}
	
	private void nextFrame(){
		this.invalidate();
	}
	
	private Runnable refreshFrame = new Runnable(){
		public void run() {
			nextFrame();
			handler.postDelayed(refreshFrame, REFRESH_DELAY);
		}
	};

	private class ViewItem extends View {

		IItem item;
		ShapeDrawable shape;
		
		public ViewItem(Context context) {
			super(context);
		}
		
		public void setItem(IItem item){
			this.item = item;
		}
		
	}
	
}
