package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.MainActivity;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 2018/10/12.
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.tv_login_forgetpassword)
    TextView mTvLoginForgetpassword;
    @BindView(R.id.tv_login_dongcode2login)
    TextView mTvLoginDongcode2login;
    @BindView(R.id.tv_login_toregist)
    TextView tvLoginToregist;
    @BindView(R.id.et_login_phone)
    EditText etLoginPhone;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.tv_login_login)
    TextView tvLoginLogin;
    private String mLoginPhone;
    private String mLoginPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        ButterKnife.bind(this);
    }

    private void initView() {
        new TitleBuilder(LoginActivity.this).setTitleText("登录").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.tv_login_forgetpassword, R.id.tv_login_dongcode2login, R.id.tv_login_toregist, R.id.tv_login_login})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_login_forgetpassword:
                intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login_dongcode2login:
                intent = new Intent(LoginActivity.this, DongStateCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login_toregist:
                intent = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_login_login:
                UserLogin();
                break;
        }

    }

    private void UserLogin() {
        mLoginPhone = etLoginPhone.getText().toString().trim();
        mLoginPass = etLoginPassword.getText().toString().trim();
        if (TextUtils.isEmpty(mLoginPhone) || TextUtils.isEmpty(mLoginPass)) {

            Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();

        } else {
            if (mLoginPhone.equals("admin") && mLoginPass.equals("123456")) {
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "账号或者密码不正确", Toast.LENGTH_SHORT).show();

            }
        }


    }


}
