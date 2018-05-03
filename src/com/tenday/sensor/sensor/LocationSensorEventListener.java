package com.tenday.sensor.sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class LocationSensorEventListener implements SensorEventListener {
	
	private float currentDegree = 0f;
	private ImageView imageView;
	
	public LocationSensorEventListener(ImageView imageView) {
		this.imageView = imageView;
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Autoxn s-generated method stub
		Log.e("Location: ", event.values[0] + " , " + event.values[1] + event.values[2]);
		float degree = event.values[0];
		
		RotateAnimation ra = new RotateAnimation(
				currentDegree, -degree, 
				Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		
		ra.setDuration(200);	// 动画持续时间
		ra.setFillAfter(true);	// 设置动画结束后保留状态
		
		imageView.setAnimation(ra);
		currentDegree = -degree;
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}
