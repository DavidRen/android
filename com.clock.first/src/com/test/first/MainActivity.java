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
		Button httpJson = (Button) findViewById(R.id.jsonButton);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		httpJson.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.button1: {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, NotificationActivity.class);
            startActivity(intent);
            break;
		}

		case R.id.button2: {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this,AnimationActivity.class);
			startActivity(intent);
			break;
			}
		
		case R.id.jsonButton:{
			Intent intent = new Intent();
			intent.setClass(MainActivity.this,JsonActivity.class);
			startActivity(intent);
			break;
			}
		}

	}

}
