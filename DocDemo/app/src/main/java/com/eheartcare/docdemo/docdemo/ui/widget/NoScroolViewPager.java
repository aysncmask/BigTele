package com.eheartcare.docdemo.docdemo.ui.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/3/16 0016.
 */
public class NoScroolViewPager extends ViewPager {
    public NoScroolViewPager(Context context) {
        super(context);
    }

    public NoScroolViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;//滑动效果去除
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;// 不拦截子控件的事件
    }
}
