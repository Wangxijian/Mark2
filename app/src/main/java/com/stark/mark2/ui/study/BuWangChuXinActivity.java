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
import com.stark.mark2.databinding.ActivityBuWangChuXinBinding;
import com.stark.mark2.ui.NewsContentActivity;
import com.stark.mark2.util.DAOUtils;

import java.util.ArrayList;

public class BuWangChuXinActivity extends FragmentActivity implements OnItemClickListener {

    private ActivityBuWangChuXinBinding mBinding;
    private ArrayList<News> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_bu_wang_chu_xin);
        mBinding.back.setOnClickListener(v -> finish());
        initList();
    }

    private void initList() {
        dataList = DAOUtils.getInstance().getNewsByType(this, News.TYPE_NEWS_STUDY_3);

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
}
