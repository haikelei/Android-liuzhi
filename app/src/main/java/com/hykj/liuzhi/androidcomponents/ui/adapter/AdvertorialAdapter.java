package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;

import java.util.ArrayList;
import java.util.List;

public class AdvertorialAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private ArrayList<String> list;
    private Context mContext;
    public AdvertorialAdapter(Context context, @Nullable List<String> data) {
        super(R.layout.item_advertorial, data);
        this.list = (ArrayList<String>) data;
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, String item) {
        holder.setText(R.id.title,item);
    }
}
