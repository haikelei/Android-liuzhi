package com.hykj.liuzhi.androidcomponents.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hykj.liuzhi.R;
import com.hykj.liuzhi.androidcomponents.bean.CartBean;
import com.hykj.liuzhi.androidcomponents.net.http.HttpHelper;
import com.hykj.liuzhi.androidcomponents.ui.adapter.CartAdapter;
import com.hykj.liuzhi.androidcomponents.ui.fragment.shop.bean.ShopHomeBean;
import com.hykj.liuzhi.androidcomponents.ui.widget.DefaultTopBar;
import com.hykj.liuzhi.androidcomponents.utils.ACache;
import com.hykj.liuzhi.androidcomponents.utils.ErrorStateCodeUtils;
import com.hykj.liuzhi.androidcomponents.utils.FastJSONHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: lujialei
 * @date: 2018/10/16
 * @describe:
 */
public class CartActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener, BaseQuickAdapter.OnItemClickListener, View.OnClickListener {
    @BindView(R.id.rv)
    RecyclerView rv;
    ACache aCache;
    private TextView allPrice, chose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        aCache = ACache.get(this);
        allPrice = findViewById(R.id.all_price);
        findViewById(R.id.rl_bottom_right).setOnClickListener(this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        chose = findViewById(R.id.tv_allchose);
        chose.setOnClickListener(this);
        showShopCar();
    }

    @Override
    protected View onCreateTopBar(ViewGroup view) {
        DefaultTopBar topBar = new DefaultTopBar(this, "购物车", true);
        return topBar;
    }

    int page = 1;
    private CartAdapter adapter;
    List<CartBean.DataBean.ArrayBean> datas = new ArrayList<>();

    public void showShopCar() {
        HttpHelper.showshopcar(page + "", aCache.getAsString("user_id"), new HttpHelper.HttpUtilsCallBack<String>() {
            @Override
            public void onFailure(String failure) {
                Toast.makeText(CartActivity.this, failure, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSucceed(String succeed) {
                CartBean entity = FastJSONHelper.getPerson(succeed, CartBean.class);
                for (int i = 0; i < entity.getData().getArray().size(); i++) {
                    CartBean.DataBean.ArrayBean bean = entity.getData().getArray().get(i);
                    int dnajia = Integer.valueOf(bean.getGoodsshopcar_price()) / bean.getGoodsshopcar_num();
                    bean.setDanjiaprice(dnajia);
                    bean.setCartShop(false);
                    datas.add(bean);
                }
                if (adapter == null) {
                    adapter = new CartAdapter(datas, CartActivity.this);
                    adapter.setOnItemChildClickListener(CartActivity.this);
                    adapter.setOnItemClickListener(CartActivity.this);
                    rv.setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(String error) {
                Toast.makeText(CartActivity.this, ErrorStateCodeUtils.getRegisterErrorMessage(error), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (view.getId()) {
            case R.id.tv_jian://减
                datas.get(position).setGoodsshopcar_num(datas.get(position).getGoodsshopcar_num() - 1);
                addPrice();
                break;
            case R.id.tv_add://加
                datas.get(position).setGoodsshopcar_num(datas.get(position).getGoodsshopcar_num() + 1);
                addPrice();
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        if (datas.get(position).isCartShop()) {
            datas.get(position).setCartShop(false);
        } else {
            datas.get(position).setCartShop(true);
        }
        adapter.notifyDataSetChanged();
        addPrice();
    }

    private int zongjia = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_allchose://全选
                if (chose.isSelected()) {
                    chose.setSelected(false);
                    for (int i = 0; i < datas.size(); i++) {
                        datas.get(i).setCartShop(false);
                    }
                } else {
                    chose.setSelected(true);
                    for (int i = 0; i < datas.size(); i++) {
                        datas.get(i).setCartShop(true);
                    }
                }
                adapter.notifyDataSetChanged();
                addPrice();
                break;
            case R.id.rl_bottom_right://结算
                Intent intent = new Intent();
                intent.setClass(CartActivity.this, ConfirmOrderActivity.class);
                intent.putExtra("data", (Serializable) datas);
                startActivity(intent);
                break;
        }
    }

    /**
     * 计算出总价格
     */
    public void addPrice() {
        zongjia = 0;
        for (int i = 0; i < datas.size(); i++) {
            if (datas.get(i).isCartShop()) {
                zongjia += (datas.get(i).getGoodsshopcar_num() * datas.get(i).getDanjiaprice());
            }
        }
        allPrice.setText("合计:" + zongjia);
    }
}
