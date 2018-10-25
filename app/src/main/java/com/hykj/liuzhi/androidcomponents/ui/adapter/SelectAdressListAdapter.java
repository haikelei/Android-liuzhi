package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;

import java.util.List;

public class SelectAdressListAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    public SelectAdressListAdapter(@Nullable List<Object> data) {
        super(R.layout.item_select_address_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {

    }
}
