package com.techproed.paralelTesting;

import org.testng.annotations.Test;

public class Test2 {
    @Test
    public void method4(){
        System.out.println("Test2 method4");
        System.out.println("Method4- Thread ID:"+Thread.currentThread().getId());
    }
    @Test
    public void method5(){
        System.out.println("Test2 method5");
        System.out.println("Method5- Thread ID:"+Thread.currentThread().getId());
    }
    @Test
    public void method6(){
        System.out.println("Test2 method6");
        System.out.println("Method6- Thread ID:"+Thread.currentThread().getId());
    }
}
