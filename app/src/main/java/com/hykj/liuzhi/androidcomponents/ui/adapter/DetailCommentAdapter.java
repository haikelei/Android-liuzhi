package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.DetailCommentBean;
import com.hykj.liuzhi.androidcomponents.bean.UserMessageBean;
import com.hykj.liuzhi.androidcomponents.ui.activity.ReportActivity;

import java.util.List;

/**
 * @author: lujialei
 * @date: 2018/10/15
 * @describe:
 */


public class DetailCommentAdapter extends BaseQuickAdapter<DetailCommentBean,BaseViewHolder> {
    public DetailCommentAdapter(@Nullable List<DetailCommentBean> data) {
        super(R.layout.layout_item_detail_comment,data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, DetailCommentBean item) {
        ImageView avatar = helper.getView(R.id.iv_icon);
        Glide.with(helper.itemView.getContext()).load(R.mipmap.test1).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(avatar);
        ImageView report = helper.getView(R.id.iv_report);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(helper.itemView.getContext(), ReportActivity.class);
                helper.itemView.getContext().startActivity(intent);
            }
        });
    }
}
