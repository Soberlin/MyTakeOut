package com.example.sober.mytakeout.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.sober.mytakeout.R;
import com.example.sober.mytakeout.model.bean.HomeData;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/5.
 * 你能我就能****
 */

public class BussinessActivity extends BaseActivity {

    @InjectView(R.id.title)
    TextView title;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_business);
        ButterKnife.inject(this);
        initStatusBar(Color.GREEN);

        Intent intent = getIntent();

        HomeData.SellerDetail sellerDetail = (HomeData.SellerDetail) intent.getSerializableExtra("sellerDetail");

        title.setText(sellerDetail.seller.name);

        title.setTextSize(20);

        title.setTextColor(Color.RED);

    }


}
