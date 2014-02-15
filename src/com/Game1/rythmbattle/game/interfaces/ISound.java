package com.Game1.rythmbattle.game.interfaces;

//import android.content.Context;



import com.Game1.rythmbattle.listener.interfaces.ISoundListener;

/**
 * Created by totole on 07/02/14.
 */
public interface ISound {
	
	/**
	 * Voir si il ne faut pas plutôt un id de ressource plutôt qu'un fichier
	 * @param audioFile
	 * @return 
	 * @return 
	 */
	
	
	public void setSound(String audioFile);
	
	public void play();
	
	public void pause();
	
	public void stop();

	public void addListener(ISoundListener listener);

	public void removeListener(ISoundListener listener);

	
}
