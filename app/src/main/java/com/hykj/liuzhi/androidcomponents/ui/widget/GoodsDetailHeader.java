package com.hykj.liuzhi.androidcomponents.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.interfaces.GlideImageLoader;
import com.hykj.liuzhi.androidcomponents.mock.Mock;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lujialei
 * @date: 2018/10/25
 * @describe:
 */


public class GoodsDetailHeader extends LinearLayout {

    @BindView(R.id.banner)
    Banner banner;

    public GoodsDetailHeader(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_header_goods_detail_item, this, true);
        ButterKnife.bind(this);
        banner.setImages(Mock.getBannerList());
        banner.setImageLoader(new GlideImageLoader())
                .setDelayTime(5000)
                .start();
    }
}
