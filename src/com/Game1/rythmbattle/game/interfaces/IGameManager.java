package com.Game1.rythmbattle.game.interfaces;

import java.util.List;

import android.content.Context;

import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.game.implementations.Graphic;

/**
 * Created by totole on 07/02/14.
 */
public interface IGameManager {
	
	void lancerPartie(Context context, List<IItem> listItem, String audioFile, Graphic view);
	
}
