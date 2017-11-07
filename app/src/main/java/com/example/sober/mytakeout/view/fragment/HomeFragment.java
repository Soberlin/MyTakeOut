package com.example.sober.mytakeout.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sober.mytakeout.R;
import com.example.sober.mytakeout.model.bean.HomeData;
import com.example.sober.mytakeout.presenter.HomePresenter;
import com.example.sober.mytakeout.view.adapter.HomeHeadAdapter;


import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public class HomeFragment extends Fragment implements IHomeFragmentView {

    @InjectView(R.id.rv)
    RecyclerView rv;

    @InjectView(R.id.activity_main)
    FrameLayout activityMain;

    @InjectView(R.id.pb)
    ProgressBar pb;

    HomePresenter presenter;

    @InjectView(R.id.toolbar)
    LinearLayout toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.inject(this, view);

        presenter = new HomePresenter(this);
        presenter.loadData();
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    /**
     * 显示正在加载数据
     */
    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }


    /**
     * 显示数据
     *
     * @param
     */
    @Override
    public void showRx(HomeData homedata) {
        /**
         * 隐藏正在加载的progr
         */
        pb.setVisibility(View.GONE);

        /**
         * 设置布局方式
         */
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        HomeHeadAdapter  adapter=new HomeHeadAdapter(homedata);

        rv.setAdapter(adapter);
        /**
         * 设置适配器
         */
     /*   MultiHomeAdapter adapter = new MultiHomeAdapter(homedata);



      /**
         * 滚动事件监听器
         */

        rv.addOnScrollListener(listener);

    }


    /**
     * 设置recy
     */


    int mDistance = 0;
    int mMaxDistance = 200;
    private RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            mDistance += dy;
            if (mDistance <= mMaxDistance) {
                float percent = mDistance * 1f;
                int alpha = (int) (percent * 255);
                int argb = Color.argb(alpha, 57, 174, 255);
                /**
                 * 设置个标题
                 */
                toolbar.setBackgroundColor(argb);

            } else {

                int argb = Color.argb(255, 57, 174, 255);
                /**
                 * 设置个标题
                 */
                toolbar.setBackgroundColor(argb);
            }

        }
    };

    @Override
    public void showError(String msg) {

        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
