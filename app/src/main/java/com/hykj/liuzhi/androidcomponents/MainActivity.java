package com.hykj.liuzhi.androidcomponents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.GetusercollectionBean;
import com.hykj.liuzhi.androidcomponents.net.HttpManager;
import com.hykj.liuzhi.androidcomponents.ui.activity.IssueClumnActivity;
import com.hykj.liuzhi.androidcomponents.ui.bottomnavigation.BottomNavigationView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.orhanobut.logger.Logger;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_view)
    BottomNavigationView bottomView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        HttpManager.post(HttpManager.GET_SOWING)
//                .params("page","1")
//                .params("number","20")
//                .params("type","1")
//                .execute(new SimpleCallBack<GetusercollectionBean>() {
//                    @Override
//                    public void onError(ApiException e) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(GetusercollectionBean bannerBean) {
//                        Logger.t("MainActivity").i(bannerBean.toString());
//                    }
//                });
        initView();
        initListener();
    }

    private void initListener() {
        bottomView.setListener(new BottomNavigationView.Listener() {
            @Override
            public void onClick(int index) {
                if (index == 2) {//+号跳转系统相册
                    fitchSystemClumns();


                }
            }
        });
    }

    /*获取系统相册*/
    private void fitchSystemClumns() {
        PictureSelector.create(MainActivity.this)
                .openGallery(PictureMimeType.ofImage())
                .selectionMode(PictureConfig.MULTIPLE)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    private void initView() {

        bottomView.initFragment(R.id.container, getSupportFragmentManager());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    Intent intent = new Intent(MainActivity.this, IssueClumnActivity.class);
                    intent.putExtra("clumnPath", selectList.get(0).getPath());
                    intent.putExtra("title", "发布美图");
                    startActivityForResult(intent, 0x0011);
                    break;
            }
        }
    }
}
