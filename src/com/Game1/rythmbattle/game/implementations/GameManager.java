package com.Game1.rythmbattle.game.implementations;

import java.util.List;

import android.content.Context;
import android.util.Log;

import com.Game1.rythmbattle.data.implementations.Score;
import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.data.interfaces.IScore;
import com.Game1.rythmbattle.game.interfaces.IGameManager;
import com.Game1.rythmbattle.game.interfaces.IGraphic;
import com.Game1.rythmbattle.game.interfaces.ISound;
import com.Game1.rythmbattle.game.interfaces.ITimeline;
import com.Game1.rythmbattle.listener.interfaces.IGraphicListener;
import com.Game1.rythmbattle.listener.interfaces.IItemListener;
import com.Game1.rythmbattle.listener.interfaces.ISoundListener;
import com.Game1.rythmbattle.listener.interfaces.ITimelineListener;

public class GameManager implements IGameManager {

	private IGraphic graphic = new Graphic();
	private ISound sound;
	private ITimeline timeline = new Timeline();
	private IScore score = new Score();

	public void lancerPartie(Context context, List<IItem> listItem, String audioFile) {

		Log.i("game", "Game will start");
		
		sound = new Sound(context);
		
		sound.setSound(audioFile);
		timeline.setItemList(listItem);

		sound.addListener(new ISoundListener() {
			public void ended() {
				soundEnded();
			}
		});

		timeline.addListener(new ITimelineListener() {
			public void newItem(IItem item) {
				newItemFound(item);
			}
		});

		graphic.addListener(new IGraphicListener() {
			public void itemTouched(IItem item) {
				newItemTouched(item);
			}
		});

		timeline.start();
		sound.play();

	}

	private void soundEnded() {
		// TODO: terminer la partie ici
	}

	private void newItemFound(IItem item) {
		System.out.println("Item found: " + item);
		
		// On va s'inscrire
		item.addListener(new IItemListener() {
			public void timeout(IItem item) {
				itemTimeout(item);
			}
		});

		item.start();
		graphic.add(item);
	}

	private void newItemTouched(IItem item) {
		item.stop();
		
		score.updateScore(item);
		
		graphic.remove(item, item.isTimeout());
	}

	private void itemTimeout(IItem item) {
		graphic.remove(item, false);
	}
}
