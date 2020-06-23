package com.stark.mark2.ui.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.stark.mark2.R;
import com.stark.mark2.adapter.MyBannerAdapter;
import com.stark.mark2.adapter.NewsAdapter;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.bean.News;
import com.stark.mark2.databinding.FragmentNewsBinding;
import com.stark.mark2.ui.NewsContentActivity;
import com.stark.mark2.util.Utils;
import com.youth.banner.Banner;

import java.util.ArrayList;


public class NewsFragment extends LazyFragment implements OnItemClickListener {

    private static final String ARG_DATA_LIST = "ARG_DATA_LIST";
    private static final String ARG_BANNER = "ARG_BANNER";

    private FragmentNewsBinding mBinding;
    private View bannerView;
    private Banner<Integer, MyBannerAdapter> banner;
    public static final int NO_BANNER = 0;
    public static final int BANNER = 1;
    private ArrayList<News> dataList;

    public static NewsFragment newInstance(ArrayList<News> dataList, int banner) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_DATA_LIST, dataList);
        args.putInt(ARG_BANNER, banner);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false);
        bannerView = getLayoutInflater().inflate(R.layout.banner, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void init() {
        if (getArguments() != null) {
            dataList = getArguments().getParcelableArrayList(ARG_DATA_LIST);
            int type = getArguments().getInt(ARG_BANNER);

            NewsAdapter newsAdapter = new NewsAdapter();
            mBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.finishLoadMore(2000));
            mBinding.refreshLayout.setOnRefreshListener(refreshLayout -> refreshLayout.finishRefresh(2000));

            mBinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
            mBinding.rv.setAdapter(newsAdapter);

            if (type != NO_BANNER) {
                banner = bannerView.findViewById(R.id.banner);
                banner.setAdapter(new MyBannerAdapter(Utils.getBannerList()));

                newsAdapter.addHeaderView(bannerView);
                banner.start();
            }
            newsAdapter.setOnItemClickListener(this);
            newsAdapter.setList(dataList);
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        if (null != banner) {
            banner.stop();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != banner) {
            banner.destroy();
        }

    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        News news = dataList.get(position);
        Bundle b = new Bundle();
        b.putParcelable("News", news);
        Intent i = new Intent(getActivity(), NewsContentActivity.class);
        i.putExtras(b);
        if (null != getActivity()) {
            getActivity().startActivity(i);
        }
    }
}
