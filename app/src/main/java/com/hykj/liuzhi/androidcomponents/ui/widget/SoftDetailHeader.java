package com.hykj.liuzhi.androidcomponents.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.hykj.liuzhi.BuildConfig;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.ui.glide.GlideRoundTransform;

import javax.microedition.khronos.opengles.GL;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lujialei
 * @date: 2018/10/25
 * @describe:
 */


public class SoftDetailHeader extends LinearLayout {
    @BindView(R.id.iv1)
    ImageView iv1;

    public SoftDetailHeader(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_header_soft_article_detail, this, true);
        ButterKnife.bind(this);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.transform(new GlideRoundTransform(context,6)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(context).load(R.mipmap.test2).apply(requestOptions).into(iv1);
    }
}
