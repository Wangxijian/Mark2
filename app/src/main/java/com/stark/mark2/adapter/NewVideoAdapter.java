package com.stark.mark2.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.stark.mark2.bean.News;

import org.jetbrains.annotations.NotNull;

public class NewVideoAdapter extends BaseQuickAdapter<News, BaseViewHolder> {


    public NewVideoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, News news) {

    }
}
