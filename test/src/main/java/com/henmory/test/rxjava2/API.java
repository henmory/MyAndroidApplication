package com.henmory.test.rxjava2;


import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;

/**
 * author: henmory
 * time:  4/4/18
 * function:
 * description:
 */

public interface API {

    @GET
    Observable<String> login(@Body String request);


    @GET
    Observable<String> register(@Body String request);
}
