package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.bumptech.glide.Glide;
import com.flyco.tablayout.SlidingTabLayout;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.ui.adapter.DetailPagerAdapter;
import com.hykj.liuzhi.androidcomponents.utils.DensityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * @author: lujialei
 * @date: 2018/9/28
 * @describe:
 */


public class DetailVideoActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    SlidingTabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    private String url = "http://7xp06y.com1.z0.glb.clouddn.com/b10/%E4%B8%80%E6%97%A0%E6%89%80%E6%9C%89%E6%9C%89%E6%A2%A6%E8%80%8C%E5%B7%B2%20solo%20cut.mp3";
    private String url1 = "http://7xse1z.com1.z0.glb.clouddn.com/1491813192";
    String source1 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
    String pic = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539605015548&di=34ba3cda1ee437ce8e218b41a0509918&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F0eb30f2442a7d933b29eb303a04bd11373f0018f.jpg";
    JzvdStd mJzvdStd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_video);
        ButterKnife.bind(this);
        mJzvdStd = findViewById(R.id.jz_video);
        mJzvdStd.setUp(source1, ""
                , JzvdStd.SCREEN_WINDOW_NORMAL);
        Glide.with(this)
                .load(pic)
                .into(mJzvdStd.thumbImageView);

        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        Jzvd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        initView();
    }

    private void initView() {
        viewPager.setAdapter(new DetailPagerAdapter(getSupportFragmentManager()));
        tabLayout.setViewPager(viewPager);
    }


    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();

        //Change these two variables back
        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
        Jzvd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // 声明PopupWindow
    private PopupWindow popupWindow;
    // 声明PopupWindow对应的视图
    private View popupView;

    // 声明平移动画
    private TranslateAnimation animation;

    @OnClick({R.id.tv_collect, R.id.ll_download})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_collect:
                break;
            case R.id.ll_download:
                if (popupWindow == null) {
                    popupView = View.inflate(this, R.layout.layout_bottom_download_video, null);
                    // 参数2,3：指明popupwindow的宽度和高度
                    popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT,
                            DensityUtils.dp2px(getBaseContext(),370));

                    // 设置背景图片， 必须设置，不然动画没作用
                    popupWindow.setBackgroundDrawable(null);
                    popupWindow.setFocusable(true);

                    // 设置点击popupwindow外屏幕其它地方消失
                    popupWindow.setOutsideTouchable(true);

                    // 平移动画相对于手机屏幕的底部开始，X轴不变，Y轴从1变0
                    animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                            Animation.RELATIVE_TO_PARENT, 1, Animation.RELATIVE_TO_PARENT, 0);
                    animation.setInterpolator(new AccelerateInterpolator());
                    animation.setDuration(200);
                }

                // 在点击之后设置popupwindow的销毁
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }

                // 设置popupWindow的显示位置，此处是在手机屏幕底部且水平居中的位置
                popupWindow.showAtLocation(llContent, Gravity.BOTTOM, 0, 0);
                popupView.startAnimation(animation);
                break;
        }
    }
}
