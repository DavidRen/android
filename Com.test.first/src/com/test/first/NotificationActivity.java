package com.test.first;

import android.app.Activity;
import android.app.Notification.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class NotificationActivity extends Activity implements OnClickListener {

	private NotificationManager mNotificationManager = null;
	private Builder builder = null;
	private NotificationManager manager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.button1: {
			
			TextView tv1 = (TextView)findViewById(R.id.editText1);
			if(tv1.getText().equals("")){
				tv1.setText("default content");
			}
			Intent resultIntent = new Intent(NotificationActivity.this,NotificationActivity.class);
			
			//封装一个Intent
			PendingIntent resultPendingIntent = PendingIntent.getActivity(
					NotificationActivity.this, 0, resultIntent,
					Intent.FLAG_ACTIVITY_NEW_TASK);
			Notification notify = new Notification.Builder(NotificationActivity.this)
					.setContentTitle("5 new message").setContentText(tv1.getText())
					.setTicker("New message")
					// 第一次提示消息的时候显示在通知栏上
					.setSmallIcon(R.drawable.logo)
					.setContentIntent(resultPendingIntent).build();
			mNotificationManager.notify(0, notify);
			break;
		}

		case R.id.button2: {
			manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
			builder = new Notification.Builder(NotificationActivity.this)
					.setContentTitle("5 new message")
					.setContentText("android in progress")
					.setTicker("New message")
					// 第一次提示消息的时候显示在通知栏上
					.setSmallIcon(R.drawable.logo);
			builder.setAutoCancel(true);
			new Thread(new Runnable(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					int incr;
					for (incr = 0; incr <= 100; incr += 5) {
					builder.setProgress(100, incr, false);
					manager.notify(0, builder.build());
					try {
					Thread.sleep(300);
					} catch (InterruptedException e) {
					Log.i("TAG", "sleep failure");
					}
					while(incr >=100){
					builder.setContentText("Download complete");
					manager.notify(0, builder.build());
					break;
					}
					manager.notify(0, builder.build());
					}
				}
			}).start();;
			break;
			}
		}

	}

}
