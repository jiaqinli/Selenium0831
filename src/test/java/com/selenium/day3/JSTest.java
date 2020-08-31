package com.selenium.day3;/*
created by LJQ on 2020-8-4   
*/

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {
    //通过JS去修改文本框的最大长度
    WebDriver driver;
    WebElement webElement;
    String a,b;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void quitConn(){
        driver.quit();
    }
    //鼠标右键
    @Test
    public void exJS() throws InterruptedException {
        driver.get("http:www.baidu.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"maxlength\",\"10000\")");
        Thread.sleep(5000);
    }
    }
