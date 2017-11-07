package com.example.sober.mytakeout.view.holder;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sober.mytakeout.R;
import com.example.sober.mytakeout.model.bean.HomeData;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public class SimpleHomeHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.image)
    ImageView image;
    @InjectView(R.id.tvCount)
    TextView tvCount;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.ratingBar)
    RatingBar ratingBar;

    public SimpleHomeHolder(View itemView) {
        super(itemView);
        int l = R.layout.item_seller;
        ButterKnife.inject(this, itemView);
    }


    public void showSellerInfo(HomeData.SellerDetail sellerDetail) {
         if (sellerDetail.seller!=null){
             /**
              * 标题
              */
            tvTitle.setText(sellerDetail.seller.name);

             /**
              * 最大五颗星
              */
             ratingBar.setMax(5);
             /**
              * 服务器没有数据  写死三分
              */
             ratingBar.setRating(3f);

             tvCount.setText("月销售"+sellerDetail.seller.id);

         if (TextUtils.isEmpty(sellerDetail.seller.pic)){
             /**
              * 默认把图片设置肯德基
              */
             image.setImageResource(R.drawable.item_kfc);
             }else
             {
                 Picasso.with(ratingBar.getContext()).load(sellerDetail.seller.pic).into(image);
             }

         }




    }


}
