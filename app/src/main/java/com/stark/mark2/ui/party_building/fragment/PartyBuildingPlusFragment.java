package com.stark.mark2.ui.party_building.fragment;


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
import com.stark.mark2.adapter.NewsAdapter;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.bean.News;
import com.stark.mark2.databinding.FragmentPartyBuildingPlusBinding;
import com.stark.mark2.ui.NewsContentActivity;

import java.util.ArrayList;
import java.util.List;


public class PartyBuildingPlusFragment extends LazyFragment implements OnItemClickListener {

    private FragmentPartyBuildingPlusBinding mBinding;
    private List<News> dataList;
    private static final String ARG_DATA_LIST = "ARG_DATA_LIST";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_party_building_plus, container, false);
        return mBinding.getRoot();
    }


    public static PartyBuildingPlusFragment newInstance(ArrayList<News> dataList) {
        PartyBuildingPlusFragment fragment = new PartyBuildingPlusFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_DATA_LIST, dataList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void init() {
        if (getArguments() != null) {
            dataList = getArguments().getParcelableArrayList(ARG_DATA_LIST);


            NewsAdapter newsAdapter = new NewsAdapter();
            mBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.finishLoadMore(2000));
            mBinding.refreshLayout.setOnRefreshListener(refreshLayout -> refreshLayout.finishRefresh(2000));

            mBinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
            mBinding.rv.setAdapter(newsAdapter);


            newsAdapter.setOnItemClickListener(this);


            newsAdapter.setList(dataList);
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
