package com.stark.mark2.ui.study;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.stark.mark2.R;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.databinding.FragmentStudyBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudyFragment extends LazyFragment {

    private FragmentStudyBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_study, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void init() {
        mBinding.imgLiangXueYiZuo.setOnClickListener(v -> {
            if (null != getActivity()) {
                Intent i = new Intent(getActivity(), LiangXueYiZuoActivity.class);
                getActivity().startActivity(i);
            }
        });
    }

}
