package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.GoodDetailBean;

import java.util.List;

/**
 * @author: lujialei
 * @date: 2018/10/14
 * @describe:
 */


public class GoodsAdapter extends BaseQuickAdapter<GoodDetailBean,BaseViewHolder> {
    public GoodsAdapter(@Nullable List<GoodDetailBean> data) {
        super(R.layout.layout_item_goods,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodDetailBean item) {

    }
}
