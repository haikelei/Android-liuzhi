package com.hykj.liuzhi.androidcomponents.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.UserData;
import com.hykj.liuzhi.androidcomponents.ui.activity.AttentionActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.EditUserDataActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.MyCollectActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.MyJiFenActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.OffLineVideoActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.SetUpActivity;
import com.hykj.liuzhi.androidcomponents.ui.adapter.MinePagerAdapter;
import com.hykj.liuzhi.androidcomponents.ui.fragment.utils.permission.RxPermissions;
import com.hykj.liuzhi.androidcomponents.utils.LocalInfoUtils;
import com.hykj.liuzhi.androidcomponents.utils.RoundImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;

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
    @BindView(R.id.tv_mine_offline_down)
    TextView tvMineOfflineDown;
    @BindView(R.id.tab_layout_mine)
    SlidingTabLayout tabLayoutMine;
    @BindView(R.id.view_pager_mine)
    ViewPager viewPagerMine;
    @BindView(R.id.mineTvCollection)
    TextView tvConllection;
    @BindView(R.id.mineTvmyfocus)
    TextView tvMyFocus;
    @BindView(R.id.mineTvmyfans)
    TextView tvMyFans;
    Gson gson = new Gson();
    private RxPermissions rxPermissions;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {
        viewPagerMine.setAdapter(new MinePagerAdapter(getActivity().getSupportFragmentManager()));
        tabLayoutMine.setViewPager(viewPagerMine);
        rxPermissions = new RxPermissions(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        seetingUser();
    }
    private void initView() {
        restoreInfo();
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
    Intent intent = null;
    @OnClick({R.id.iv_mine_userhead, R.id.tv_mine_edit_userdata, R.id.rl_mine_setup, R.id.ll_mine_mycollect, R.id.ll_mine_myfocus, R.id.ll_mine_myfans, R.id.tv_mine_sead, R.id.tv_mine_offline_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_mine_userhead:
            case R.id.tv_mine_edit_userdata:
                rxPermissions
                        .request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(Boolean aBoolean) throws Exception {
                                if (aBoolean) {
                                    intent = new Intent(getContext(), EditUserDataActivity.class);
                                } else {
                                    Toast.makeText(getActivity(), "请打开读写存储卡权限", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                break;
            case R.id.rl_mine_setup:
                intent = new Intent(getContext(), SetUpActivity.class);
                break;
            case R.id.ll_mine_mycollect:
                intent = new Intent(getContext(), MyCollectActivity.class);
                break;

            case R.id.ll_mine_myfocus:   //关注
                intent = new Intent(getContext(), AttentionActivity.class);
                intent.putExtra("type", "0");
                break;

            case R.id.ll_mine_myfans://粉丝
                intent = new Intent(getContext(), AttentionActivity.class);
                intent.putExtra("type", "1");
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

    public void seetingUser() {
        Glide.with(getContext()).load(LocalInfoUtils.getUserself("user_pic")).into(ivMineUserhead);
        tvMineuserNike.setText(LocalInfoUtils.getUserself("user_nickname"));
        tvMineuserId.setText("ID:" + LocalInfoUtils.getUserself("user_id"));
        tvConllection.setText(LocalInfoUtils.getUserself("user_collection"));
        tvMyFocus.setText(LocalInfoUtils.getUserself("user_follow"));
        tvMyFans.setText(LocalInfoUtils.getUserself("user_fans"));
        tvMineSead.setText(LocalInfoUtils.getUserself("user_integral"));
    }
}
