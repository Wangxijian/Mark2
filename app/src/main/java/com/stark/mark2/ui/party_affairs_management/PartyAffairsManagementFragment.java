package com.stark.mark2.ui.party_affairs_management;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.stark.mark2.R;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.util.Utils;


public class PartyAffairsManagementFragment extends LazyFragment {




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_party_affairs_management, container, false);
    }

    @Override
    public void init() {
        Utils.LogE("PartyAffairsManagementFragment");
    }
}
