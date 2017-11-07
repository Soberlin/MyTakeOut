package com.example.sober.mytakeout.model.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class HomeData {


    public HeadInfo head;
    public List<SellerDetail> body;

    public static class HeadInfo {

        public List<CategorieListInfo> categorieList;
        public List<PromotionListInfo> promotionList;


        public static class CategorieListInfo {
            public int id;
            public String name;
            public String pic;
        }

        public static class PromotionListInfo {
            public int id;
            public String info;
            public String pic;
        }
    }

    public static class SellerDetail implements Serializable {
        public SellerInfo seller;
        public int type;
        public List<String> recommendInfos;

        public static class SellerInfo implements Serializable {
            public String deliveryFee;
            public String distance;
            public String ensure;
            public int id;
            public String invoice;
            public String name;
            public String pic;
            public String recentVisit;
            public String sale;
            public String score;
            public int sendPrice;
            public String time;
            public List<?> activityList;
        }
    }
}
