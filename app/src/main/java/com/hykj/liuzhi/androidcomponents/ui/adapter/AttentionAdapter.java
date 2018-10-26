package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;

import java.util.ArrayList;
import java.util.List;

public class AttentionAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private ArrayList<String> list;
    private Context mContext;
    public AttentionAdapter(Context context, @Nullable List<String> data) {
        super(R.layout.item_attention, data);
        this.list = (ArrayList<String>) data;
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, String item) {
        holder.setText(R.id.msg,item);
        final TextView textView = holder.getView(R.id.textView);
        textView.setTag(false);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean tag = (boolean) textView.getTag();
                tag = !tag;
                if (tag){
                    textView.setBackground(mContext.getDrawable(R.drawable.bg_button_ffb400_2dp));
                    textView.setTextColor(mContext.getResources().getColor(R.color.white));
                    textView.setText("关注");
                }else {
                    textView.setBackground(mContext.getDrawable(R.drawable.bg_button_el_2dp));
                    textView.setTextColor(mContext.getResources().getColor(R.color.public_aaaaaa));
                    textView.setText("已关注");
                }
                textView.setTag(tag);
            }
        });

    }
}
