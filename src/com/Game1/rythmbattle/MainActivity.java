package com.Game1.rythmbattle;

import java.util.ArrayList;
import java.util.List;

import com.Game1.rythmbattle.data.implementations.Item;
import com.Game1.rythmbattle.data.interfaces.IItem;
import com.Game1.rythmbattle.game.implementations.GameManager;
import com.Game1.rythmbattle.listener.interfaces.IItemListener;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
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
        
        new GameManager().lancerPartie(listItem, "test");
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
