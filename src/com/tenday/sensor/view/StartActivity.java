package com.tenday.sensor.view;


import com.yunjkj.senser.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.AlphaAnimation; 
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class StartActivity extends Activity{

	private ImageView welcomeImg = null;
	
	protected void onCreate(Bundle arg0){
		super.onCreate(arg0);
		setContentView(R.layout.into_app);
		welcomeImg = (ImageView)this.findViewById(R.id.welcome_img);
		AlphaAnimation anima = new AlphaAnimation(0.3f,1.0f);
		anima.setDuration(4000);//设置动画显示时间
		
		//Log.d("StartActivity","onCreate execute");
		//System.out.println("有没有被执行");
		welcomeImg.startAnimation(anima);
		anima.setAnimationListener(new AnimationImpl());
	}
	
	private class AnimationImpl implements AnimationListener{
		
		public void onAnimationStart(Animation animation){
			welcomeImg.setBackgroundResource(R.drawable.welcome);
			//Log.d("StartActivity","onCreate execute");
		}
		
		public void onAnimationEnd(Animation animation){
			skip();//动画结束后跳转到别的页面
		}
		
		public void onAnimationRepeat(Animation animation){
			
		}
	}
	
	private void skip(){
		//Log.d("StartActivity","onCreate execute");
		startActivity(new Intent(StartActivity.this,MainActivity.class));
		finish();
	}
}
