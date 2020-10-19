package com.techproed.paralelTesting;

import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void method1(){
        System.out.println("Test1 method1");
        System.out.println("Method1- Thread ID:"+Thread.currentThread().getId());
    }
    @Test
    public void method2(){
        System.out.println("Test1 method2");
        System.out.println("Method2- Thread ID:"+Thread.currentThread().getId());
    }
    @Test
    public void method3(){
        System.out.println("Test1 method3");
        System.out.println("Method3- Thread ID:"+Thread.currentThread().getId());
    }
}
