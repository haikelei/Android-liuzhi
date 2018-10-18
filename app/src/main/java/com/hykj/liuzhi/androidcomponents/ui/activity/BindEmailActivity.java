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

public class BindEmailActivity extends BaseActivity {
    @BindView(R.id.iv_bindemail_back)
    ImageView ivBindemailBack;
    @BindView(R.id.iv_bindemail_save)
    TextView ivBindemailSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bindemail);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_bindemail_back, R.id.iv_bindemail_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_bindemail_back:
                finish();
                break;
            case R.id.iv_bindemail_save:
                Toast.makeText(BindEmailActivity.this, "保存", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
