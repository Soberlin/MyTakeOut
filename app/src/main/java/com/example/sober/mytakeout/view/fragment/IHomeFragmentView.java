package com.example.sober.mytakeout.view.fragment;

import com.example.sober.mytakeout.model.bean.HomeData;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/5.
 * 你能我就能****
 */

interface IHomeFragmentView {
    void showLoading();

    void showRx(HomeData homedata);

    void showError(String msg);
}
