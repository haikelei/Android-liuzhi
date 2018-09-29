package components.luyuan.com.androidcomponents.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import components.luyuan.com.androidcomponents.ui.fragment.home.FashionFragment;
import components.luyuan.com.androidcomponents.ui.fragment.home.PlayFragment;
import components.luyuan.com.androidcomponents.ui.fragment.home.RecommendFragment;
import components.luyuan.com.androidcomponents.ui.fragment.home.TextureFragment;

/**
 * @author: lujialei
 * @date: 2018/9/27
 * @describe:
 */


public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list;
    private ArrayList<String> titleList;
    public HomeFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        list = new ArrayList<>();
        list.add(new RecommendFragment());
        list.add(new TextureFragment());
        list.add(new FashionFragment());
        list.add(new PlayFragment());
        titleList = new ArrayList<>();
        titleList.add("推荐");
        titleList.add("纹理");
        titleList.add("潮流");
        titleList.add("玩客");
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
