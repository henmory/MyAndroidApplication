package com.henmory.rxjava_retrofit.test1;

import com.henmory.rxjava_retrofit.test1.Translation;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * author: henmory
 * time:  4/4/18
 * function:
 * description:
 */

public interface GetRequest_Interface {

    /**
     *  @author henmory
     *  @date 4/4/18
     *  @description 注解里传入 网络请求 的部分url
     *                 采用observable接口
     *                 getCall方法接受网络请求数据
     *
     *  @param
     *
     *  @return
    */
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20login")
    Observable<Translation> getCall();

    /**
     *  @author henmory
     *  @date 4/4/18
     *  @description 注解里传入 网络请求 的部分url
     *                 采用observable接口
     *                 getCall方法接受网络请求数据
     *
     *  @param
     *
     *  @return
     */
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20register")
    Observable<Translation1> getCall1();
}
