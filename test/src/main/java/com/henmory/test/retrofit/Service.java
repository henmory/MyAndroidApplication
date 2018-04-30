package com.henmory.test.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * author: henmory
 * time:  4/3/18
 * function:
 * description:
 */

public interface Service {

    @GET("/")
    Call<String> getContent();
}
