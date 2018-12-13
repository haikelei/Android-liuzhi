package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hykj.liuzhi.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 搜索页面
 * @author: lujialei
 * @date: 2018/10/22
 * @describe:
 */
public class HomeSearchActivity extends BaseActivity {
    @BindView(R.id.tv_homesearch_cancel)
    TextView tvHomesearchCancel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_search);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_homesearch_cancel)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_homesearch_cancel:
                finish();
                break;
        }
    }
}
