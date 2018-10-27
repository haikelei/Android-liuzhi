package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hykj.liuzhi.androidcomponents.ui.fragment.MyOrderTabFragment;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.FashionFragment;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.RecommendFragment;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.TextureFragment;

import java.util.ArrayList;

/**
 * @author: lujialei
 * @date: 2018/10/27
 * @describe:
 */


public class MyOrderPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> titleList;
    public MyOrderPagerAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
        list.add(new MyOrderTabFragment());
        list.add(new MyOrderTabFragment());
        list.add(new MyOrderTabFragment());
        list.add(new MyOrderTabFragment());
        titleList = new ArrayList<>();
        titleList.add("全部");
        titleList.add("待付款");
        titleList.add("待收货");
        titleList.add("已完成");
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
