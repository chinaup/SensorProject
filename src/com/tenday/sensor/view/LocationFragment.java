package com.tenday.sensor.view;

import com.tenday.sensor.sensor.LocationSensorEventListener;
import com.yunjkj.senser.R;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class LocationFragment extends Fragment {
	
	public static LocationFragment newInstance() {
		LocationFragment fragment = new LocationFragment();
        return fragment;
    }
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		ImageView imageView = new ImageView(getActivity());
		imageView.setImageResource(R.drawable.location);
		//imageView.setBackgroundResource(R.drawable.location_bg);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        layout.addView(imageView);
        layout.setBackgroundResource(R.drawable.bg_location);
        
        SensorManager sensorMag = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorMag.registerListener(new LocationSensorEventListener(imageView), 
        		sensorMag.getDefaultSensor(Sensor.TYPE_ORIENTATION), 
        		SensorManager.SENSOR_DELAY_FASTEST);

        return layout;
    }
	
	@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putString(KEY_CONTENT, mContent);
    }
}
