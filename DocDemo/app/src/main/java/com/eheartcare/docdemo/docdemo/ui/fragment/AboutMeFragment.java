package com.eheartcare.docdemo.docdemo.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eheartcare.docdemo.docdemo.R;

/**
 * Created by Administrator on 2016/3/16 0016.
 */
public class AboutMeFragment extends android.support.v4.app.Fragment {

    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = View.inflate(container.getContext(), R.layout.fragment_aboutme, null);


        return mRootView;
    }
}
