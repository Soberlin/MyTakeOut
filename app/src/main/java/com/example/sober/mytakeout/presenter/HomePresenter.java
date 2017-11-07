package com.example.sober.mytakeout.presenter;

import android.text.TextUtils;

import com.example.sober.mytakeout.model.bean.HomeData;
import com.example.sober.mytakeout.model.net.ResponseBean;
import com.example.sober.mytakeout.model.net.RetrofitHttpUtil;
import com.example.sober.mytakeout.view.fragment.HomeFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public class HomePresenter implements IHomePresenter {

    /*private List<String> list=new ArrayList<>();*/

    HomeFragment  view;
    HomeData  homeData;

    public HomePresenter(HomeFragment view) {
        this.view = view;
    }

    @Override
    public void  loadData(){

        /**
         * 显示正在加载
         */
        view.showLoading();
/*
        for (int i = 0; i <=30; i++) {
            list.add("商家"+i);
        }
*/

        Call<ResponseBean>  call = RetrofitHttpUtil.getInstance().getHomeData();

        Callback<ResponseBean> callback=new Callback<ResponseBean>() {
            @Override
            public void onResponse(Call<ResponseBean> call, Response<ResponseBean> response) {
                /**
                 * 获取data字段的正常json格式
                 */
                ResponseBean data= response.body();
                String  json=data.data;

                if (TextUtils.isEmpty(json)){
                    view.showError("数据失踪");
                }else {
                    //view.showRx(list);

                    homeData=new Gson().fromJson(json,HomeData.class);
                    view.showRx(homeData);
                }


            }

            @Override
            public void onFailure(Call<ResponseBean> call, Throwable t) {

                view.showError("请求网络异常");

            }
        };
        call.enqueue(callback);
        /**
         * 显示数据
         */

    }




}
