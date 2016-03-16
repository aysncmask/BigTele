package com.eheartcare.docdemo.docdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.eheartcare.docdemo.docdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Activity_AddContractor extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.bt_addcontractor_comple)
    Button btAddcontractorComple;
    @Bind(R.id.tv_addcontractor_back)
    TextView tvAddcontractorBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        makeTextBold();
    }

    private void makeTextBold() {

    }

    private void initListener() {
        btAddcontractorComple.setOnClickListener(this);
        tvAddcontractorBack.setOnClickListener(this);
    }

    private void initView() {
        setContentView(R.layout.activity_add_contractor);
        ButterKnife.bind(this);
    }

    private void skipBack() {
        Intent intent = new Intent(Activity_AddContractor.this, Activity_AddInfo1.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_addcontractor_comple:
                if (verifyInfo()) {
                    skip2Home();
                }
                break;
            case R.id.tv_addcontractor_back:
                skipBack();
                break;

        }
    }

    private boolean verifyInfo() {
        if (uploadInfo2Server() && verifyPhoneNumber()) {
            return true;
        }

        return false;
    }

    private boolean uploadInfo2Server() {
        //// TODO: 2016/3/16 0016


        return true;
    }

    private boolean verifyName() {
        //// TODO: 2016/3/16 0016


        return true;
    }

    private boolean verifyPhoneNumber() {
        //// TODO: 2016/3/16 0016


        return true;
    }


    private void skip2Home() {
        Intent intent = new Intent(Activity_AddContractor.this, Activity_Home.class);
        startActivity(intent);
    }

}
