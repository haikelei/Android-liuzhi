package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hykj.liuzhi.R;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_login_forgetpassword, R.id.tv_login_dongcode2login})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.tv_login_forgetpassword:
                intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                break;
            case R.id.tv_login_dongcode2login:
                intent = new Intent(LoginActivity.this, DongStateCodeActivity.class);
                break;
        }
        startActivity(intent);
    }
}
