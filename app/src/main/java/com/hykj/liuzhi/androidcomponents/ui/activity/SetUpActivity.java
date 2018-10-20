package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
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
    @BindView(R.id.rl_mine_setup_bindemail)
    RelativeLayout rlMineSetupBindemail;
    @BindView(R.id.rl_mine_setup_takeaddress)
    RelativeLayout rlMineSetupTakeaddress;
    @BindView(R.id.rl_mine_setup_change_pass)
    RelativeLayout rlMineSetupChangePass;
    @BindView(R.id.rl_mine_setup_realname_auth)
    RelativeLayout rlMineSetupRealnameAuth;
    @BindView(R.id.rl_mine_setup_login_record)
    RelativeLayout rlMineSetupLoginRecord;
    @BindView(R.id.rl_mine_setup_suggest)
    RelativeLayout rlMineSetupSuggest;

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

    @OnClick({R.id.rl_setup_fans, R.id.rl_setup_follows, R.id.tv_setup_exitlogin, R.id.rl_mine_setup_bindemail, R.id.rl_mine_setup_takeaddress,
            R.id.rl_mine_setup_change_pass, R.id.rl_mine_setup_realname_auth, R.id.rl_mine_setup_login_record, R.id.rl_mine_setup_suggest})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rl_setup_fans:
                break;
            case R.id.rl_setup_follows:
                break;
            case R.id.tv_setup_exitlogin:
                break;
            case R.id.rl_mine_setup_takeaddress:
                intent = new Intent(SetUpActivity.this, SelectAdressActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_mine_setup_bindemail:
                intent = new Intent(SetUpActivity.this, BindEmailActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_mine_setup_change_pass:
                intent = new Intent(SetUpActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                break;

            case R.id.rl_mine_setup_realname_auth:
                intent = new Intent(SetUpActivity.this, TrueNameIdenActivity.class);
                startActivity(intent);

                break;
            case R.id.rl_mine_setup_login_record:
                intent = new Intent(SetUpActivity.this, LoginRecordActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_mine_setup_suggest:
                intent = new Intent(SetUpActivity.this, SuggestActivity.class);
                startActivity(intent);
                break;
        }
    }
}
