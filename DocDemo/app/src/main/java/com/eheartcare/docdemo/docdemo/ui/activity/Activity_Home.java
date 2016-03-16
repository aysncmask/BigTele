package com.eheartcare.docdemo.docdemo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.eheartcare.docdemo.docdemo.R;
import com.eheartcare.docdemo.docdemo.ui.adapter.VpHomeAdapter;
import com.eheartcare.docdemo.docdemo.ui.widget.NoScroolViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/3/15 0015.
 */
public class Activity_Home extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.vp_home)
    NoScroolViewPager vpHome;
    @Bind(R.id.rb_home_home)
    RadioButton rbHomeHome;
    @Bind(R.id.rb_home_record)
    RadioButton rbHomeRecord;
    @Bind(R.id.rb_home_message)
    RadioButton rbHomeMessage;
    @Bind(R.id.rb_home_aboutme)
    RadioButton rbHomeAboutme;
    @Bind(R.id.rg_home)
    RadioGroup rgHome;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initViewPager();
        initListener();
    }

    private void initListener() {
        rgHome.setOnCheckedChangeListener(this);
    }

    private void initView() {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

    }

    private void initViewPager() {
        vpHome.setAdapter(new VpHomeAdapter(getSupportFragmentManager()));
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home_home:
                vpHome.setCurrentItem(0,false);

                break;
            case R.id.rb_home_record:
                vpHome.setCurrentItem(1,false);

                break;
            case R.id.rb_home_message:
                vpHome.setCurrentItem(2,false);

                break;
            case R.id.rb_home_aboutme:
                vpHome.setCurrentItem(3,false);

                break;


        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
