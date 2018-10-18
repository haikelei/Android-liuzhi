package com.hykj.liuzhi.androidcomponents.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.hykj.liuzhi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lujialei
 * @date: 2018/10/18
 * @describe:
 */


public class HeaderCircleScroll extends RelativeLayout {

    @BindView(R.id.iv0)
    ImageView iv0;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;

    public HeaderCircleScroll(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View root = LayoutInflater.from(context).inflate(R.layout.layout_header_circle_horizon_scroll, this, true);
        ButterKnife.bind(this);

//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.circleCrop();
//        Glide.with(context)
//                .load(R.mipmap.ic_launcher)
//                .apply(requestOptions)
//                .into(iv0);

        Glide.with(this).load(R.mipmap.test1).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv0);
        Glide.with(this).load(R.mipmap.test2).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv1);
        Glide.with(this).load(R.mipmap.test3).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv2);

    }
}
