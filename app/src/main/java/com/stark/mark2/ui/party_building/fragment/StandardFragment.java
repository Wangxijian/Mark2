package com.stark.mark2.ui.party_building.fragment;


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
public class StandardFragment extends LazyFragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_standard, container, false);
    }

    @Override
    public void init() {

    }
}
