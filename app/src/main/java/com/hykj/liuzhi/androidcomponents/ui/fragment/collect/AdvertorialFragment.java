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
import com.hykj.liuzhi.androidcomponents.ui.activity.PersonDetailActivity;
import com.hykj.liuzhi.androidcomponents.ui.adapter.AdvertorialAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvertorialFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ArrayList<String> list;
    private AdvertorialAdapter mAdapter;

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
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("最美的回忆" + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new AdvertorialAdapter(getActivity(), list);
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