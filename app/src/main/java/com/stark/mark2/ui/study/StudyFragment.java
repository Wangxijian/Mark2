package com.stark.mark2.ui.study;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.stark.mark2.R;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.util.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends LazyFragment {



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study, container, false);
    }

    @Override
    public void init() {
        Utils.LogE("StudyFragment");
    }

}
