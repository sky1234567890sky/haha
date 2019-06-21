package com.example.day09lianxicejiu.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 小乐乐 on 2019/6/10.
 */

public interface Lei {
    String url="https://www.wanandroid.com/";
    @GET("project/list/1/json?cid=294")
    Observable<FzBean> getData();
}
