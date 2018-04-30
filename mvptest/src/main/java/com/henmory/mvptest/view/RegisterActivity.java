package com.henmory.mvptest.view;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.henmory.mvptest.R;
import com.henmory.mvptest.presenter.AccountPresenter;


/**
 * 该注册界面是与设备绑定无关的，注册成功后，没有任何绑定设备，只是在后台有个空账号而已
 */
public class RegisterActivity extends AppCompatActivity implements IRegisterView, IRegisterView.IRegisterViewListener{

    private final static String tag = "RegisterActivity";
    private EditText evPhoneNumber;
    private EditText evCode;
    private EditText evPassword;
    private EditText evConfirmPassword;
    private Button btnRegister;
    private Button btnGetCode;



    String num;//phone number
    String code; // verification code
    String password; // password that user inputs
    String confirmPassword; //password that user inputs to verify
    private String graphicCode = "";

    private AccountPresenter accountPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        accountPresenter = new AccountPresenter(this);
        bindViews();
        bindEvents();
        initVerificationRequest();



    }

    private void bindViews() {
        evPhoneNumber = (EditText) findViewById(R.id.et_phone_number);
        evCode = (EditText) findViewById(R.id.et_sms_code);
        evPassword = (EditText) findViewById(R.id.et_password);
        evConfirmPassword = (EditText) findViewById(R.id.et_confirm_password);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnGetCode = (Button) findViewById(R.id.btn_get_code);
    }

    private void bindEvents() {
        btnGetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSMSCode();

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerAccount();
            }
        });
    }

    private void registerAccount() {
        accountPresenter.register(num, password, code);
    }

    private void getSMSCode() {

        accountPresenter.getSmsCode(num);
    }


    private void initVerificationRequest() {

        accountPresenter.initVerificationRequest();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void shutProgress() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {

    }


    //复写倒计时
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            btnGetCode.setClickable(false);
            btnGetCode.setText(l / 1000 + "s");

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给Button设置文字
            btnGetCode.setText("重新获取验证码");
            //设置可点击
            btnGetCode.setClickable(true);
        }
    }

}
