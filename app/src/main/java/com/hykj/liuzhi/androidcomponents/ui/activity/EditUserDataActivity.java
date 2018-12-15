package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.UserTableBean;
import com.hykj.liuzhi.androidcomponents.utils.LocalInfoUtils;
import com.hykj.liuzhi.androidcomponents.utils.RoundImageView;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditUserDataActivity extends BaseActivity {
    @BindView(R.id.rl_edit_userdata_changehead)
    RelativeLayout rlEditUserdataChangehead;
    @BindView(R.id.rl_edit_userdata_label)
    RelativeLayout rlEditUserdataLabel;
    @BindView(R.id.tv_edit_userdata_label)
    TextView tvEditUserdataLabel;
    @BindView(R.id.iv_sign_rightrow)
    ImageView ivSignRightrow;
    @BindView(R.id.rl_edit_userdata_nick)
    RelativeLayout rlEditUserdataNick;
    @BindView(R.id.iv_edituser_biaoqian)
    ImageView ivEdituserBiaoqian;
    @BindView(R.id.rl_edit_userdata_signname)
    RelativeLayout rlEditUserdataSignname;
    @BindView(R.id.rl_edit_userdata_sex)
    RelativeLayout rlEditUserdataSex;
    @BindView(R.id.tv_edit_userdata_sex)
    TextView tvEditUserdataSex;
    @BindView(R.id.rl_edit_userdata_email)
    RelativeLayout rlEditUserdataEmail;
    @BindView(R.id.tv_edit_userdata_mail)
    TextView mail;
    @BindView(R.id.iv_edituser_head1)
    RoundImageView haderImage;
    @BindView(R.id.tv_edit_userdata_autograph)
    TextView tv_edit_userdata_autograph;
    private ArrayList<UserTableBean> tableSexList = new ArrayList<>();
    private ArrayList<UserTableBean> tableSignList = new ArrayList<>();
    private Object mOptionTabData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_userdata);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        getOptionSexData();
        seetingUser();
    }

    private void getOptionSexData() {
        tableSexList.add(new UserTableBean(1, "男"));
        tableSexList.add(new UserTableBean(2, "女"));

    }


    private void initView() {
        new TitleBuilder(this).setTitleText("编辑主页").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @OnClick({R.id.rl_edit_userdata_changehead, R.id.rl_edit_userdata_label, R.id.rl_edit_userdata_nick,
            R.id.rl_edit_userdata_signname, R.id.rl_edit_userdata_sex, R.id.rl_edit_userdata_email})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rl_edit_userdata_changehead:
                break;
            case R.id.rl_edit_userdata_label:
                ChangeUserTable();
                break;
            case R.id.rl_edit_userdata_nick:
                intent = new Intent(EditUserDataActivity.this, ChangeNameActivity.class);
                intent.putExtra("position", 1);
                startActivityForResult(intent, 1);
                break;

            case R.id.rl_edit_userdata_signname:
                intent = new Intent(EditUserDataActivity.this, ChangeNameActivity.class);
                intent.putExtra("position", 2);
                startActivityForResult(intent, 1);
                break;
            case R.id.rl_edit_userdata_sex:
                ChangeUserSexTble();
                break;

            case R.id.rl_edit_userdata_email:
                intent = new Intent(EditUserDataActivity.this, BindEmailActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void ChangeUserSexTble() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(EditUserDataActivity.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = tableSexList.get(options1).getPickerViewText();
                tvEditUserdataSex.setText(tx);
            }
        }).build();
        pvOptions.setPicker(tableSexList);
        pvOptions.show();
    }

    /*更改标签*/
    private void ChangeUserTable() {
        Intent intent = new Intent(this, ChangeUserTableActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 2) {
                seetingUser();
            }
        }
    }

    public void seetingUser() {
        Glide.with(this).load(LocalInfoUtils.getUserself("user_pic")).into(haderImage);
        tvEditUserdataSex.setText(LocalInfoUtils.getUserself("user_sex"));
        Log.e("aa", "-----" + LocalInfoUtils.getUserself("user_label"));
        String lablist = LocalInfoUtils.getUserself("user_label");
        tvEditUserdataLabel.setText(lablist);
        mail.setText(LocalInfoUtils.getUserself("user_mail"));
        tv_edit_userdata_autograph.setText(LocalInfoUtils.getUserself("user_autograph"));
    }
}
