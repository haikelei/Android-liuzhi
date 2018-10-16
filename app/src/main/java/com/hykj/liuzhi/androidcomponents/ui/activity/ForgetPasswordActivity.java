package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hykj.liuzhi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 2018/10/12.
 */

public class ForgetPasswordActivity extends BaseActivity {
    @BindView(R.id.et_forgetpassword_phone)
    EditText etForgetpasswordPhone;
    @BindView(R.id.et_forgetpassword_authcode)
    EditText etForgetpasswordAuthcode;
    @BindView(R.id.et_forgetpassword_password)
    EditText etForgetpasswordPassword;
    @BindView(R.id.tv_forgetpassword_resetpass)
    TextView tvForgetpasswordResetpass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_forgetpassword_resetpass})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.tv_forgetpassword_resetpass:
                break;
        }
    }
}
