package com.tenday.sensor.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.IconPagerAdapter;

class MainFragmentAdapter extends FragmentPagerAdapter {

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
    	if (position == 0) 
    		return LightFragment.newInstance();
    	else if (position == 1) 
    		return AccelerometerFragment.newInstance();
    	else  
    		return LocationFragment.newInstance();
    	
    }

    @Override
    public int getCount() {
        return 3;
    }
}