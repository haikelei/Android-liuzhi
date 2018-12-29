package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.net.http.HttpHelper;
import com.hykj.liuzhi.androidcomponents.ui.activity.min.bean.AllAddBean;
import com.hykj.liuzhi.androidcomponents.ui.adapter.SelectAdressListAdapter;
import com.hykj.liuzhi.androidcomponents.utils.ACache;
import com.hykj.liuzhi.androidcomponents.utils.ErrorStateCodeUtils;
import com.hykj.liuzhi.androidcomponents.utils.FastJSONHelper;
import com.hykj.liuzhi.androidcomponents.utils.TitleBuilder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAdressActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.recycler_select_adress)
    RecyclerView recyclerSelectAdress;
    private ACache aCache;
    private SmartRefreshLayout swipeRefreshLayout;
    private SelectAdressListAdapter adapter;
    List<AllAddBean.DataBean.ArrayBean> AllDatas = new ArrayList<>();
    private String title = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_adress);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        if (getIntent().getStringExtra("title") != null) {
            title = getIntent().getStringExtra("title");
        }
        swipeRefreshLayout = findViewById(R.id.refreshLayout);
        swipeRefreshLayout.setRefreshHeader(new ClassicsHeader(this));  //设置 Header 为 贝塞尔雷达 样式
        swipeRefreshLayout.setRefreshFooter(new ClassicsFooter(this).setSpinnerStyle(SpinnerStyle.Scale));//设置 Footer 为 球脉冲 样式
        new TitleBuilder(SelectAdressActivity.this).setTitleText("选择收货地址").setLeftIco(R.mipmap.common_black_back).setLeftIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }).setRightIco(R.mipmap.add_address).setRightIcoListening(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectAdressActivity.this, AddAdressActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        swipeRefreshLayout.setEnableRefresh(true);//启用刷新
        swipeRefreshLayout.setEnableLoadmore(true);//启用加载
        swipeRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                AllDatas.clear();
                postBackAddData();
                refreshlayout.finishRefresh();
            }
        });
        //加载更多
        swipeRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                postBackAddData();
                refreshlayout.finishLoadmore();
            }
        });
    }

    private void initData() {
        aCache = ACache.get(this);
        recyclerSelectAdress.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        postBackAddData();
    }

    int page = 1;
    private AllAddBean entity;
    private AllAddBean.DataBean.ArrayBean titleBean;

    public void postBackAddData() {
        HttpHelper.getUserAddress(aCache.getAsString("user_id"), page + "", new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                Toast.makeText(SelectAdressActivity.this, failure, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSucceed(String succeed) {
                entity = FastJSONHelper.getPerson(succeed, AllAddBean.class);
                if (entity.getData().getArray().size() == 0) {
                    return;
                }
                for (int i = 0; i < entity.getData().getArray().size(); i++) {
                    AllDatas.add(entity.getData().getArray().get(i));
                }
                if (adapter == null) {
                    adapter = new SelectAdressListAdapter(AllDatas);
                    adapter.setOnItemChildClickListener(SelectAdressActivity.this);
                    adapter.setOnItemClickListener(SelectAdressActivity.this);
                    recyclerSelectAdress.setAdapter(adapter);
                } else {
                    adapter.notifyLoadMoreToLoading();
                    adapter.loadMoreComplete();
                }
            }

            @Override
            public void onError(String error) {
                Toast.makeText(SelectAdressActivity.this, ErrorStateCodeUtils.getRegisterErrorMessage(error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.item_select_delete://删除
                Log.e("aa", "----删除------" + position);
                break;
            case R.id.item_select_binaji://编辑
                Log.e("aa", "---编辑-------" + position);
                break;
            case R.id.ch_delete://默认选择
                for (int i = 0; i < AllDatas.size(); i++) {
                    if (AllDatas.get(i).getAddress_status() == 1) {
                        AllDatas.get(i).setAddress_status(0);
                    }
                }
                AllDatas.get(position).setAddress_status(1);
                adapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent ss) {
        super.onActivityResult(requestCode, resultCode, ss);
        if (requestCode == 1 && resultCode == 1) {
            for (int i = 0; i < AllDatas.size(); i++) {
                AllDatas.get(i).setAddress_status(0);
            }
            AllDatas.clear();
            page = 1;
            postBackAddData();
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (title.equals("ConfirmOrderActivity")) {
            Intent intent = new Intent();
            Log.e("aa", "-----------" + entity.getData().getArray().get(position).getAddress_address() + "");
            intent.putExtra("addressid", entity.getData().getArray().get(position).getAddress_id() + "");
            intent.putExtra("addrname", entity.getData().getArray().get(position).getAddress_address() + "");
            setResult(11, intent);
            finish();
        }

    }
}
