package com.eheartcare.docdemo.docdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eheartcare.docdemo.docdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Activity_Register extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {


    @Bind(R.id.bt_reg_register)
    Button btRegRegister;
    @Bind(R.id.et_reg_phone)
    EditText etRegPhone;

    public Activity_Register(){
        
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initSDK();
        initView();

    }

    private void initSDK() {
        //// TODO: 2016/3/16 0016
    }

    private void initView() {
        btRegRegister.setOnClickListener(this);
        etRegPhone.setOnFocusChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_reg_register:

                skip2Activity();

                break;
        }
    }

    private void skip2Activity() {
        if(// verifyInputNumber()&&verifyInputCode()&&verifyInputPWD()
                true
                ){
            Intent intent = new Intent(Activity_Register.this, Activity_AddInfo.class);
            Activity_Register.this.startActivity(intent);
            Log.e("test", "skip");
        }
        else {
            Toast.makeText(Activity_Register.this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){
            return;
        }else{
            verifyInputNumber();
        }
    }

    private boolean verifyInputNumber() {

        String typePhoneNumer = etRegPhone.getText().toString().trim();
        boolean matches = typePhoneNumer.matches("^[1][358][0-9]{9}$");
        Log.e("test",matches+"");
//        if(matches)
//        {
//            return matches;
//        }else
//        {
//            Toast.makeText(Activity_Register.this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
//        }

        return matches;
    }
    private boolean verifyInputCode() {
        //// TODO: 2016/3/15 0015 网络验证

      //  String typePhoneNumer = etRegPhone.getText().toString().trim();
    //    boolean matches = typePhoneNumer.matches("^[1][358][0-9]{9}$");
 //       Log.e("test",matches+"");
//        if(matches)
//        {
//            return matches;
//        }else
//        {
//            Toast.makeText(Activity_Register.this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
//        }

        return true;
    }
    private boolean verifyInputPWD() {
        //// TODO: 2016/3/15 0015 密码验证

        //  String typePhoneNumer = etRegPhone.getText().toString().trim();
        //    boolean matches = typePhoneNumer.matches("^[1][358][0-9]{9}$");
        //       Log.e("test",matches+"");
//        if(matches)
//        {
//            return matches;
//        }else
//        {
//            Toast.makeText(Activity_Register.this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
//        }

        return true;
    }

}
