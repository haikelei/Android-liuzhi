package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.ui.adapter.CartAdapter;
import com.hykj.liuzhi.androidcomponents.ui.widget.DefaultTopBar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lujialei
 * @date: 2018/10/16
 * @describe:
 */


public class CartActivity extends BaseActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(1);
        }
        CartAdapter adapter = new CartAdapter(list);
        rv.setAdapter(adapter);
    }

    @Override
    protected View onCreateTopBar(ViewGroup view) {
        DefaultTopBar topBar = new DefaultTopBar(this, "购物车", true);
        return topBar;
    }
}
