package com.example.sober.mytakeout.model.net;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public class RetrofitHttpUtil {

    private  static  TakeOutApi api;

    public  static  TakeOutApi  getInstance(){
      if (api==null)
      {
          Retrofit  retrofit=new Retrofit.Builder().
                  baseUrl(ApiUrls.BASE_URL).
                  addConverterFactory(GsonConverterFactory.create(new Gson())).
                  build();

          api=retrofit.create(TakeOutApi.class);
      }
       return  api;
    }


}
