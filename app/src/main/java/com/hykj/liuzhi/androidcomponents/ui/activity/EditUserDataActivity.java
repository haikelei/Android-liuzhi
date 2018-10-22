package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.UserTableBean;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;

import java.util.ArrayList;

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
    private ArrayList<UserTableBean> tableList = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_userdata);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initData() {
        getOptionData();
    }

    private void getOptionData() {
        tableList.add(new UserTableBean(1, "男"));
        tableList.add(new UserTableBean(2, "女"));

    }

    private void initView() {
        new TitleBuilder(this).setTitleText("编辑主页").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @OnClick({R.id.rl_edit_userdata_changehead, R.id.rl_edit_userdata_label, R.id.rl_edit_userdata_nick, R.id.rl_edit_userdata_signname,R.id.rl_edit_userdata_sex})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rl_edit_userdata_changehead:
                break;
            case R.id.rl_edit_userdata_label:

                break;
            case R.id.rl_edit_userdata_nick:
                intent = new Intent(EditUserDataActivity.this, ChangeNameActivity.class);
                intent.putExtra("position", 1);
                startActivity(intent);
                break;

            case R.id.rl_edit_userdata_signname:
                intent = new Intent(EditUserDataActivity.this, ChangeNameActivity.class);
                intent.putExtra("position", 2);
                startActivity(intent);
                break;
            case R.id.rl_edit_userdata_sex:
                ChangeUserTable();
                break;
        }
    }

    /*更改标签*/
    private void ChangeUserTable() {
        //条件选择器
        OptionsPickerView pvOptions = new OptionsPickerBuilder(EditUserDataActivity.this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = tableList.get(options1).getPickerViewText();

                tvEditUserdataLabel.setText(tx);
            }
        }).build();
        pvOptions.setPicker(tableList);
        pvOptions.show();
    }


}