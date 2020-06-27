package com.stark.mark2.ui.user;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.stark.mark2.R;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.databinding.FragmentUserBinding;


public class UserFragment extends LazyFragment {

    private FragmentUserBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void init() {
        Glide.with(this).load(R.mipmap.member_1).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mBinding.imgIcon);

        Glide.with(this).load(R.mipmap.member_1).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mBinding.imgIconS1);
        Glide.with(this).load(R.mipmap.member_2).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mBinding.imgIconS2);
        Glide.with(this).load(R.mipmap.member_3).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(mBinding.imgIconS3);

    }
}
