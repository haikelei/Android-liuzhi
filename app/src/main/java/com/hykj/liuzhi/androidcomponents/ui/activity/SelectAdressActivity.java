package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.ui.adapter.SelectAdressListAdapter;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAdressActivity extends BaseActivity {
    @BindView(R.id.recycler_select_adress)
    RecyclerView recyclerSelectAdress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_adress);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    /*填充数据*/
    private void initData() {
        recyclerSelectAdress.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList AddressList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            AddressList.add(i);
        }
        SelectAdressListAdapter adapter = new SelectAdressListAdapter(AddressList);
        recyclerSelectAdress.setAdapter(adapter);
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
