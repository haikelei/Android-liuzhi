package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hykj.liuzhi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeNameActivity extends BaseActivity {
    @BindView(R.id.tv_changename_back)
    ImageView tvChangenameBack;
    @BindView(R.id.tv_changename_title)
    TextView tvChangenameTitle;
    @BindView(R.id.tv_changename_complete)
    TextView tvChangenameComplete;
    private int mPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changename);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        Intent intent = getIntent();
        mPosition = intent.getIntExtra("position", 0);


    }

    private void initData() {
        if (mPosition == 1) {
            tvChangenameTitle.setText("修改昵称");


        } else if (mPosition == 2) {
            tvChangenameTitle.setText("修改个性签名");

        }
    }

    @OnClick({R.id.tv_changename_back, R.id.tv_changename_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_changename_back:
                finish();
                break;
            case R.id.tv_changename_complete:
                break;
        }
    }
}
