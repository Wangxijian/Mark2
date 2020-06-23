package com.stark.mark2.ui.study;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.stark.mark2.R;
import com.stark.mark2.adapter.base.FragmentLazyPagerAdapter;
import com.stark.mark2.bean.News;
import com.stark.mark2.databinding.ActivityLiangXueYiZuoBinding;
import com.stark.mark2.ui.home.fragment.NewsFragment;
import com.stark.mark2.util.DAOUtils;

import java.util.ArrayList;

public class LiangXueYiZuoActivity extends FragmentActivity {

    private ActivityLiangXueYiZuoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_liang_xue_yi_zuo);
        mBinding.back.setOnClickListener(v -> finish());
        initTab();
    }


    private void initTab() {

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getNewsByType(this, News.TYPE_NEWS_PARTY_BUILDING),NewsFragment.NO_BANNER));
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getNewsByType(this, News.TYPE_NEWS_PARTY_BUILDING),NewsFragment.NO_BANNER));
        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getNewsByType(this, News.TYPE_NEWS_PARTY_BUILDING),NewsFragment.NO_BANNER));


        ArrayList<String> titles = new ArrayList<>();
        titles.add("学党章党规");
        titles.add("学系列讲话");
        titles.add("做合格党员");


        FragmentLazyPagerAdapter adapter = new FragmentLazyPagerAdapter(getSupportFragmentManager(), fragments, titles);
        mBinding.content.setAdapter(adapter);

        mBinding.tab.setupWithViewPager(mBinding.content);


    }
}
