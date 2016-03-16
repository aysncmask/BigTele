package com.eheartcare.docdemo.docdemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eheartcare.docdemo.docdemo.R;
import com.eheartcare.docdemo.docdemo.ui.widget.WheelView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Activity_AddInfo1 extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {
    ArrayList<String> mBloodTypeList;
    @Bind(R.id.cardview_addinfo1)
    CardView cardviewAddinfo1;
    @Bind(R.id.et_addinfo_bloodtype)
    EditText etAddinfoBloodtype;
    @Bind(R.id.tv_addinfo_back)
    TextView tvAddinfoBack;
    @Bind(R.id.wheel_bloodtype)
    WheelView wheelBloodtype;
    @Bind(R.id.ll_addinfowheel)
    LinearLayout llAddinfowheel;
    @Bind(R.id.bt_addinfo_bloodtype_commit)
    Button btAddinfoBloodtypeCommit;
    @Bind(R.id.bt_addinfo1_next)
    Button btAddinfo1Next;
    private InputMethodManager im;

    public Activity_AddInfo1() {
        mBloodTypeList = new ArrayList<>();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

    }

    private void initView() {
        setContentView(R.layout.activity_add_info1);
        ButterKnife.bind(this);
        initListener();
        initWheelView();
        etAddinfoBloodtype.setInputType(InputType.TYPE_NULL);

    }

    private void initWheelView() {
        mBloodTypeList = new ArrayList<>();
        mBloodTypeList.add("A型血");
        mBloodTypeList.add("AB型血");
        mBloodTypeList.add("B型血");
        mBloodTypeList.add("O型血");
        wheelBloodtype.setOffset(1);
        wheelBloodtype.setItems(mBloodTypeList);


    }

    private void initListener() {
        tvAddinfoBack.setOnClickListener(this);
        etAddinfoBloodtype.setOnFocusChangeListener(this);
        btAddinfoBloodtypeCommit.setOnClickListener(this);
        etAddinfoBloodtype.setOnClickListener(this);
        btAddinfo1Next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_addinfo_back:
                skipBack();
                break;
            case R.id.et_addinfo_bloodtype:
                pickerOpen();
                Log.e("test", "click");
                break;
            case R.id.bt_addinfo_bloodtype_commit:
                pickerShrink();

                break;
            case R.id.bt_addinfo1_next:
                skipNext();
                break;
        }
    }

    private void skipBack() {

        Intent intent = new Intent(Activity_AddInfo1.this, Activity_AddInfo.class);
        startActivity(intent);

    }

    private void skipNext() {
        //// TODO: 2016/3/16 0016
        if (true) {
            Intent intent = new Intent(Activity_AddInfo1.this, Activity_AddContractor.class);
            startActivity(intent);
        } else {


        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            pickerOpen();
            Log.e("test", "open");
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(etAddinfoBloodtype, InputMethodManager.SHOW_FORCED);
            imm.hideSoftInputFromWindow(etAddinfoBloodtype.getWindowToken(), 0); //强制隐藏键盘

        } else {
            pickerShrink();
            wheelBloodtype.setFocusable(true);
            Log.e("test", "shrink");
        }
    }

    private void pickerOpen() {
        Log.e("test", "change");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        params.height = params.MATCH_PARENT;
        cardviewAddinfo1.setLayoutParams(params);
        wheelBloodtype.setSeletion(2);
        llAddinfowheel.setVisibility(View.VISIBLE);
    }

    private void pickerShrink() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
        params.height = 280 * 2;
        cardviewAddinfo1.setLayoutParams(params);
        llAddinfowheel.setVisibility(View.GONE);
    }

//    private void hideIM(View edt) {
//        IBinder windowToken = null;
//        try {
//            im = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
//            windowToken = edt.getWindowToken();
//        } catch (Exception e) {
//            if (windowToken != null) {
//                im.hideSoftInputFromWindow(windowToken, 0);
//            }
//        }
//    }


}
