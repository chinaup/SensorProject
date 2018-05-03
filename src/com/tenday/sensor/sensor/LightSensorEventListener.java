package com.tenday.sensor.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class LightSensorEventListener implements SensorEventListener {
	
	private TextView text;

	
	public LightSensorEventListener(TextView text) {
		this.text = text;
	}
	
	
	
	
	@Override
	public void onSensorChanged(SensorEvent event){
		
		float value = event.values[0];		
		text.setText("当前光强 " +value+  "lx");
		
		        
	}
	
	
	@Override
    public void onAccuracyChanged(Sensor seensor,int accuracy){
		
	}

}
