package com.stark.mark2.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.stark.mark2.R;
import com.stark.mark2.bean.News;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NewsAdapter extends BaseMultiItemQuickAdapter<News, BaseViewHolder> {

    public NewsAdapter() {
        addItemType(News.TYPE_IMAGE_NO_IMAGE, R.layout.item_news_no_image);
        addItemType(News.TYPE_IMAGE_NORMAL, R.layout.item_news);
    }

    public NewsAdapter(@Nullable List<News> data) {
        super(data);

    }



    @Override
    protected void convert(@NotNull BaseViewHolder holder, News news) {
        switch (holder.getItemViewType()) {
            case News.TYPE_IMAGE_NORMAL:
                holder.setText(R.id.title, news.getNewsTitle());
                holder.setText(R.id.source, news.getNewsSource());
                holder.setText(R.id.date, news.getNewsDate());
                holder.setImageResource(R.id.img, news.getNewsImage());
                break;
            case News.TYPE_IMAGE_NO_IMAGE:
                holder.setText(R.id.title, news.getNewsTitle());
                holder.setText(R.id.source, news.getNewsSource());
                holder.setText(R.id.date, news.getNewsDate());
                break;
        }
    }


//    @Override
//    protected void convert(@NotNull BaseViewHolder holder, News news) {

//    }

}
