package com.material.mao.materialstudy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.material.mao.materialstudy.R;
import com.material.mao.materialstudy.entity.BaseHouseEntity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2014/12/5.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<BaseHouseEntity> mDataset;

    public MyAdapter(List<BaseHouseEntity> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.mTvName.setText(mDataset.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void removeItem(int position){
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
    public void addItem(int position){
        mDataset.add(position,new BaseHouseEntity("美丽屋 -> "+position));
        notifyItemInserted(position);
    }
    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'my_text_view.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Inmite Developers (http://inmite.github.io)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder{
        @InjectView(R.id.iv_head)
        ImageView mIvHead;
        @InjectView(R.id.tv_name)
        TextView mTvName;
        @InjectView(R.id.tv_description)
        TextView mTvDescription;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }

    }
}
