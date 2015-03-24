package com.test.first;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.button1: {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, NotificationActivity.class);
            intent.setAction("android.intent.action.CALL_BUTTON");
            startActivity(intent);
		}

		case R.id.button2: {
			
			break;
			}
		}

	}

}
