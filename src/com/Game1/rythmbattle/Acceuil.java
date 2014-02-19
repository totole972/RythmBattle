package com.Game1.rythmbattle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Acceuil extends Activity {

	Button Commencer;
	Button Apropos;
	Button Quitter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acceuil);
		Commencer = (Button) findViewById(R.id.button1);
		Commencer.setOnClickListener(commencerEcouteur);
		Apropos = (Button) findViewById(R.id.button2);
		Apropos.setOnClickListener(AproposEcouteur);
		Quitter = (Button) findViewById(R.id.button3);
		Quitter.setOnClickListener(QuitterEcouteur);

	}

	private OnClickListener commencerEcouteur = new OnClickListener() {
		public void onClick(View arg0) {
			Intent intent = new Intent(Acceuil.this, MainActivity.class);
			startActivity(intent);

		}
	};

	private OnClickListener AproposEcouteur = new OnClickListener() {
		public void onClick(View arg0) {
			Intent intent = new Intent(Acceuil.this, Apropos.class);
			startActivity(intent);

		}
	};

	private OnClickListener QuitterEcouteur = new OnClickListener() {
		public void onClick(View arg0) {
			System.exit(RESULT_OK);

		}
	};
}
