package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.DetailCommentBean;
import com.hykj.liuzhi.androidcomponents.ui.adapter.DetailCommentAdapter;
import com.hykj.liuzhi.androidcomponents.ui.widget.DefaultTopBar;
import com.hykj.liuzhi.androidcomponents.ui.widget.SoftDetailHeader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lujialei
 * @date: 2018/10/25
 * @describe:
 */


public class DetailSoftArticleActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_article_detail);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        ArrayList list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add(new DetailCommentBean());
        }
        DetailCommentAdapter detailCommentAdapter = new DetailCommentAdapter(list);
        detailCommentAdapter.addHeaderView(new SoftDetailHeader(getBaseContext()));
        recyclerView.setAdapter(detailCommentAdapter);
    }

    @Override
    protected View onCreateTopBar(ViewGroup view) {
        DefaultTopBar topBar = new DefaultTopBar(this, "详情", true);
        return topBar;
    }
}
