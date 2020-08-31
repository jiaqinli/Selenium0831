package com.selenium.day2;/*
created by LJQ on 2020-8-2   
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;
    WebElement webElement;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void quitConn(){
        driver.quit();
    }
    @Test
    public void iframeTest(){
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
       //第一种方式
        //driver.switchTo().frame("aa");//通过id或者name重定向
        //第二种方式
        webElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(webElement);

        driver.findElement(By.linkText("baidu")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //将控制权移交给原来界面
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("登陆界面")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
