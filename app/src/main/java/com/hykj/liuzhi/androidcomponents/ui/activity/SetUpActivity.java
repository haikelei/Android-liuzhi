package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetUpActivity extends BaseActivity {
    @BindView(R.id.rl_setup_fans)
    RelativeLayout rlSetupFans;
    @BindView(R.id.rl_setup_follows)
    RelativeLayout rlSetupFollows;
    @BindView(R.id.tv_setup_exitlogin)
    TextView tvSetupExitlogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        initView();
        initData();

        ButterKnife.bind(this);
    }

    private void initData() {

    }

    private void initView() {
        new TitleBuilder(SetUpActivity.this).setTitleText("账户设置").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.rl_setup_fans, R.id.rl_setup_follows, R.id.tv_setup_exitlogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_setup_fans:
                break;
            case R.id.rl_setup_follows:
                break;
            case R.id.tv_setup_exitlogin:
                break;
        }
    }
}
