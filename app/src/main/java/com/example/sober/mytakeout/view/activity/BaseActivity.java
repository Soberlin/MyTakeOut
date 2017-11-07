package com.example.sober.mytakeout.view.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Author:LiuGuo
 * Email:1451606804@qq.com
 * Created data: Sober on 2017/11/4.
 * 你能我就能****
 */

public class BaseActivity   extends AppCompatActivity{


    protected   void  initStatusBar( int color){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            Window window=getWindow();
            WindowManager.LayoutParams  params=window.getAttributes();
            params.flags|=WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            window.setAttributes(params);
        }



        /**
         * 首先创建着色管理者   支持着色  设置颜色
         */
        SystemBarTintManager    manager=new SystemBarTintManager(this);
        manager.setStatusBarTintEnabled(true);
        manager.setStatusBarTintColor(color);

    }


}
