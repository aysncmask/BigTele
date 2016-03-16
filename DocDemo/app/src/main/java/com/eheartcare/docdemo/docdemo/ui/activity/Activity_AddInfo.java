package com.eheartcare.docdemo.docdemo.ui.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.eheartcare.docdemo.docdemo.R;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Activity_AddInfo extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener, DatePickerDialog.OnDateSetListener {

    @Bind(R.id.tv_addinfo_personalInfo)
    TextView tvAddinfoPersonalInfo;
    @Bind(R.id.tv_addinfo_back)
    TextView tvAddinfoBack;
    @Bind(R.id.et_addinfo_selectbirthdate)
    EditText etAddinfoSelectbirthdate;
    Calendar calendar;
    @Bind(R.id.bt_addinfo_next)
    Button btAddinfoNext;
    @Bind(R.id.et_addinfo_location)
    EditText etAddinfoLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }

    private void initView() {
        setContentView(R.layout.activity_add_info);
        calendar = Calendar.getInstance();
        ButterKnife.bind(this);
        initListener();
        makeTitleBold();

    }

    private void initListener() {
        tvAddinfoBack.setOnClickListener(this);
        etAddinfoSelectbirthdate.setOnFocusChangeListener(this);
        btAddinfoNext.setOnClickListener(this);
        etAddinfoLocation.setOnClickListener(this);

    }

    private void makeTitleBold() {
        TextPaint paint = tvAddinfoPersonalInfo.getPaint();
        paint.setFakeBoldText(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_addinfo_back:
                skipBack();
                break;
            case R.id.bt_addinfo_next:
                skipNext();
                break;
            case R.id.et_addinfo_location:


                break;

        }
    }

    private void skipNext() {
        if (
                //verifyBirthDate() && verifyName() && verifyLocation() && verifySex() && verifyEmail()
                true
                ) {
            Intent intent = new Intent(Activity_AddInfo.this, Activity_AddInfo1.class);
            startActivity(intent);
        }else{
            //// TODO: 2016/3/15 0015

        }
    }

    private void showDatePickerDialog() {

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                Activity_AddInfo.this, Activity_AddInfo.this, calendar
                .get(Calendar.YEAR), calendar
                .get(Calendar.MONTH), calendar
                .get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    private void skipBack() {
        Intent intent = new Intent(Activity_AddInfo.this, Activity_Register.class);
        startActivity(intent);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == R.id.et_addinfo_selectbirthdate) {
            if (hasFocus) {
                showDatePickerDialog();
            }
        }

    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, monthOfYear);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String str = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
        System.out.println("set is " + str);

        if (etAddinfoSelectbirthdate.isFocused()) {
            etAddinfoSelectbirthdate.setText(str);
        }

    }

    public boolean verifyName() {
        //// TODO: 2016/3/15 0015

        return true;
    }

    public boolean verifySex() {
        //// TODO: 2016/3/15 0015

        return true;
    }

    public boolean verifyBirthDate() {
        //// TODO: 2016/3/15 0015

        return true;
    }

    public boolean verifyLocation() {
        //// TODO: 2016/3/15 0015

        return true;
    }

    public boolean verifyEmail() {
        //// TODO: 2016/3/15 0015

        return true;
    }
}
