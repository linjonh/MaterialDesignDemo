package com.material.mao.materialstudy.anim;

import android.support.v7.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

/**
 * Created by Administrator on 2014/12/7.
 */
public class MyItemAnimation extends RecyclerView.ItemAnimator {
    @Override
    public void runPendingAnimations() {
    }

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        YoYo.with(Techniques.FadeOutRight).duration(500).playOn(viewHolder.itemView);
        return true;
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        YoYo.with(Techniques.FadeInLeft).duration(500).playOn(viewHolder.itemView);
        return true;
    }

    @Override
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        return false;
    }

    @Override
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        return false;
    }

    @Override
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {

    }

    @Override
    public void endAnimations() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
