package com.hykj.liuzhi.androidcomponents.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.GoodDetailBean;
import com.hykj.liuzhi.androidcomponents.interfaces.GlideImageLoader;
import com.hykj.liuzhi.androidcomponents.ui.activity.CartActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.GoodDetailActivity;
import com.hykj.liuzhi.androidcomponents.ui.adapter.GoodsAdapter;
import com.hykj.liuzhi.androidcomponents.ui.widget.BannerHeader;
import com.hykj.liuzhi.androidcomponents.ui.widget.MoreGoodsHeader;
import com.youth.banner.Banner;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author: lujialei
 * @date: 2018/9/27
 * @describe:
 */


public class ShopFragment extends Fragment {

    @BindView(R.id.search_area)
    RelativeLayout searchArea;
    @BindView(R.id.iv_cart)
    ImageView ivCart;
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    GoodsAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(new GoodDetailBean());
        }
        mAdapter = new GoodsAdapter(list);
        BannerHeader bannerHeader = new BannerHeader(getContext());
        Banner banner = bannerHeader.getBanner();
        ArrayList pics = new ArrayList();
        pics.add(R.mipmap.test1);
        pics.add(R.mipmap.test2);
        banner.setImages(pics);
        banner.setImageLoader(new GlideImageLoader())
                .setDelayTime(5000)
                .start();
        mAdapter.addHeaderView(bannerHeader);
        mAdapter.addHeaderView(new MoreGoodsHeader(getContext()));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getContext(), GoodDetailActivity.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_cart, R.id.rl_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_cart:
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_search:
                break;
        }
    }
}
