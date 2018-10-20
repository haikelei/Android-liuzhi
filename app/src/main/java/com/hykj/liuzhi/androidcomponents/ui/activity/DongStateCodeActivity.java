package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 2018/10/12.
 */

public class DongStateCodeActivity extends BaseActivity {
    @BindView(R.id.et_dongtailogin_phone)
    EditText etDongtailoginPhone;
    @BindView(R.id.et_dongtailogin_authcode)
    EditText etDongtailoginAuthcode;
    @BindView(R.id.tv_dongtailogin_authcode)
    TextView tvDongtailoginAuthcode;
    @BindView(R.id.tv_dongtailogin_login)
    TextView tvDongtailoginLogin;
    @BindView(R.id.tv_dongtailogin_forgetpassword)
    TextView tvDongtailoginForgetpassword;
    @BindView(R.id.tv_dongtailogin_pass2login)
    TextView tvDongtailoginPass2login;
    @BindView(R.id.tv_dongtailogin_toregist)
    TextView tvDongtailoginToregist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dongstate_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        new TitleBuilder(DongStateCodeActivity.this).setTitleText("登录").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.tv_dongtailogin_pass2login, R.id.tv_dongtailogin_toregist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_dongtailogin_pass2login:
                break;
            case R.id.tv_dongtailogin_toregist:
                break;
        }
    }
}
