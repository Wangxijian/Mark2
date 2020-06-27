package com.stark.mark2.ui.party_building.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.stark.mark2.R;
import com.stark.mark2.adapter.NewsAdapter;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.bean.News;
import com.stark.mark2.databinding.FragmentPartyBuildingPlusBinding;
import com.stark.mark2.ui.NewsContentActivity;
import com.stark.mark2.util.DAOUtils;

import java.util.List;


public class PartyBuildingPlusFragment extends LazyFragment implements OnItemClickListener {

    private FragmentPartyBuildingPlusBinding mBinding;
    private List<News> dataList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_party_building_plus, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void init() {
        NewsAdapter newsAdapter = new NewsAdapter();
        mBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.finishLoadMore(2000));
        mBinding.refreshLayout.setOnRefreshListener(refreshLayout -> refreshLayout.finishRefresh(2000));

        mBinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.rv.setAdapter(newsAdapter);
        dataList = DAOUtils.getInstance().getNewsByType(getContext(), News.TYPE_NEWS_PARTY_BUILDING);

        newsAdapter.setOnItemClickListener(this);
        

        newsAdapter.setList(dataList);
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
