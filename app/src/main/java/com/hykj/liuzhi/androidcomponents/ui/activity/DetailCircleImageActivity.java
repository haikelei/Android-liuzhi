package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.flyco.tablayout.SlidingTabLayout;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.interfaces.GlideImageLoader;
import com.hykj.liuzhi.androidcomponents.mock.Mock;
import com.hykj.liuzhi.androidcomponents.ui.adapter.DetailCircleAdapter;
import com.hykj.liuzhi.androidcomponents.ui.widget.DefaultTopBar;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: lujialei
 * @date: 2018/10/18
 * @describe:
 */


public class DetailCircleImageActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    SlidingTabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.iv_avatar)
    ImageView ivAvatar;
    @BindView(R.id.ll_collect)
    LinearLayout llCollect;
    @BindView(R.id.ll_detail_circle_tougao)
    LinearLayout llDetailCircleTougao;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_circle);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Glide.with(this).load(R.mipmap.test1).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(ivAvatar);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner.setImages(Mock.getBannerList());
        banner.setImageLoader(new GlideImageLoader())
                .setDelayTime(5000)
                .start();


        viewPager.setAdapter(new DetailCircleAdapter(getSupportFragmentManager()));
        tabLayout.setViewPager(viewPager);
    }


    @Override
    protected View onCreateTopBar(ViewGroup view) {
        DefaultTopBar topBar = new DefaultTopBar(this, "详情", true);
        return topBar;
    }

    @OnClick({R.id.ll_collect, R.id.ll_detail_circle_tougao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_collect:
                break;
            case R.id.ll_detail_circle_tougao:

                Intent intent=new Intent(this,IssueClumnActivity.class);
                intent.putExtra("position",2);
                intent.putExtra("title","我要投稿");
                startActivity(intent);
                break;
        }
    }
}
