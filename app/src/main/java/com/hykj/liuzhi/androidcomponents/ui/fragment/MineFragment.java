package com.hykj.liuzhi.androidcomponents.ui.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.CircleBean;
import com.hykj.liuzhi.androidcomponents.ui.activity.AttentionActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.DetailCircleImageActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.EditUserDataActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.MyCollectActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.MyJiFenActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.OffLineVideoActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.SetUpActivity;
import com.hykj.liuzhi.androidcomponents.ui.adapter.CircleAdapter;
import com.hykj.liuzhi.androidcomponents.utils.RoundImageView;

import java.util.ArrayList;

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
    @BindView(R.id.ll_mine_mycollect)
    LinearLayout llMineMycollect;
    @BindView(R.id.ll_mine_myfocus)
    LinearLayout llMineMyfocus;
    @BindView(R.id.ll_mine_myfans)
    LinearLayout llMineMyfans;
    @BindView(R.id.tv_mine_set)
    ImageView tvMineSet;
    @BindView(R.id.tv_mine_sead)
    TextView tvMineSead;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.tv_mine_offline_down)
    TextView tvMineOfflineDown;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initView();
    }

    private void initView() {
        restoreInfo();

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<CircleBean> list = new ArrayList();
        list.add(new CircleBean(1));
        list.add(new CircleBean(2));
        list.add(new CircleBean(3));
        list.add(new CircleBean(1));
        list.add(new CircleBean(2));
        list.add(new CircleBean(3));
        CircleAdapter adapter = new CircleAdapter(list);
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), DetailCircleImageActivity.class);
                startActivity(intent);
            }
        });
    }

    /*获取保存的信息*/
    private void restoreInfo() {
        SharedPreferences sp = getActivity().getSharedPreferences("data", 0);
        String userPhone = sp.getString("phone", "");
        if (!userPhone.isEmpty()) {
            tvMineuserNike.setText(userPhone);
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.iv_mine_userhead, R.id.tv_mine_edit_userdata, R.id.rl_mine_setup, R.id.ll_mine_mycollect, R.id.ll_mine_myfocus, R.id.ll_mine_myfans, R.id.tv_mine_sead,R.id.tv_mine_offline_down})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.iv_mine_userhead:
                intent = new Intent(getContext(), EditUserDataActivity.class);
                break;
            case R.id.tv_mine_edit_userdata:
                intent = new Intent(getContext(), EditUserDataActivity.class);

                break;
            case R.id.rl_mine_setup:
                intent = new Intent(getContext(), SetUpActivity.class);
                break;
            case R.id.ll_mine_mycollect:
                intent = new Intent(getContext(), MyCollectActivity.class);
                break;

            case R.id.ll_mine_myfocus:
                //关注
                intent = new Intent(getContext(), AttentionActivity.class);
                intent.putExtra("type","0");
                break;

            case R.id.ll_mine_myfans:
//                intent = new Intent(getContext(), SQLactivity.class);
                intent = new Intent(getContext(), AttentionActivity.class);
                intent.putExtra("type","1");
                break;

            case R.id.tv_mine_sead:
                intent = new Intent(getContext(), MyJiFenActivity.class);
                break;

            case R.id.tv_mine_offline_down:
                intent = new Intent(getContext(), OffLineVideoActivity.class);
                break;
        }
        startActivity(intent);
    }
}
