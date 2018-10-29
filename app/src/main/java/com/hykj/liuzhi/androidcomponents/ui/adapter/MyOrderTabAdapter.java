package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;

import java.util.List;

/**
 * @author: lujialei
 * @date: 2018/10/27
 * @describe:
 */


public class MyOrderTabAdapter extends BaseQuickAdapter<Object,BaseViewHolder> {
    public MyOrderTabAdapter(@Nullable List<Object> data) {
        super(R.layout.layout_item_my_order_tab,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {

    }
}
