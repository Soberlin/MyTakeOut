package com.example.sober.mytakeout.view.holder;

import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.sober.mytakeout.R;
import com.example.sober.mytakeout.model.bean.HomeData;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.InjectViews;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    @InjectView(R.id.layout_slider)
    public SliderLayout layoutSlider;
    @InjectViews({R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5,R.id.img5,R.id.img6,R.id.img7,R.id.img8})
    public List<ImageView> imgs;
    @InjectViews({R.id.text1,R.id.text2,R.id.text3,R.id.text4,R.id.text5,R.id.text6,R.id.text7,R.id.text8})
    public List<TextView> texts;
   /* @InjectView(R.id.text1)
    TextView text1;
    @InjectView(R.id.img2)
    ImageView img2;
    @InjectView(R.id.text2)
    TextView text2;
    @InjectView(R.id.img3)
    ImageView img3;
    @InjectView(R.id.text3)
    TextView text3;
    @InjectView(R.id.img4)
    ImageView img4;
    @InjectView(R.id.text4)
    TextView text4;
    @InjectView(R.id.img5)
    ImageView img5;
    @InjectView(R.id.text5)
    TextView text5;
    @InjectView(R.id.img6)
    ImageView img6;
    @InjectView(R.id.text6)
    TextView text6;
    @InjectView(R.id.img7)
    ImageView img7;
    @InjectView(R.id.text7)
    TextView text7;
    @InjectView(R.id.img8)
    ImageView img8;
    @InjectView(R.id.text8)
    TextView text8;*/


   /* @InjectView(R.id.head_text)
    TextView headText;*/

    public HeaderViewHolder(View itemView) {
        super(itemView);
        int l = R.layout.item_header;
        ButterKnife.inject(this, itemView);
    }


    boolean isInit;

    public void showImages(List<HomeData.HeadInfo.PromotionListInfo> items) {

        if (!isInit){

            /**
             * 避免重复创建大图
             */
            for (HomeData.HeadInfo.PromotionListInfo item:items) {

                TextSliderView textSliderView = new TextSliderView(layoutSlider.getContext());
                /**
                 * 图片描述
                 */
                textSliderView.description(item.info);

                textSliderView.image(item.pic);

                layoutSlider.addSlider(textSliderView);

            }

            isInit=true;
        }


    }


    /**
     *显示类别
     * @param cates
     */
    public void showCategory(List<HomeData.HeadInfo.CategorieListInfo> cates) {
        for (int i = 0; i <cates.size() ; i++) {
            /**
             * 获取出一条数
             */
            HomeData.HeadInfo.CategorieListInfo categorieListInfo = cates.get(i);
            /**
             * 显示图片
             */

            Picasso.with(layoutSlider.getContext()).load(categorieListInfo.pic).into(imgs.get(i));

            /**
             * 显示文字标题
             */
           texts.get(i).setText(categorieListInfo.name);

        }

    }



}
