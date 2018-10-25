package com.hykj.liuzhi.androidcomponents.ui.fragment.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.CircleBean;
import com.hykj.liuzhi.androidcomponents.bean.DetailMoreVideoBean;
import com.hykj.liuzhi.androidcomponents.ui.adapter.CircleAdapter;
import com.hykj.liuzhi.androidcomponents.ui.adapter.DetailMoreVideoAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author: lujialei
 * @date: 2018/9/27
 * @describe:
 */


public class DetailSameCategoryFragment extends Fragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    CircleAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_same_category, container, false);
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
        ArrayList<CircleBean> list = new ArrayList();
        list.add(new CircleBean(1));
        list.add(new CircleBean(2));
        list.add(new CircleBean(3));
        list.add(new CircleBean(1));
        list.add(new CircleBean(2));
        list.add(new CircleBean(3));
        mAdapter = new CircleAdapter(list);
        rv.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
