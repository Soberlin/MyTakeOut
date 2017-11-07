package com.example.sober.mytakeout.view.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.example.sober.mytakeout.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectViews;

/**
 * Created by Administrator on 2016/12/13.
 */

public class RecommendHolder extends RecyclerView.ViewHolder {
    @InjectViews({R.id.text1, R.id.text2, R.id.text3, R.id.text4, R.id.text5, R.id.text6})
    public List<TextView> texts;

    public RecommendHolder(View itemView) {
        super(itemView);
        int layoutid = R.layout.item_recomend;
        ButterKnife.inject(this, itemView);
    }

    public void showRecommend(List<String> recommendInfos) {
        for (int i = 0; i < recommendInfos.size(); i++) {
            texts.get(i).setText(recommendInfos.get(i));
        }
    }
}
