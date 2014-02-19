package com.Game1.rythmbattle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Apropos extends Activity {

	Button Acceuil;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.apropos);
		Acceuil = (Button) findViewById(R.id.button1);
		Acceuil.setOnClickListener(AcceuilEcouteur);

	}

	private OnClickListener AcceuilEcouteur = new OnClickListener() {
		public void onClick(View arg0) {
			Apropos.this.finish();

		}
	};

}
