package com.eheartcare.docdemo.docdemo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.eheartcare.docdemo.docdemo.ui.fragment.FragmentFactory;

/**
 * Created by Administrator on 2016/3/16 0016.
 */
public class VpHomeAdapter extends FragmentPagerAdapter {

    public VpHomeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getFragment(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
