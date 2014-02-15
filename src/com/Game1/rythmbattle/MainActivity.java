package com.Game1.rythmbattle;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import com.Game1.rythmbattle.game.implementations.Sound;
public class MainActivity extends Activity {

	public TextView songName, startTimeField, endTimeField;

	Sound mysoundTest;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/* for testing Sound Class
		Log.e("MyApp", "this is ok 0");
		mysoundTest= new Sound(this);
		Log.e("MyApp", "this is ok 1");
		mysoundTest.setSound("oppan_gangnam_style");
		Log.e("MyApp", "this is ok 2");
		mysoundTest.play();
		Log.e("MyApp", "this is ok 4");*/
		
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
