package com.stark.mark2.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.stark.mark2.R;
import com.stark.mark2.adapter.base.FragmentLazyPagerAdapter;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.databinding.FragmentHomeBinding;
import com.stark.mark2.ui.home.fragment.NewsFragment;
import com.stark.mark2.ui.home.fragment.VideoFragment;
import com.stark.mark2.util.DAOUtils;
import com.stark.mark2.util.Utils;

import java.util.ArrayList;


public class HomeFragment extends LazyFragment {

    private FragmentHomeBinding mBinding;
    private VideoFragment videoFragment;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        //initTab();
        return mBinding.getRoot();
    }

    @Override
    public void init() {
        initTab();
    }

    //初始化TabLayout
    private void initTab() {
        videoFragment= VideoFragment.newInstance() ;
        ArrayList<Fragment> fragments = new ArrayList<>();
        Utils.LogE(DAOUtils.getInstance().getHomeNews(getContext()).toString());
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getHomeNews(getContext()),NewsFragment.BANNER));
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getHomeNews(getContext()),NewsFragment.NO_BANNER));
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getHomeNews(getContext()),NewsFragment.NO_BANNER));
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getHomeNews(getContext()),NewsFragment.NO_BANNER));
        fragments.add(videoFragment);

        ArrayList<String> titles = new ArrayList<>();
        titles.add("党建要闻");
        titles.add("行业党建");
        titles.add("组织动态");
        titles.add("年度计划");
        titles.add("普法视频");

        FragmentLazyPagerAdapter adapter = new FragmentLazyPagerAdapter(getChildFragmentManager(), fragments, titles);
        mBinding.content.setAdapter(adapter);

        mBinding.tab.setupWithViewPager(mBinding.content);


    }

    public boolean onBackPressed(){
        return videoFragment.onBackPressed();
    }


}
