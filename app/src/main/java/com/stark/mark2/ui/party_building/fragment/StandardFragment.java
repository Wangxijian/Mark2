package com.stark.mark2.ui.party_building.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.stark.mark2.R;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.databinding.FragmentStandardBinding;

import static android.webkit.WebSettings.TextSize.LARGER;

/**
 * A simple {@link Fragment} subclass.
 */
public class StandardFragment extends LazyFragment {

    private FragmentStandardBinding mBinding;
    private String url = "http://112.74.112.46:9999/standard.html";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_standard, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void init() {

        WebSettings webSettings = mBinding.web.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setTextSize(LARGER);

        mBinding.web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });

        mBinding.web.loadUrl(url);

    }
}
