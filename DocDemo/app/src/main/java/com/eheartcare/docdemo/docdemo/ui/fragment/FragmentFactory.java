package com.eheartcare.docdemo.docdemo.ui.fragment;

import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zlr on 2014/7/19.
 */
public class FragmentFactory {
    public static final int TAB_HOME = 0;
    public static final int TAB_RECORD = 1;
    public static final int TAB_MESSAGE = 2;
    public static final int TAB_ME = 3;

    private static Map<Integer, Fragment> mFragmentCache = new HashMap<Integer, Fragment>();

    public static Fragment getFragment(int position) {
        Fragment fragment = mFragmentCache.get(position);
        if (fragment != null) {
            return fragment;

        }
        switch (position) {
            case TAB_HOME:
                fragment = new HomeFragment();
                break;
            case TAB_RECORD:
                fragment = new RecordFragment();
                break;
            case TAB_MESSAGE:
                fragment = new MessageFragment();
                break;
            case TAB_ME:
                fragment = new AboutMeFragment();
                break;
        }
        mFragmentCache.put(position, fragment);
        return fragment;
    }
}
