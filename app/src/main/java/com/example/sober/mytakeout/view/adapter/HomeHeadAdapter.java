package com.example.sober.mytakeout.view.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.sober.mytakeout.R;
import com.example.sober.mytakeout.model.bean.HomeData;
import com.example.sober.mytakeout.view.activity.BussinessActivity;
import com.example.sober.mytakeout.view.holder.HeaderViewHolder;
import com.example.sober.mytakeout.view.holder.RecommendHolder;
import com.example.sober.mytakeout.view.holder.SimpleHomeHolder;

import java.util.List;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public class HomeHeadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    /**
     * 头部 (广告头   八个类别     附近商家)
     */
    public static final int ITEM_HEADER = 0;


    /**
     * 商家列表
     */
    public static final int ITEM_Business = 1;


    /**
     * 推荐
     */
    private static final int ITEM_RECOMMEND = 2;


    private HomeData homedata;


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_HEADER;
        } else {

            HomeData.SellerDetail seller = homedata.body.get(position - 1);

            if (seller.type == 0) {

                return ITEM_Business;
            } else {
                return ITEM_RECOMMEND;

            }


        }
        /*return super.getItemViewType(position);*/
    }

    public HomeHeadAdapter(HomeData homedata) {
        this.homedata = homedata;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_Business) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seller, parent, false);
            SimpleHomeHolder sh = new SimpleHomeHolder(view);
            return sh;

        } else if (viewType == ITEM_RECOMMEND) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recomend, parent, false);
            RecommendHolder sh = new RecommendHolder(view);
            return sh;
        } else {
            /**
             * 头部
             */
            View headView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
            HeaderViewHolder hh = new HeaderViewHolder(headView);
            return hh;
        }

    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
/*
         String  item=mData.get(position);
*/
        int itemType = getItemViewType(position);

        if (itemType == ITEM_HEADER) {
            /**
             * 负责处理头部数据
             */

            /**
             * 轮播大图
             */
            /**
             *把类型强转为  HeaderViewHolder
             */
            HeaderViewHolder hh = (HeaderViewHolder) holder;

            List<HomeData.HeadInfo.PromotionListInfo> items = homedata.head.promotionList;
            List<HomeData.HeadInfo.CategorieListInfo> cates = homedata.head.categorieList;


            /**
             * 显示图片
             */
            hh.showImages(items);

            /**
             * 显示类别
             */
            hh.showCategory(cates);

          /*  hh.showCat()*/

       /*     hh.layoutSlider*/


            /**
             * 八个类别
             */
        } else if (itemType == ITEM_RECOMMEND) {

            final HomeData.SellerDetail seller = homedata.body.get(position - 1);
            RecommendHolder   hd= (RecommendHolder) holder;
            hd.showRecommend(seller.recommendInfos);

        } else {

            final HomeData.SellerDetail sellerDetail = homedata.body.get(position - 1);
            SimpleHomeHolder sh = (SimpleHomeHolder) holder;
            /*sh.tvOutterAdapterText.setText(sellerDetail.seller == null ? "-----" : sellerDetail.seller.name);*/
           /* sh.tvOutterAdapterText*/
            sh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), BussinessActivity.class);
                    intent.putExtra("sellerDetail", sellerDetail);
                    view.getContext().startActivity(intent);
                }
            });


            sh.showSellerInfo(sellerDetail);
        }


    }


    @Override
    public int getItemCount() {
        return homedata.body.size() + 1;
    }


}
