package com.henmory.rxjava_retrofit.test6;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author: henmory
 * time:  4/5/18
 * function:
 * description: 所有的服务请求，通过注解可以获取所有的参数，它的获取过程是通过java的反射机制，因为，当我们给类／属性／方法加上注解之后，
 *              工作它对应的class文件的反射机制可以获取到类／属性／方法上的所有注解信息，而在这些注解中，就是键值对，这些键值对就是我们
 *              进行http请求时需要用的
 *              这样的一个机制就是把http的请求转换成了通过注解获取这些参数，保证与网络请求的解藕，使程序结构更灵活
 *
 *
 *              请求参数获取需要的元素
 *                  1.自定义注解，retrofit已经帮我们定义好
 *                  2.注解对应的值，1.我们定义接口时，有些已经生成如@GET("top250")，有些需要我们调用该方法时生成，如@Query("start") int start
 *                  3.通过调用反射机制提取这些值，retrofit的create函数做到了
 *                  4.通过上面的步骤，retrofit就获取了这些键值对，然后它内部再拼接http请求
 *                  5.这样就解释了通过注解获取参数的过程
 *
 *              retorfit获取参数的方式采用动态代理的方式：
 *                  1.该类为接口类，里面有一部分请求参数，另一些请求参数在调用该接口时传入
 *                  2.retrofit的create方法中，通过Proxy的createNewInstance动态创建了APIService接口的对象并返回回去这就是动态代理类的精髓
 *                  3.在createNewInstance这个方法中，还需要new一个InvocationHandler对象，在它的invoke中，调用所有的方法
 *                  4.也就是当我们调用Proxy创建出来的对象的方法时，就会把invoke的参数填满包括（method, args），进而调用到实际方法
 *                  5.这里具体为什么会回调invoke方法，这是jdk这个框架给我设计好的，这个不用管
 *
 *
 */
public interface APIService {

    @GET("top250")
    Observable<Movie> getTopMovie(@Query("start") int start, @Query("count") int count);
}
