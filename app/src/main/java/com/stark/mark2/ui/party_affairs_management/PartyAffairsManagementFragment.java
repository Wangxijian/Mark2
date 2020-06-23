package com.stark.mark2.ui.party_affairs_management;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.stark.mark2.R;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.databinding.FragmentPartyAffairsManagementBinding;


public class PartyAffairsManagementFragment extends LazyFragment {

    private FragmentPartyAffairsManagementBinding mBinding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_party_affairs_management, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void init() {
        mBinding.imgOrganization.setOnClickListener(v -> {
            if (null != getActivity()) {
                Intent i = new Intent(getActivity(), OrganizationActivity.class);
                getActivity().startActivity(i);
            }
        });
    }

}
