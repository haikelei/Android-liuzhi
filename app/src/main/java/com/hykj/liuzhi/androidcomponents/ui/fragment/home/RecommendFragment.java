package com.hykj.liuzhi.androidcomponents.ui.fragment.home;

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
import com.hykj.liuzhi.androidcomponents.bean.BannerBean;
import com.hykj.liuzhi.androidcomponents.interfaces.GlideImageLoader;
import com.hykj.liuzhi.androidcomponents.mock.Mock;
import com.hykj.liuzhi.androidcomponents.net.HttpManager;
import com.hykj.liuzhi.androidcomponents.ui.activity.DetailSoftArticleActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.DetailVideoActivity;
import com.hykj.liuzhi.androidcomponents.ui.adapter.RecommendAdapter;
import com.hykj.liuzhi.androidcomponents.ui.widget.BannerHeader;
import com.hykj.liuzhi.androidcomponents.ui.widget.CustomLoadMoreView;
import com.youth.banner.Banner;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author: lujialei
 * @date: 2018/9/27
 * @describe:
 */


public class RecommendFragment extends Fragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    RecommendAdapter mAdapter;
    ArrayList list = Mock.getRecommendList();
    private Banner banner;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_recommend, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new RecommendAdapter(getContext(), Mock.getRecommendList());
        BannerHeader header = new BannerHeader(getContext());
        banner = header.getBanner();
        mAdapter.addHeaderView(header);
        rv.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (position>=4){
                    Intent intent = new Intent(getContext(), DetailSoftArticleActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getContext(), DetailVideoActivity.class);
                    startActivity(intent);
                }

            }
        });
        mAdapter.setLoadMoreView(new CustomLoadMoreView());

        initListener();
        loadData();
    }

    private void initListener() {
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
//                loadData();
            }
        }, rv);
    }

    private void loadData() {
        HttpManager.post(HttpManager.GET_SOWING)
                .params("page","1")
                .params("number","20")
                .params("type","1")
                .execute(new SimpleCallBack<BannerBean>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(BannerBean bannerBean) {
                        List<BannerBean.ArrayBean> list = bannerBean.getArray();
                        ArrayList<String> picList = new ArrayList();
                        for (int i = 0; i < list.size(); i++) {
                            picList.add(list.get(i).getSowing_url());
                        }
                        banner.setImages(picList);
                        banner.setImageLoader(new GlideImageLoader())
                                .setDelayTime(5000)
                                .start();
                    }
                });



        rv.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.addData(list);
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
