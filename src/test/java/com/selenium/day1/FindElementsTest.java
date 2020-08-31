package com.selenium.day1;/*
created by LJQ on 2020-7-30   
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver driver;
    @BeforeMethod
    public void getConn(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void quitConn(){
        driver.quit();
    }
    // 查找时看看有没有重复属性
    //id可能是个随机数，可能不是一个固定值，是个坑
    //一般定位就用id name xpath
    @Test
    public void find() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement webElement;
        //webElement = driver.findElement(By.id("kw"));
       // webElement = driver.findElement(By.name("wd"));
        //webElement = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        webElement = driver.findElement(By.cssSelector("#kw"));
        webElement.sendKeys("淘宝网");
        Thread.sleep(2000);
       // webElement = driver.findElement(By.id("su"));
        webElement = driver.findElement(By.xpath("//*[@id=\"su\"]"));
        // webElement = driver.findElement(By.className("btn self-btn bg s_btn"));报错
        webElement.click();
        Thread.sleep(2000);
        webElement = driver.findElement(By.partialLinkText("淘我喜欢"));//模糊查询
        String text = webElement.getText();
        System.out.println("这个标签的文本是："+text);
        webElement.click();
        Thread.sleep(2000);
        List<WebElement> webElements = driver.findElements(By.tagName("a"));
        System.out.println("该页面a标签数量为："+webElements.size());
    }
}
