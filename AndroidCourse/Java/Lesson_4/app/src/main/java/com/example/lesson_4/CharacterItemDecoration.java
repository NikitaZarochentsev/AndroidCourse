package com.example.lesson_4;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CharacterItemDecoration extends RecyclerView.ItemDecoration {

    private int offset;

    public CharacterItemDecoration(int offset) {
        this.offset = offset;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();

        if (layoutParams.getSpanIndex() % 2 == 0) {
            outRect.top = offset;
            outRect.left = offset;
            outRect.right = offset / 2;
        } else {
            outRect.top = offset;
            outRect.right = offset;
            outRect.left = offset / 2;
        }
    }
}
