package com.stark.mark2.ui.party_affairs_management.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stark.mark2.R;
import com.stark.mark2.base.LazyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentMonthPaymentFragment extends LazyFragment {


    public CurrentMonthPaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_month_payment, container, false);
    }

    @Override
    public void init() {

    }
}
