package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.LoginRecordBean;
import com.hykj.liuzhi.androidcomponents.ui.adapter.LoginRecordAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginRecordActivity extends BaseActivity {
    @BindView(R.id.recycler_login_record)
    RecyclerView recyclerLoginRecord;
    @BindView(R.id.iv_loginrecord_back)
    ImageView ivLoginrecordBack;
    private List<LoginRecordBean> mBeanList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginrecord);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerLoginRecord.setLayoutManager(layoutManager);

    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
            LoginRecordBean loginRecordBean = new LoginRecordBean();
            loginRecordBean.setLogintime("2018年10月20日");
            loginRecordBean.setLoginadress("杭州西湖区登录");
            mBeanList.add(loginRecordBean);
            LoginRecordAdapter loginRecordAdapter = new LoginRecordAdapter(R.layout.item_login_record, mBeanList);
            recyclerLoginRecord.setAdapter(loginRecordAdapter);

        }


    }


    @OnClick(R.id.iv_loginrecord_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_loginrecord_back:
                finish();


                break;
        }

    }
}
