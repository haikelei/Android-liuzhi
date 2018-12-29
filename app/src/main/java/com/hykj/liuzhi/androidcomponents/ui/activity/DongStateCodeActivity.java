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
import com.hykj.liuzhi.androidcomponents.bean.LoginEntity;
import com.hykj.liuzhi.androidcomponents.bean.UserInfo;
import com.hykj.liuzhi.androidcomponents.net.http.HttpHelper;
import com.hykj.liuzhi.androidcomponents.utils.ACache;
import com.hykj.liuzhi.androidcomponents.utils.ErrorStateCodeUtils;
import com.hykj.liuzhi.androidcomponents.utils.FastJSONHelper;
import com.hykj.liuzhi.androidcomponents.utils.LocalInfoUtils;
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
    private String mLoginPhone;
    private String mLoginCode;

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

    @OnClick({R.id.tv_dongtailogin_login, R.id.tv_dongtailogin_pass2login, R.id.tv_dongtailogin_forgetpassword, R.id.tv_dongtailogin_toregist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_dongtailogin_login:
                UserLogin();
                break;
            case R.id.tv_dongtailogin_forgetpassword:
                startActivity(new Intent(DongStateCodeActivity.this, ForgetPasswordActivity.class));
                break;
            case R.id.tv_dongtailogin_pass2login:
                startActivity(new Intent(DongStateCodeActivity.this, LoginActivity.class));
                break;
            case R.id.tv_dongtailogin_toregist:
                startActivity(new Intent(DongStateCodeActivity.this, RegistActivity.class));
                break;
        }
    }

    ACache aCache;

    private void UserLogin() {
        aCache = ACache.get(this);
        mLoginPhone = etDongtailoginPhone.getText().toString().trim();
        mLoginCode = etDongtailoginAuthcode.getText().toString().trim();
        if (TextUtils.isEmpty(mLoginPhone) || TextUtils.isEmpty(mLoginCode)) {
            Toast.makeText(this, "账号验证码不能为空", Toast.LENGTH_SHORT).show();
        } else {
            HttpHelper.login(mLoginPhone, mLoginCode, new HttpHelper.HttpUtilsCallBack<String>() {
                @Override
                public void onFailure(String failure) {
                    Toast.makeText(DongStateCodeActivity.this, failure, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSucceed(String succeed) {
                    LoginEntity entity = FastJSONHelper.getPerson(succeed, LoginEntity.class);
                    if (entity != null) {
                        UserInfo userInfo = LocalInfoUtils.getUserInfo();
                        LocalInfoUtils.saveUserInfo(mLoginPhone, mLoginCode, userInfo.getPassword());
                        aCache.put("user_id", String.valueOf(entity.getUserdata().getUser_id()));
                        getUserself(entity.getUserdata().getUser_id());
                    }
                }

                @Override
                public void onError(String error) {
                    Toast.makeText(DongStateCodeActivity.this, ErrorStateCodeUtils.getRegisterErrorMessage(error), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    //获取用户数据
    public void getUserself(int user_id) {
        HttpHelper.getUserself(user_id, new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                Toast.makeText(DongStateCodeActivity.this, failure, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSucceed(String succeed) {
                LocalInfoUtils.saveUserself(succeed);
                startActivity(new Intent(DongStateCodeActivity.this, MainActivity.class));
            }

            @Override
            public void onError(String error) {
                Toast.makeText(DongStateCodeActivity.this, ErrorStateCodeUtils.getRegisterErrorMessage(error), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
