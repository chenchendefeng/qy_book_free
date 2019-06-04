package com.wy.xdroidmvp.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 同一个界面显示两个卡片
 *
 * @author xiaoyuer
 * @data 18/11/06
 */
public class XFragmentHalfAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();
    private String[] titles;
    private FragmentManager fm;

    public XFragmentHalfAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] titles) {
        super(fm);
        this.fm = fm;
        this.fragmentList.clear();
        this.fragmentList.addAll(fragmentList);
        this.titles = titles;
    }

    // yuan_xh 加
    public void setFragmentHalfList(List<Fragment> fragmentList, String[] titles) {
        this.titles = titles;
        if (this.fragmentList.size() != 0) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment f : this.fragmentList) {
                ft.remove(f);
            }
//            ft.commitAllowingStateLoss();
            ft.commit();
            fm.executePendingTransactions();
        }
        this.fragmentList.clear();
        this.fragmentList.addAll(fragmentList);
        notifyDataSetChanged();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public float getPageWidth(int position) {
        return (float) 0.5;
    }

    // yuan_xh 加
    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null && titles.length > position) {
            return titles[position];
        }
        return "";
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
