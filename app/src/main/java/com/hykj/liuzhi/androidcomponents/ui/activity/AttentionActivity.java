package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.ui.adapter.AttentionAdapter;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttentionActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ArrayList<String> list;
    private AttentionAdapter mAdapter;
    private String type;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention);
        ButterKnife.bind(this);
        iniData();
        initView();
        initListener();


    }

    private void initListener() {

    }

    private void iniData() {
        type = getIntent().getStringExtra("type");
        if ("0".equals(type)){
            title = "关注";
        }else {
            title = "粉丝";
        }
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("女子无才便是德，原来我已缺德了18年" + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AttentionAdapter(this, list);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent=new Intent(AttentionActivity.this, PersonDetailActivity.class);
                startActivity(intent);
            }
        });
//        mAdapter.setEmptyView(initEmptyView());
        recyclerView.setAdapter(mAdapter);
    }

    private void initView() {
        new TitleBuilder(AttentionActivity.this).setTitleText(title).setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

