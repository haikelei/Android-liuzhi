package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
    @BindView(R.id.ll_mine_bindemail_wait)
    LinearLayout llMineBindemailWait;
    @BindView(R.id.rl_mine_bindemail_input)
    RelativeLayout rlMineBindemailInput;
    @BindView(R.id.tv_mine_bindemail_descrip)
    TextView tvMineBindemailDescrip;

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
                Toast.makeText(BindEmailActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                rlMineBindemailInput.setVisibility(View.GONE);
                tvMineBindemailDescrip.setVisibility(View.GONE);
                llMineBindemailWait.setVisibility(View.VISIBLE);
                break;
        }
    }
}
