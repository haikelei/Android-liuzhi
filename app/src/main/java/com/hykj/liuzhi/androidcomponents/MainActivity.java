package com.hykj.liuzhi.androidcomponents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.ui.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_view)
    BottomNavigationView bottomView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        EasyHttp.post("api/")
//                .baseUrl("http://xxxx.xx.xx/dlydbg/")
//                .upJson("{\"\":\"\",\"\":\"\",\"\":\"\",\"swry_dm\":\"127053096\",\"version\":\"1.0.0\"}")
//                //这里不想解析，简单只是为了做演示 直接返回String
//                .execute(new SimpleCallBack<String>() {
//                    @Override
//                    public void onError(ApiException e) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(String s) {
//
//                    }
//                });
        initView();
        initListener();
//        startActivity(new Intent(this, DetailVideoActivity.class));
    }

    private void initListener() {
        bottomView.setListener(new BottomNavigationView.Listener() {
            @Override
            public void onClick(int index) {

            }
        });
    }


    private void initView() {
        bottomView.initFragment(R.id.container,getSupportFragmentManager());

    }
}
