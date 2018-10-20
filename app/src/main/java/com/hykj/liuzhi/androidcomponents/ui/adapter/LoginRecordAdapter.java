package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.LoginRecordBean;

import java.util.List;

public class LoginRecordAdapter extends BaseQuickAdapter<LoginRecordBean, BaseViewHolder> {
    public LoginRecordAdapter(int layoutResId, @Nullable List<LoginRecordBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LoginRecordBean item) {

        helper.setText(R.id.tv_login_record_time, item.getLogintime())
                .setText(R.id.tv_login_record_loginadress, item.getLoginadress())
                .setImageResource(R.id.iv_loginrecord_point, R.mipmap.normal_state);

    }
}
