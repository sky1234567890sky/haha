package com.example.day09lianxicejiu.dao;

import android.app.Application;

/**
 * Created by 小乐乐 on 2019/6/10.
 */

public class Api extends Application {
    private static Api mApi;

    @Override
    public void onCreate() {
        super.onCreate();
        mApi=this;
    }

    public static Api getmApi() {
        return mApi;
    }
}
