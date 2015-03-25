package com.test.first;

import android.app.Activity;
import android.content.res.Configuration;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends ActivityUtil implements OnClickListener  {
	
	private boolean Rotatedflag = false;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activiy_animation);
		Button bt1 = (Button) findViewById(R.id.buttonAnimation);
		bt1.setOnClickListener(this);
				
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Animation animation = null;
		if(!Rotatedflag){
		animation = AnimationUtils.loadAnimation(
		        AnimationActivity.this, R.anim.demo0_180);
				Rotatedflag = true;
		     // Æô¶¯¶¯»­
		}else{
			animation = AnimationUtils.loadAnimation(
			        AnimationActivity.this, R.anim.demo180_0);
					Rotatedflag = false;	
		}
		animation.setFillAfter(true);
		ImageView image = (ImageView) findViewById(R.id.imageView1);
		     image.startAnimation(animation);
	}
	
	
}
