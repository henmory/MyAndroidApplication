package com.henmory.rxjava_retrofit.test2;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description:
 */
public interface APIService {

    @GET("top250")
    Observable<Movie> getTopMovie(@Query("start") int start, @Query("count") int count);
}
