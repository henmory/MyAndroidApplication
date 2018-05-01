package com.henmory.junit5;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.condition.OS.MAC;


@DisplayName("测试的一个类: ExampleUnitTest")
public class ExampleUnitTest {

    /**
     *  @author henmory
     *  @date 5/1/18
     *  @description 标准测试生命周期
     *
     *  @param
     *
     *  @return
    */

    @Test
    @BeforeAll
    @DisplayName("method : initAll") //显示名字
    static void initAll(){
        System.out.println("initAll");
    }

    @Test
    @BeforeEach
    @DisplayName("method : init")
    void init(){
        System.out.println("init");
    }

    @Test
    @DisplayName("method : successfulTest")
    void successfulTest(){
        System.out.println("successfulTest");

    }

    @Test
    @DisplayName("method : failTest")
    void failTest(){
        System.out.println("failTest");
        assertThat(2+1, is(equalTo(3))); //三方断言库Hamcrest
    }


    @Test
    @Disabled("for demonstration purposes") //禁用测试
    @DisplayName("method : skippedTest")
    void skippedTest(){
        System.out.println("skippedTest");

    }

    @Test
    @AfterEach
    @DisplayName("method : tearDown")
    void tearDown(){
        System.out.println("tearDown");

    }

    @Test
    @AfterAll
    @DisplayName("method : tearDownAll")
    static void tearDownAll(){
        System.out.println("tearDownAll");

    }

    //假设＝＝＝与断言区别
    @Test
    void testAssume(){
//        assumingThat("DEV".equals("DEVA"), ()->{
//        });
    }

    //条件测试执行
    @Test
    @DisabledOnOs(MAC)
    void onlyOnMac(){

    }

}