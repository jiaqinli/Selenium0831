package com.selenium.day1;/*
created by LJQ on 2020-7-29   
*/

import org.testng.Assert;
import org.testng.annotations.Test;

public class TsestNGDemo02 {
    @Test
    public void assertEqualTest(){
        String a = "ljq";
        String b = "ljq1";
        Assert.assertEquals(a,b,a+"不等于"+b);
        //Assert.assertEquals(a,b);
    }
    @Test
    public void assertNotEqualTest(){
        System.out.println("上一个CASE报错了，貌似不会执行到这里");
        String a = "ljq";
        String b = "ljq1";
        //Assert.assertNotEquals(a,b,a+"不等于"+b);
        Assert.assertNotEquals(a,b);
    }
    @Test
    public void assertNotNullTest(){
        String a = "ljq";
        Assert.assertNotNull(a);
    }
    @Test
    public void assertNullTest(){
        String a = "ljq";
        Assert.assertNull(a);
    }
}
