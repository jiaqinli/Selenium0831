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

public class OpenNewWindow {
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
    /*
    * 打开页面
    * 点击open new window
    * 操作新页面
    * */
    @Test
    public void windowSelect() throws InterruptedException {
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
        webElement = driver.findElement(By.className("open"));
        webElement.click();
        Thread.sleep(2000);
        String handle1 = driver.getWindowHandle();
        //获取新窗口的句柄值 几个handle相当于浏览器开了几个网页
        //循环取出页面所有的句柄，如果句柄不等于我们开的第一个页面的句柄，那就找到了非第一个页面了，移交即可
        //但是这个只适用于当前只有两个句柄的情况
        for (String handles : driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }
            else{
                driver.switchTo().window(handles);
                break;
            }
        }

        driver.findElement(By.linkText("baidu")).click();
    }
}
