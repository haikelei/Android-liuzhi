package com.hykj.liuzhi.androidcomponents.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.mock.Mock;
import com.hykj.liuzhi.androidcomponents.ui.activity.DetailVideoActivity;
import com.hykj.liuzhi.androidcomponents.ui.adapter.RecommendAdapter;
import com.hykj.liuzhi.androidcomponents.ui.widget.CustomLoadMoreView;
import com.hykj.liuzhi.androidcomponents.ui.widget.RecycleViewDivider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author: lujialei
 * @date: 2018/9/27
 * @describe:
 */


public class FashionFragment extends Fragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    RecommendAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fashion, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycleViewDivider dividerItemDecoration = new RecycleViewDivider(getContext(),DividerItemDecoration.VERTICAL, R.drawable.divider_mileage);
        rv.addItemDecoration(dividerItemDecoration);
        mAdapter = new RecommendAdapter(getContext(), Mock.getRecommendList());
        rv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), DetailVideoActivity.class);
                startActivity(intent);
            }
        });
        mAdapter.setLoadMoreView(new CustomLoadMoreView());
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadData();
            }
        }, rv);
    }

    private void loadData() {
        rv.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.addData(Mock.getRecommendList());
                mAdapter.loadMoreComplete();
            }
        }, 2000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
