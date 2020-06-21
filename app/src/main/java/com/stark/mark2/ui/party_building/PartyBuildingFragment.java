package com.stark.mark2.ui.party_building;


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
import com.stark.mark2.databinding.FragmentPartyBuildingBinding;
import com.stark.mark2.ui.home.fragment.NewsFragment;
import com.stark.mark2.util.DAOUtils;
import com.stark.mark2.util.Utils;

import java.util.ArrayList;


public class PartyBuildingFragment extends LazyFragment {

    private FragmentPartyBuildingBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_party_building, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void init() {
        Utils.LogE("PartyBuildingFragment");
        initTab();
    }

    //初始化TabLayout
    private void initTab() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getAllNews(getContext()), NewsFragment.NO_BANNER));
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getAllNews(getContext()), NewsFragment.NO_BANNER));
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getAllNews(getContext()), NewsFragment.NO_BANNER));


        ArrayList<String> titles = new ArrayList<>();
        titles.add("组织介绍");
        titles.add("党务公开");
        titles.add("建党先锋");

        FragmentLazyPagerAdapter adapter = new FragmentLazyPagerAdapter(getChildFragmentManager(), fragments, titles);
        mBinding.content.setAdapter(adapter);

        mBinding.tab.setupWithViewPager(mBinding.content);


    }
}
