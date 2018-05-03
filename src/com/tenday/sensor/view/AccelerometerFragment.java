package com.tenday.sensor.view;

import com.tenday.sensor.sensor.AccelerometerSensorEventListener;
import com.tenday.sensor.sensor.LocationSensorEventListener;
import com.yunjkj.senser.R;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class AccelerometerFragment extends Fragment {
	
	//private AccelerometerSensorEventListener listener;
	
	
	public static AccelerometerFragment newInstance() {
		AccelerometerFragment fragment = new AccelerometerFragment();
        return fragment;
    }
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView text = new TextView(getActivity());
        text.setGravity(Gravity.CENTER);
        text.setTextSize(10 * getResources().getDisplayMetrics().density);
        text.setPadding(20, 20, 20, 20);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.addView(text);
        layout.setBackgroundResource(R.drawable.bg_acce);
        
        
        SensorManager sensorMag = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorMag.registerListener(new AccelerometerSensorEventListener(text), 
        		sensorMag.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
        		SensorManager.SENSOR_DELAY_FASTEST);

        return layout;
    }
	
	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putString(KEY_CONTENT, mContent);
    }
}
