package com.stark.mark2.ui.party_building.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.stark.mark2.R;
import com.stark.mark2.adapter.NewsAdapter;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.databinding.FragmentPartyBuildingPlusBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class PartyBuildingPlusFragment extends LazyFragment {

    private FragmentPartyBuildingPlusBinding mBinding;

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
    }
}
