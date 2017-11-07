package com.example.sober.mytakeout.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sober.mytakeout.R;
import com.example.sober.mytakeout.view.holder.HeaderViewHolder;
import com.example.sober.mytakeout.view.holder.SimpleHomeHolder;

import java.util.List;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public class MultiHomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    /**
     * 头部 (广告头   八个类别     附近商家)
     */
    public static final int ITEM_HEADER=0;


    /**
     *商家列表
     */
    public static final int  ITEM_Business=1;





    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return ITEM_HEADER;
        }else {
            return ITEM_Business;
        }
        /*return super.getItemViewType(position);*/
    }
    private List<String>  mData;
    public MultiHomeAdapter(List<String> mData) {
        this.mData = mData;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==ITEM_Business) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_outteradapter, parent, false);
            SimpleHomeHolder sh = new SimpleHomeHolder(view);
            return sh;

        }else{
            /**
             * 头部
             */
            View   headView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header,parent,false);
            HeaderViewHolder hh=new HeaderViewHolder(headView);
            return  hh;
        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
/*
         String  item=mData.get(position);
*/
     int  itemType=getItemViewType(position);

        if (itemType==ITEM_HEADER){

            /**
             * 不处理
             */
        }else{

            String item = mData.get(position - 1);
            SimpleHomeHolder   sh= (SimpleHomeHolder) holder;

           /* sh.tvOutterAdapterText*/

        }





    }


    @Override
    public int getItemCount() {
        return mData.size()+1;
    }


}
