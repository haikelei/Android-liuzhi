package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;

import java.util.List;

/**
 * @author: lujialei
 * @date: 2018/10/16
 * @describe:
 */


public class CartAdapter extends BaseQuickAdapter<Object,BaseViewHolder> {
    public CartAdapter(@Nullable List<Object> data) {
        super(R.layout.layout_cart_content,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {
    }
}
