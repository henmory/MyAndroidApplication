package com.henmory.mvptest.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.henmory.mvptest.R;
import com.henmory.mvptest.presenter.*;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, ILoginView, ILoginView.ILoginViewListener {
    private final String tag = "LoginActivity";

    private EditText etPhoneNumber;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnReigster;
    private TextView tvForgetPassword;
    private AccountPresenter accountPresenter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountPresenter = new AccountPresenter(this);
        bindView();

    }

    void bindView() {
        etPhoneNumber = (EditText) findViewById(R.id.et_phone_number);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReigster = (Button) findViewById(R.id.btn_register);
        tvForgetPassword = (TextView) findViewById(R.id.tv_forget_password);
        btnLogin.setOnClickListener(this);
        btnReigster.setOnClickListener(this);
        tvForgetPassword.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_register:
                toRegisterActivity();
                break;
            case R.id.tv_forget_password:
                toForgetPasswordActivity();
        }
    }



    /**
     * @param
     * @return
     * @author henmory
     * @date 11/19/16
     * @description 点击注册按钮，逻辑处理
     */
    void toRegisterActivity() {
        /*
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        */
        //new version:
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * @param
     * @return
     * @author henmory
     * @date 11/21/16
     * @description 忘记密码处理逻辑
     */

    void toForgetPasswordActivity() {

    }

    public void login() {
        if (null == etPhoneNumber.getText() || null == etPassword.getText()) {
            Toast.makeText(LoginActivity.this, "输入错误", Toast.LENGTH_SHORT).show();
        } else

        {
            accountPresenter.login(etPhoneNumber.getText().toString(), etPassword.getText().toString());
        }
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {

    }

    @Override
    public void showProgress() {
        progressDialog.setTitle("login......");
    }

    @Override
    public void shutProgress() {

    }

    @Override
    public void backLoginview() {

    }
}
