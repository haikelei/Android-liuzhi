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
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.interfaces.GlideImageLoader;
import com.hykj.liuzhi.androidcomponents.net.http.HttpHelper;
import com.hykj.liuzhi.androidcomponents.ui.activity.DetailSoftArticleActivity;
import com.hykj.liuzhi.androidcomponents.ui.activity.DetailVideoActivity;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.adapter.FirstpageAdapter;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.bean.FirstpagedataBean;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.bean.SoftLanguageBean;
import com.hykj.liuzhi.androidcomponents.ui.widget.BannerHeader;
import com.hykj.liuzhi.androidcomponents.utils.ErrorStateCodeUtils;
import com.hykj.liuzhi.androidcomponents.utils.FastJSONHelper;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 推荐
 *
 * @date: 2018/9/27
 * @describe:
 */


public class RecommendFragment extends Fragment implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    //    RecommendAdapter mAdapter;
    FirstpageAdapter mAdapter;
    List<SoftLanguageBean> data = new ArrayList<>();
    private Banner banner;
    boolean newFragMent = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_recommend, container, false);
        unbinder = ButterKnife.bind(this, view);
        if (newFragMent) {
            mAdapter = null;
            newFragMent = false;
        }
        return view;
    }

    BannerHeader header;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        header = new BannerHeader(getContext());
        banner = header.getBanner();
//        mAdapter.setLoadMoreView(new CustomLoadMoreView());
        initListener();
        postBackData();
    }

    private void initListener() {
//        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
////                loadData();
//            }
//        }, rv);
    }

    private void loadData() {
        rv.postDelayed(new Runnable() {
            @Override
            public void run() {
//                mAdapter.addData(list);
                mAdapter.loadMoreComplete();
            }
        }, 2000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        newFragMent = true;
    }
    FirstpagedataBean entity;

    public void postBackData() {
        HttpHelper.getHomeFirstpagedata(new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                Toast.makeText(getContext(), failure, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSucceed(String succeed) {
                entity = FastJSONHelper.getPerson(succeed, FirstpagedataBean.class);
                setBanner(entity.getData().getImagedata());//设置首页bana图
                setAdapterData(entity);//设置adapter的数据源
            }

            @Override
            public void onError(String error) {
                Toast.makeText(getContext(), ErrorStateCodeUtils.getRegisterErrorMessage(error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 设置sBanner
     */
    public void setBanner(List<FirstpagedataBean.DataBean.ImagedataBean> FirstpagedataBean) {
        ArrayList<String> picList = new ArrayList();
        for (int i = 0; i < FirstpagedataBean.size(); i++) {
            picList.add(FirstpagedataBean.get(i).getSowing_url());
        }
        banner.setImages(picList);
        banner.setImageLoader(new GlideImageLoader())
                .setDelayTime(5000)
                .start();
    }

    /**
     * 设置adapter数据源
     */
    public void setAdapterData(FirstpagedataBean bean) {
        if (bean.getCode() != 0) {
            Toast.makeText(getContext(), "返回的参数有误不能获取该结果!", Toast.LENGTH_SHORT).show();
            return;
        }
        SoftLanguageBean bean1 = new SoftLanguageBean(SoftLanguageBean.SECTION_HEADER);//纹理
        data.add(bean1);
        for (int i = 0; i < bean.getData().getVideodata().size(); i++) {
            SoftLanguageBean bean2 = new SoftLanguageBean(SoftLanguageBean.IMAGE_TEXT_INSIDE);
            bean2.setVideo_id(bean.getData().getVideodata().get(i).getVideo_id());
            bean2.setVideo_image(bean.getData().getVideodata().get(i).getVideo_image());
            bean2.setVideo_name(bean.getData().getVideodata().get(i).getVideo_name());
            data.add(bean2);
        }

        SoftLanguageBean bean3 = new SoftLanguageBean(SoftLanguageBean.SOFT_ARTICLE);//软文
        data.add(bean3);
        for (int i = 0; i < bean.getData().getSofttextdata().size(); i++) {
            SoftLanguageBean bean4 = new SoftLanguageBean(SoftLanguageBean.IMAGE_TEXT_TOP);
            bean4.setSofttext_id(bean.getData().getSofttextdata().get(i).getSofttext_id());
            bean4.setSofttext_title(bean.getData().getSofttextdata().get(i).getSofttext_title());
            bean4.setSofttextimageURL(bean.getData().getSofttextdata().get(i).getSofttextimage().getSofttextimage_url());
            bean4.setUser_id(bean.getData().getSofttextdata().get(i).getUser_id());
            bean4.setUser_nickname(bean.getData().getSofttextdata().get(i).getUserdata().getUser_nickname());
            bean4.setUser_pic(bean.getData().getSofttextdata().get(i).getUserdata().getUser_pic());
            data.add(bean4);
        }
        SoftLanguageBean bean5 = new SoftLanguageBean(SoftLanguageBean.IMAGE_HADER);//图片
        data.add(bean5);
        for (int i = 0; i < bean.getData().getAdvdata().size(); i++) {
            SoftLanguageBean bean6 = new SoftLanguageBean(SoftLanguageBean.IMAGE_BUTTOM);
            bean6.setAdv_url(bean.getData().getAdvdata().get(i).getAdv_url());
            data.add(bean6);
        }
        if (mAdapter == null) {
            mAdapter = new FirstpageAdapter(getContext(), data);
            mAdapter.setOnItemClickListener(this);
            mAdapter.addHeaderView(header);
            rv.setAdapter(mAdapter);
        } else {
            mAdapter.notifyLoadMoreToLoading();
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (position <= (entity.getData().getVideodata().size())) {//视频
            Intent intent = new Intent(getContext(), DetailVideoActivity.class);
            startActivity(intent);
        } else if (position <= (entity.getData().getSofttextdata().size() + entity.getData().getVideodata().size() + 1)) {//图片
            Intent intent = new Intent(getContext(), DetailSoftArticleActivity.class);
            startActivity(intent);
        } else {//广告

        }
    }
}
