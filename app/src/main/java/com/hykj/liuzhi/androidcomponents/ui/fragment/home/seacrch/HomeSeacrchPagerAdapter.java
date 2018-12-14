package com.hykj.liuzhi.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hykj.liuzhi.androidcomponents.ui.fragment.home.FashionFragment;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.RecommendFragment;
import com.hykj.liuzhi.androidcomponents.ui.fragment.home.TextureFragment;

import java.util.ArrayList;

/**
 * 搜索界面
 * @author: lujialei
 * @date: 2018/9/27
 * @describe:
 */

public class HomeSeacrchPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;
    private ArrayList<String> titleList;
    public HomeSeacrchPagerAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
        list.add(new RecommendFragment());
        list.add(new TextureFragment());
        titleList = new ArrayList<>();
        titleList.add("软文");
        titleList.add("视频");
    }
//    @Override
//    public void onDestroyView() {
//        LogUtils.d(TAG, "-->onDestroyView");
//        super.onDestroyView();
//        if (null != FragmentView) {
//            ((ViewGroup) mFragmentView.getParent()).removeView(mFragmentView);
//        }
//    }
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
