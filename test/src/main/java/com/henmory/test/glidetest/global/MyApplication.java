package com.henmory.test.glidetest.global;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * author: henmory
 * time:  4/11/18
 * function:
 * description:
 */
public class MyApplication extends Application {

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;



    private static MyApplication app;
    @Override
    public void onCreate() {
        super.onCreate();

        //初始化屏幕宽高
        getScreenSize();

    }

    private void getScreenSize(){
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();

        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }

    public static MyApplication getApp() {
        return app;
    }

}
