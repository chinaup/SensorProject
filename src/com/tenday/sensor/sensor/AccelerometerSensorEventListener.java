package com.tenday.sensor.sensor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.tenday.sensor.view.MainActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

public class AccelerometerSensorEventListener extends Activity implements SensorEventListener {
	
	Context mContext;
	private int count;
	private TextView text;
	
	/*public AccelerometerSensorEventListener(Context context){
		mContext = context;
	}*/
	
	public AccelerometerSensorEventListener(TextView text) {
		this.text = text;
	}
	
	@Override
	public void onSensorChanged(SensorEvent event){
		
		float xValue = Math.abs(event.values[0]);
		float yValue = Math.abs(event.values[1]);
		float zValue = Math.abs(event.values[2]);
		
		if(xValue>18||yValue>18||zValue>18){
			count++;
			double meter=count*0.04;
			text.setText("ÄúÒÑÅÜ "+(float)meter+"Ã×");

		}
		
	}
 
	

	@Override
	public void onAccuracyChanged(Sensor seensor,int accuracy){
		
	}

}
