package com.tenday.sensor.view;

import java.io.File;
import java.io.FileOutputStream;

import com.viewpagerindicator.LinePageIndicator;
import com.yunjkj.senser.R;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity{

	private RadioButton rdoLight;
	private RadioButton rdoAccelerometer;
	private RadioButton rdoLocation;
	private MainFragmentAdapter adapter;
	private ViewPager viewPager;
	private LinePageIndicator indicator;
	private RadioGroup tab_RadioGroup;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_main);
		
		tab_RadioGroup = (RadioGroup)findViewById(R.id.home_radio_button_group);

		
		rdoLight = (RadioButton) findViewById(R.id.menu_rdo_light);
		rdoLight.setChecked(true);
		/*rdoLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					viewPager.setCurrentItem(0);
				}
			}
		});*/
		
		rdoLight = (RadioButton) findViewById(R.id.menu_rdo_light);
		rdoLight.setOnClickListener(new OnClickListener(0));
		
		
		rdoAccelerometer = (RadioButton) findViewById(R.id.menu_rdo_accelerometer);
		rdoAccelerometer.setOnClickListener(new OnClickListener(1));
		
		rdoLocation = (RadioButton) findViewById(R.id.menu_rdo_location);
		rdoLocation.setOnClickListener(new OnClickListener(2));
		
		
		adapter = new MainFragmentAdapter(getSupportFragmentManager());

		viewPager = (ViewPager)findViewById(R.id.main_pager);
		viewPager.setAdapter(adapter);

		indicator = (LinePageIndicator)findViewById(R.id.main_indicator);
		indicator.setViewPager(viewPager);
		
		viewPager.setOnPageChangeListener(new MyViewPagerListener());

		
//		LinearLayout l = new LinearLayout(this);
//		ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//		this.addContentView(l, params);
	}
	
	
	
	private class OnClickListener implements View.OnClickListener {
		
		private int currentItemIndex;
		
		public OnClickListener(int currentItemIndex) {
			this.currentItemIndex = currentItemIndex;
		}
		
/*----------------------------------------------------------------------------	 		
		@Override
		public void onPageSelected(int arg0)
		{
		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels)
		{
			// Log.e("TAG", "position = " + position + " , positionOffset = "
			// + positionOffset);
	 
			if (positionOffset > 0)
			{
				ChangeColorIconWithTextView left = mTabIndicator.get(position);
				ChangeColorIconWithTextView right = mTabIndicator.get(position + 1);
	 
				left.setIconAlpha(1 - positionOffset);
				right.setIconAlpha(positionOffset);
			}
	 
		}
	 
		@Override
		public void onPageScrollStateChanged(int state)
		{
	 
		}
	 
//---------------------------------------------------------------------------------*/
        
		
		
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			viewPager.setCurrentItem(currentItemIndex);
		}
	}
	
	//Ò³Ãæ»¬¶¯µÄ¼àÌý
		class MyViewPagerListener implements OnPageChangeListener{
			public void onPageScrollStateChanged(int arg0){}
			
			public void onPageScrolled(int arg0,float arg1,int arg2){}
			
			public void onPageSelected(int arg0) {
				int current = viewPager.getCurrentItem();
				
				switch(current){
				case 0:
					((RadioGroup) tab_RadioGroup).check(R.id.menu_rdo_light);
					break;
				case 1:
					((RadioGroup) tab_RadioGroup).check(R.id.menu_rdo_accelerometer);
					break;
				case 2:
					((RadioGroup) tab_RadioGroup).check(R.id.menu_rdo_location);
					break;
				}
	        }
		}

}
