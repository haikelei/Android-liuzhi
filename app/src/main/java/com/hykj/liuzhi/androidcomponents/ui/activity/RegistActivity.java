package com.hykj.liuzhi.androidcomponents.ui.activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
public class RegistActivity extends BaseActivity {
    @BindView(R.id.title_leftIco)
    ImageView titleLeftIco;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.title_rightIco)
    ImageView titleRightIco;
    @BindView(R.id.title_bar)
    RelativeLayout titleBar;
    @BindView(R.id.et_regist_phone)
    EditText etRegistPhone;
    @BindView(R.id.et_regist_authcode)
    EditText etRegistAuthcode;
    @BindView(R.id.et_regist_password)
    EditText etRegistPassword;
    @BindView(R.id.tv_regist_registdeal)
    TextView tvRegistRegistdeal;
    @BindView(R.id.tv_regist_regist)
    TextView tvRegistRegist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        new TitleBuilder(this).setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /*设置数据*/
    private void initData() {

    }


    @OnClick({R.id.et_regist_authcode, R.id.tv_regist_regist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_regist_authcode:
                break;
            case R.id.tv_regist_regist:
                break;
        }
    }
}
