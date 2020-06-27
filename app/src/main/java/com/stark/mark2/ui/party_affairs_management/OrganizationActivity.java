package com.stark.mark2.ui.party_affairs_management;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.stark.mark2.R;
import com.stark.mark2.adapter.base.FragmentLazyPagerAdapter;
import com.stark.mark2.bean.News;
import com.stark.mark2.databinding.ActivityOrganizationBinding;
import com.stark.mark2.ui.home.fragment.NewsFragment;
import com.stark.mark2.ui.party_affairs_management.fragment.GroupFragment;
import com.stark.mark2.ui.party_affairs_management.fragment.MemberFragment;
import com.stark.mark2.util.DAOUtils;

import java.util.ArrayList;

public class OrganizationActivity extends FragmentActivity {

    private ActivityOrganizationBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_organization);
        mBinding.back.setOnClickListener(v -> finish());
        initTab();
    }



    private void initTab() {

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new GroupFragment());
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getNewsByType(this, News.TYPE_NEWS_MANAGEMENT_1),NewsFragment.NO_BANNER));
        fragments.add(new MemberFragment());


        ArrayList<String> titles = new ArrayList<>();
        titles.add("组织介绍");
        titles.add("党务公开");
        titles.add("党建先锋");


        FragmentLazyPagerAdapter adapter = new FragmentLazyPagerAdapter(getSupportFragmentManager(), fragments, titles);
        mBinding.content.setAdapter(adapter);

        mBinding.tab.setupWithViewPager(mBinding.content);


    }

}
