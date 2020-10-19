package com.techproed.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priority_DependsOnMethod {

    @Test(priority = 1)
    public void login(){
        System.out.println("BU method login");
    }

    @Test(priority = 2,dependsOnMethods = "login")
    public void homepage(){
        System.out.println("BU method homepage");
    }

    @Test(priority = 3)
    public void search() {
        System.out.println("BU method search");
    }

    @Test(priority = 4,dependsOnMethods = "search")
    public void result(){
        System.out.println("BU method result");
    }
}
