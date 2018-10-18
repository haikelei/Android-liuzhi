package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

public class AddAdressActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addaddress);
        initView();
    }

    private void initView() {
        new TitleBuilder(AddAdressActivity.this).setTitleText("新增收货地址").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
