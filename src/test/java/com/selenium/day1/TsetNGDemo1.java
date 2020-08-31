package com.selenium.day1;

import org.testng.annotations.*;

public class TsetNGDemo1 {
    @BeforeTest
    public void beforetest1(){
        System.out.println("这是@BeforeTest beforetest1");
    }
    @BeforeMethod
    public void beforeMethod1(){
        System.out.println("这是@BeforeMethod beforeMethod1");
    }
    @AfterClass
    public void AfterClass1(){
        System.out.println("这是@AfterClass AfterClass1");
    }
    @AfterMethod
    public void AfterMethod1(){
        System.out.println("这是@AfterMethod AfterMethod1");
    }
    @Test
    public void testCase1(){
        System.out.println("这是@Test testCase1");
    }
    @Test
    public void testCase2(){
        System.out.println("这是@Test testCase2");
    }
}
