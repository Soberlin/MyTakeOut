package com.example.sober.mytakeout.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sober.mytakeout.R;
import com.example.sober.mytakeout.view.fragment.HomeFragment;
import com.example.sober.mytakeout.view.fragment.MoreFragment;
import com.example.sober.mytakeout.view.fragment.MyFragment;
import com.example.sober.mytakeout.view.fragment.OrderFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity{

    @InjectView(R.id.home_fragments)
    FrameLayout homeFragments;
    @InjectView(R.id.home_tabs)
    LinearLayout homeTabs;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;
    private int mCurrentTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        /**
         * 初始化下面的选项卡
         */
        mCurrentTab = 0;
        initTabs();
        initStatusBar(Color.parseColor("#3F51B5"));
    }

    private void initTabs() {
        final int childCount = homeTabs.getChildCount();

        for (int i = 0; i < childCount; i++) {
            FrameLayout frameLayout = (FrameLayout) homeTabs.getChildAt(i);

            final int curr = i;
            /**
             * 设置单击事件
             */
            frameLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCurrentTab = curr;

                    Sethighlight(childCount);
                }
            });

        }

        Sethighlight(childCount);

    }

    private void Sethighlight(int childCount) {
        for (int i = 0; i < childCount; i++) {
            /**
             * 获取子元素
             */
            FrameLayout frameLayout = (FrameLayout) homeTabs.getChildAt(i);
            ImageView img = (ImageView) frameLayout.getChildAt(0);
            TextView text = (TextView) frameLayout.getChildAt(1);

            if (mCurrentTab == i) {
                img.setEnabled(false);
                text.setEnabled(false);
            } else {
                img.setEnabled(true);
                text.setEnabled(true);
            }
        }


        /**
         * 进行切换
         */

        getSupportFragmentManager().beginTransaction().replace(R.id.home_fragments,mPages[mCurrentTab]).commit();
    }


    /**
     * 切换Fragment
     */

    private Fragment[] mPages = new Fragment[]{
            new HomeFragment(),
            new MoreFragment(),
            new MyFragment(),
            new OrderFragment()
    };


}
