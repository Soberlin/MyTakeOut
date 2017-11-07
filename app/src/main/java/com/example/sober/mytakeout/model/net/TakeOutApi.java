package com.example.sober.mytakeout.model.net;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public interface TakeOutApi {
    @GET(ApiUrls.HOME)
    Call<ResponseBean> getHomeData();

}
