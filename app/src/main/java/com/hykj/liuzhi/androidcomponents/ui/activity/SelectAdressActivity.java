package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

public class SelectAdressActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_adress);
        initView();
    }

    private void initView() {
        new TitleBuilder(SelectAdressActivity.this).setTitleText("选择收货地址").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }).setRightIco(R.mipmap.add_address).setRightIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAdressActivity.this, AddAdressActivity.class);
                startActivity(intent);
            }
        });
    }
}
