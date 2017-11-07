package com.example.sober.mytakeout.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sober.mytakeout.R;
import com.example.sober.mytakeout.view.holder.SimpleHomeHolder;

import java.util.List;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public class SimpleHomeAdapter  extends RecyclerView.Adapter<SimpleHomeHolder> {
    private List<String>  mData;

    public SimpleHomeAdapter(List<String> mData) {
        this.mData = mData;
    }


    @Override
    public  SimpleHomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_outteradapter, parent, false);
            SimpleHomeHolder sh = new SimpleHomeHolder(view);
            return sh;
    }

    @Override
    public void onBindViewHolder(SimpleHomeHolder holder, int position) {
         String  item=mData.get(position);


    }

    @Override
    public int getItemCount() {
        /**
         * 增加一项  头部
         */
        return mData.size();
    }


}
