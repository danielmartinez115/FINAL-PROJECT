package com.example.finalmovieapp.views.grid;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MovieGridItemDecoration extends RecyclerView.ItemDecoration {

    private int spacing;

    public MovieGridItemDecoration(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spacing;
        outRect.right = spacing;
        outRect.top = spacing;
        outRect.bottom = spacing;
    }
}
