package com.hykj.liuzhi.androidcomponents.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.ui.activity.EditUserDataActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.SetUpActivity;
import com.hykj.liuzhi.androidcomponents.utils.RoundImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author: lujialei
 * @date: 2018/9/27
 * @describe:
 */


public class MineFragment extends Fragment {

    @BindView(R.id.iv_mine_userhead)
    RoundImageView ivMineUserhead;
    @BindView(R.id.tv_mineuser_nike)
    TextView tvMineuserNike;
    @BindView(R.id.tv_mineuser_id)
    TextView tvMineuserId;
    @BindView(R.id.tv_mine_edit_userdata)
    TextView tvMineEditUserdata;
    Unbinder unbinder;
    @BindView(R.id.rl_mine_setup)
    RelativeLayout rlMineSetup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_mine_userhead, R.id.tv_mine_edit_userdata, R.id.rl_mine_setup})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.iv_mine_userhead:
                break;
            case R.id.tv_mine_edit_userdata:
                intent = new Intent(getContext(), EditUserDataActivity.class);

                break;
            case R.id.rl_mine_setup:
                intent = new Intent(getContext(), SetUpActivity.class);

                break;
        }
        startActivity(intent);
    }
}
