package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.library.AutoFlowLayout;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.DetailMoreVideoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lujialei
 * @date: 2018/10/15
 * @describe:
 */


public class DetailMoreVideoAdapter extends BaseQuickAdapter<DetailMoreVideoBean,BaseViewHolder> {
    public DetailMoreVideoAdapter(@Nullable List<DetailMoreVideoBean> data) {
        super(R.layout.layout_item_detail_more_video,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DetailMoreVideoBean item) {
        AutoFlowLayout flowLayout = helper.getView(R.id.flow_layout);
        flowLayout.setMaxLines(1);
        List<View> viewList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            View view = LayoutInflater.from(helper.itemView.getContext()).inflate(R.layout.layout_tag_detail_video,null);
            viewList.add(view);
        }
        flowLayout.setAllViews(viewList);
    }
}
