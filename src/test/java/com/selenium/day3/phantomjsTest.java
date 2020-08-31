package com.selenium.day3;/*
created by LJQ on 2020-8-4   
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class phantomjsTest {
    @Test
    public void pjs() throws InterruptedException {
       //相当于后台启用，不会打开任何的浏览器
        System.setProperty("phantomjs.binary.path","D:\\testENV\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(2000);
        String a = driver.getTitle();
        System.out.println("a is "+a);
        driver.quit();
    }
}
