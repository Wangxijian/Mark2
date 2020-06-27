package com.stark.mark2.ui.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.stark.mark2.R;
import com.stark.mark2.adapter.NewsAdapter;
import com.stark.mark2.base.LazyFragment;
import com.stark.mark2.bean.News;
import com.stark.mark2.databinding.FragmentVideoBinding;
import com.stark.mark2.ui.home.VideoActivity;
import com.stark.mark2.util.DAOUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends LazyFragment implements OnItemClickListener {

    private FragmentVideoBinding mBinding;

    List<News> list = new ArrayList<>();

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_video, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void init() {

        list = DAOUtils.getInstance().getNewsByType(getContext(), News.TYPE_NEWS_VIDEO);
        mBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.finishLoadMore(2000));
        mBinding.refreshLayout.setOnRefreshListener(refreshLayout -> refreshLayout.finishRefresh(2000));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        NewsAdapter adapter = new NewsAdapter();
        mBinding.rv.setLayoutManager(linearLayoutManager);
        mBinding.rv.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.setList(list);


    }

    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        if (null != getActivity()) {
            Intent i = new Intent(getActivity(), VideoActivity.class);
            i.putExtra(VideoActivity.VIDEO_TITLE,list.get(position).getNewsTitle());
            i.putExtra(VideoActivity.VIDEO_IMG,list.get(position).getNewsImage());
            i.putExtra(VideoActivity.VIDEO_URL,list.get(position).getNewsContent());
            getActivity().startActivity(i);
        }
    }
}
