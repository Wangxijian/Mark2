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
import com.stark.mark2.bean.News;
import com.stark.mark2.databinding.FragmentPartyBuildingBinding;
import com.stark.mark2.ui.home.fragment.NewsFragment;
import com.stark.mark2.ui.party_building.fragment.PartyBuildingPlusFragment;
import com.stark.mark2.ui.party_building.fragment.StandardFragment;
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
        initTab();
    }

    //初始化TabLayout
    private void initTab() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new StandardFragment());
        fragments.add(new PartyBuildingPlusFragment());
        fragments.add(new PartyBuildingPlusFragment());


        ArrayList<String> titles = new ArrayList<>();
        titles.add("十个标准化");
        titles.add("党建+");
        titles.add("六坚持");

        FragmentLazyPagerAdapter adapter = new FragmentLazyPagerAdapter(getChildFragmentManager(), fragments, titles);
        mBinding.content.setAdapter(adapter);

        mBinding.tab.setupWithViewPager(mBinding.content);


    }
}
