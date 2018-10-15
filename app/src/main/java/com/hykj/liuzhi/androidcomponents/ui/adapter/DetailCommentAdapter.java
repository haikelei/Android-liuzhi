package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.DetailCommentBean;
import com.hykj.liuzhi.androidcomponents.bean.UserMessageBean;

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
    protected void convert(BaseViewHolder helper, DetailCommentBean item) {

    }
}
