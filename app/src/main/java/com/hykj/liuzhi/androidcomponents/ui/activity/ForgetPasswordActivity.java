package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.net.http.HttpHelper;
import com.hykj.liuzhi.androidcomponents.utils.ErrorStateCodeUtils;
import com.hykj.liuzhi.androidcomponents.utils.LocalInfoUtils;

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
                requestData();
                break;
        }
    }

    private void requestData() {
        if (TextUtils.isEmpty(etForgetpasswordPhone.getText().toString().trim())){
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etForgetpasswordAuthcode.getText().toString().trim())){
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(etForgetpasswordPassword.getText().toString().trim())){
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
//        if (etRegistPassword.getText().toString().trim().length() < 6){
//            Toast.makeText(this, "密码至少6位字符", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        HttpHelper.register(etRegistPhone.getText().toString().trim(), etRegistAuthcode.getText().toString().trim(), etRegistPassword.getText().toString().trim(), new HttpHelper.HttpUtilsCallBack<String>() {
//            @Override
//            public void onFailure(String failure) {
//                Toast.makeText(RegistActivity.this,failure, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onSucceed(String succeed) {
//                Toast.makeText(RegistActivity.this,"注册成功", Toast.LENGTH_SHORT).show();
//                LocalInfoUtils.saveUserInfo(etRegistPhone.getText().toString().trim(), etRegistAuthcode.getText().toString().trim(),etRegistPassword.getText().toString().trim());
//                finish();
//            }
//
//            @Override
//            public void onError(String error) {
//                Toast.makeText(RegistActivity.this, ErrorStateCodeUtils.getRegisterErrorMessage(error), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
