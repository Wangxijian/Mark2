package com.stark.mark2.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.stark.mark2.R;
import com.stark.mark2.bean.Member;

import org.jetbrains.annotations.NotNull;

public class MemberAdapter extends BaseQuickAdapter<Member, BaseViewHolder> {
    private Context context;

    public MemberAdapter(Context context,int layoutResId) {
        super(layoutResId);
        this.context = context;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Member member) {
        holder.setText(R.id.name,member.getName());
        holder.setText(R.id.organization,member.getOrganization());
        holder.setText(R.id.position,member.getPosition());
        Glide.with(context).load(member.getIcon()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) holder.getView(R.id.img_icon));
    }

}
