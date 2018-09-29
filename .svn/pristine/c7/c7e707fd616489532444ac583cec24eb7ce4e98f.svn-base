package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;
import com.hykj.liuzhi.R;

/**
 * @author: lujialei
 * @date: 2018/9/28
 * @describe:
 */


public class DetailVideoActivity extends BaseActivity {

    private String url = "http://7xp06y.com1.z0.glb.clouddn.com/b10/%E4%B8%80%E6%97%A0%E6%89%80%E6%9C%89%E6%9C%89%E6%A2%A6%E8%80%8C%E5%B7%B2%20solo%20cut.mp3";
    private String url1 = "http://7xse1z.com1.z0.glb.clouddn.com/1491813192";
    String source1 = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
    JzvdStd mJzvdStd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_video);
        mJzvdStd = findViewById(R.id.jz_video);
        mJzvdStd.setUp(source1, "饺子不信"
                , JzvdStd.SCREEN_WINDOW_NORMAL);
//        Glide.with(this)
//                .load(VideoConstant.videoThumbList[0])
//                .into(mJzvdStd.thumbImageView);

        Jzvd.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        Jzvd.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
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


}
