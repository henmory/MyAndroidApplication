package com.henmory.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("测试的一个类: ExampleUnitTest")
public class ExampleUnitTest {

    @Test
    @BeforeAll
    @DisplayName("method : initAll")
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

    }


    @Test
    @Disabled("for demonstration purposes")
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
}