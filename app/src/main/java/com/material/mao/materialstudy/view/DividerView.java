package com.material.mao.materialstudy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2014/12/7.
 */
public class DividerView extends RecyclerView.ItemDecoration {
    private static final int ATTRS[] = {android.R.attr.listDivider};
    private Drawable mDivider;
    public DividerView(Context context){
        TypedArray array = context.obtainStyledAttributes(ATTRS);
        mDivider = array.getDrawable(0);
        array.recycle();
    }
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int left = parent.getLeft();
        int right = parent.getWidth()-parent.getPaddingRight();
        int itemCount = parent.getChildCount();
        for(int index = 0;index<itemCount;index++){
            View itemView = parent.getChildAt(index);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)itemView.getLayoutParams();
            int top = itemView.getBottom()+params.bottomMargin;
            int bottom = top+mDivider.getIntrinsicHeight();

            mDivider.setBounds(left,top,right,bottom);
            mDivider.draw(c);
        }
    }

}
