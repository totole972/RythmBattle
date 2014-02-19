package com.Game1.rythmbattle;

import java.util.ArrayList;
import java.util.List;

import com.Game1.rythmbattle.data.implementations.Item;
import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.game.implementations.GameManager;
import com.Game1.rythmbattle.game.implementations.Graphic;
import com.Game1.rythmbattle.listener.interfaces.IItemListener;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import com.Game1.rythmbattle.game.implementations.Sound;
public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       
        setContentView(R.layout.game);
        
        /* for testing Sound Class
		Log.e("MyApp", "this is ok 0");
		mysoundTest= new Sound(this);
		Log.e("MyApp", "this is ok 1");
		mysoundTest.setSound("oppan_gangnam_style");
		Log.e("MyApp", "this is ok 2");
		mysoundTest.play();
		Log.e("MyApp", "this is ok 4");*/
        
        // Ici on simule la création d'objet et la recherche du fichier audio
        List<IItem> listItem = new ArrayList<IItem>();
        IItem item = new Item();
        item.setPositionX(100);
        item.setPositionY(150);
        item.setTimestamp(1000);
        item.setDuration(2000);
        item.setTaille(50);
        item.setOrdre(1);
        listItem.add(item);
        
        item = new Item();
        item.setPositionX(200);
        item.setPositionY(150);
        item.setTimestamp(10000);
        item.setDuration(5000);
        item.setTaille(100);
        item.setOrdre(2);
        listItem.add(item);
        
        
        new GameManager().lancerPartie(this, listItem, "music", (Graphic)findViewById(R.layout.game));
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
