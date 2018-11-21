package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.ui.widget.AutoDisplayChildViewContainer;
import com.hykj.liuzhi.androidcomponents.utils.DensityUtils;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lujialei
 * @date: 2018/10/22
 * @describe:
 */


public class ChangeUserTableActivity extends BaseActivity {

    @BindView(R.id.framelayout)
    FrameLayout mFrameLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_home_search
        setContentView(R.layout.acitivity_user_table);
        ButterKnife.bind(this);
        initView();
        initData();
    }
    String[] datas = {"太阳眼镜","健身器","拉杆箱","行李箱","iphone 7 plus" ,"棉麻素色床品","桌面电风扇","鼠标","机械键盘","键盘","键鼠套装"};
    private void initData() {

        AutoDisplayChildViewContainer flowLayout = new AutoDisplayChildViewContainer(this);
        flowLayout.removeAllViews();
        int padding = DensityUtils.dip2px(this,0);
        flowLayout.setPadding(padding, padding, padding, padding);

        LayoutInflater from = LayoutInflater.from(this);

        for (int i = 0; i <datas.length ; i++) {
            final RelativeLayout inflate = (RelativeLayout) from.inflate(R.layout.itme_filter_term, null);
            inflate.setTag(i);
            TextView textView = (TextView) inflate.findViewById(R.id.tv);
            inflate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) inflate.getTag();
//                    datas.remove(tag);
//                    screeningConditions(datas);
//                    if (datas.size() == 0){
//                        mFrameLayout.setVisibility(View.GONE);
//                    }
                    Intent intent = new Intent();
                    intent.putExtra("text",datas[tag]);
                    setResult(0, intent);
                   finish();
                }
            });
            textView.setGravity(Gravity.CENTER);
            textView.setText(datas[i]);
            // 把View添加到flowLayout容器中进行显示
            flowLayout.addView(inflate);
        }
        mFrameLayout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(70,0,70,0);//4个参数按顺序分别是左上右下
        flowLayout.setLayoutParams(layoutParams);
        mFrameLayout.addView(flowLayout);
    }

    private void initView() {
        new TitleBuilder(ChangeUserTableActivity.this).setTitleText("标签").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
