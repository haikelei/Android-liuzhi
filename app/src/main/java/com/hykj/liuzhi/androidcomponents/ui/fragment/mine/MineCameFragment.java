package com.hykj.liuzhi.androidcomponents.ui.fragment.mine;

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
import com.hykj.liuzhi.androidcomponents.bean.CircleBean;
import com.hykj.liuzhi.androidcomponents.ui.activity.DetailCircleImageActivity;
import com.hykj.liuzhi.androidcomponents.ui.adapter.CircleAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MineCameFragment extends Fragment {
    @BindView(R.id.rv_mine_camera)
    RecyclerView rvMineCamera;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_came, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        rvMineCamera.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<CircleBean> list = new ArrayList();
        list.add(new CircleBean(1));
        list.add(new CircleBean(2));
        list.add(new CircleBean(3));
        list.add(new CircleBean(1));
        list.add(new CircleBean(2));
        list.add(new CircleBean(3));
        CircleAdapter adapter = new CircleAdapter(list);
        rvMineCamera.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), DetailCircleImageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
