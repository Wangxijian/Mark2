package com.stark.mark2.ui.party_affairs_management.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stark.mark2.R;
import com.stark.mark2.base.LazyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends LazyFragment {


    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_group, container, false);
    }

    @Override
    public void init() {

    }
}
