package com.Game1.rythmbattle.game.implementations;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.util.Log;

import com.Game1.rythmbattle.game.interfaces.ISound;
import com.Game1.rythmbattle.listener.interfaces.ISoundListener;

public class Sound implements ISound {
	private MediaPlayer mediaPlayer;
	Context myContext;
	int resourceId;
	private List<ISoundListener> listeners = new ArrayList<ISoundListener>();

	public Sound(Context myContext) {
		this.myContext = myContext;
	}

	@Override
	public void setSound(String audioFile1) {
		// valid file name: must contain only [a-z0-9_.]
		try {
			resourceId = myContext.getResources().getIdentifier(audioFile1,"raw", "com.Game1.rythmbattle");
		} catch (Exception e) {
			Log.e("Mydebug", "Failure to get sound id.", e);
		}
		mediaPlayer = MediaPlayer.create(myContext, resourceId);
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				// appler quand la musique est termin�e
				soundEnded();
				Log.i("Mydebug", "Music is ended");
			}
		});
	}

	@Override
	public void play() {
		mediaPlayer.start();
	}

	@Override
	public void pause() {
		mediaPlayer.pause();
	}

	@Override
	public void stop() {
		mediaPlayer.stop();
	}

	@Override
	public void addListener(ISoundListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeListener(ISoundListener listener) {
		// TODO Auto-generated method stub
	}

	private void soundEnded() {
		System.out.println(" musique est termin�");
		for (int i = 0; i < listeners.size(); i++) {
			listeners.get(i).ended();
		}
	}

}