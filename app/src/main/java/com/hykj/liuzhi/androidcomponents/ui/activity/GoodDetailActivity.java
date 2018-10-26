package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.ui.adapter.DetailCommentAdapter;
import com.hykj.liuzhi.androidcomponents.ui.widget.GoodsDetailHeader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lujialei
 * @date: 2018/10/25
 * @describe:
 */


public class GoodDetailActivity extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tv_buy)
    TextView tvBuy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initListener() {
        tvBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ConfirmOrderActivity.class));
            }
        });
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        ArrayList list = new ArrayList();
        DetailCommentAdapter adapter = new DetailCommentAdapter(list);
        adapter.addHeaderView(new GoodsDetailHeader(getBaseContext()));
        recyclerView.setAdapter(adapter);
    }
}
