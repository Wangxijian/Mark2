package com.stark.mark2.adapter.base;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemBaseHolder extends RecyclerView.ViewHolder {

    private RecyclerView.Adapter recyclerBaseAdapter;

    public RecyclerItemBaseHolder(View itemView) {
        super(itemView);
    }

    public RecyclerView.Adapter getRecyclerBaseAdapter() {
        return recyclerBaseAdapter;
    }

    public void setRecyclerBaseAdapter(RecyclerView.Adapter recyclerBaseAdapter) {
        this.recyclerBaseAdapter = recyclerBaseAdapter;
    }
}