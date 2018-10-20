package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hykj.liuzhi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePasswordActivity extends BaseActivity {
    @BindView(R.id.iv_change_password_back)
    ImageView ivChangePasswordBack;
    @BindView(R.id.iv_change_password_changepass)
    TextView ivChangePasswordChangepass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_change_password_back, R.id.iv_change_password_changepass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_change_password_back:
                finish();
                break;
            case R.id.iv_change_password_changepass:
                Toast.makeText(this, "提交修改密码了", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
