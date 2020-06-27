package com.stark.mark2.ui.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.stark.mark2.R;
import com.stark.mark2.adapter.NewsAdapter;
import com.stark.mark2.bean.News;
import com.stark.mark2.databinding.ActivityLiangXueYiZuoBinding;
import com.stark.mark2.ui.NewsContentActivity;
import com.stark.mark2.util.DAOUtils;

import java.util.ArrayList;

public class LiangXueYiZuoActivity extends FragmentActivity implements OnItemClickListener {

    private ActivityLiangXueYiZuoBinding mBinding;

    private ArrayList<News> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_liang_xue_yi_zuo);
        mBinding.back.setOnClickListener(v -> finish());
        // initTab();
        initList();
    }

    private void initList() {
        dataList = DAOUtils.getInstance().getNewsByType(this,News.TYPE_NEWS_STUDY_1);

        NewsAdapter newsAdapter = new NewsAdapter();
        mBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.finishLoadMore(2000));
        mBinding.refreshLayout.setOnRefreshListener(refreshLayout -> refreshLayout.finishRefresh(2000));

        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rv.setAdapter(newsAdapter);

        newsAdapter.setOnItemClickListener(this);
        newsAdapter.setList(dataList);
    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        News news = dataList.get(position);
        Bundle b = new Bundle();
        b.putParcelable("News", news);
        Intent i = new Intent(this, NewsContentActivity.class);
        i.putExtras(b);
        startActivity(i);

    }


//    private void initTab() {
//
//        ArrayList<Fragment> fragments = new ArrayList<>();
//
//        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getNewsByType(this, News.TYPE_NEWS_PARTY_BUILDING_1),NewsFragment.NO_BANNER));
//        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getNewsByType(this, News.TYPE_NEWS_PARTY_BUILDING_1),NewsFragment.NO_BANNER));
//        fragments.add(NewsFragment.newInstance(DAOUtils.getInstance().getNewsByType(this, News.TYPE_NEWS_PARTY_BUILDING_1),NewsFragment.NO_BANNER));
//
//
//        ArrayList<String> titles = new ArrayList<>();
//        titles.add("学党章党规");
//        titles.add("学系列讲话");
//        titles.add("做合格党员");
//
//
//        FragmentLazyPagerAdapter adapter = new FragmentLazyPagerAdapter(getSupportFragmentManager(), fragments, titles);
//        mBinding.content.setAdapter(adapter);
//
//        mBinding.tab.setupWithViewPager(mBinding.content);
//
//
//    }
}
