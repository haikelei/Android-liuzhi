package com.hykj.liuzhi.androidcomponents.ui.fragment.collect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.net.http.HttpHelper;
import com.hykj.liuzhi.androidcomponents.ui.activity.PersonDetailActivity;
import com.hykj.liuzhi.androidcomponents.ui.adapter.AdvertorialAdapter;
import com.hykj.liuzhi.androidcomponents.utils.LocalInfoUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvertorialFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private AdvertorialAdapter mAdapter;
    private int page = 1;
    private int number = 10;

    public static AdvertorialFragment newInstance(int type) {
        AdvertorialFragment fragment = new AdvertorialFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_advertorial, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        initListener();
        return view;
    }

    private void initData() {
        HttpHelper.getUserCollection(LocalInfoUtils.getUserId(), page, number, getArguments().getInt("type"), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {

            }

            @Override
            public void onSucceed(String succeed) {
                //TODO 接口请求成功，但是数据为空，后续处理
                Logger.t("用户收藏").i(succeed+"");
            }

            @Override
            public void onError(String error) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new AdvertorialAdapter(getActivity(), null);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), PersonDetailActivity.class);
                startActivity(intent);
            }
        });
//        mAdapter.setEmptyView(initEmptyView());
        recyclerView.setAdapter(mAdapter);
    }

    private void initView() {

    }

    private void initListener() {

    }


}