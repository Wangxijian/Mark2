package com.stark.mark2.ui.party_affairs_management.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.stark.mark2.R;
import com.stark.mark2.adapter.MemberAdapter;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.databinding.FragmentMemberBinding;
import com.stark.mark2.util.DAOUtils;


public class MemberFragment extends LazyFragment {

    private FragmentMemberBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_member, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void init() {
        MemberAdapter adapter = new MemberAdapter(getContext(),R.layout.item_member);
        mBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.finishLoadMore(2000));
        mBinding.refreshLayout.setOnRefreshListener(refreshLayout -> refreshLayout.finishRefresh(2000));

        mBinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.rv.setAdapter(adapter);
        adapter.setList(DAOUtils.getInstance().getMember(getContext()));

    }
}
