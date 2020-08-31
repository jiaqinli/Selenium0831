package com.selenium.day2;/*
created by LJQ on 2020-8-2   
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {
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
    public void selectTest() throws InterruptedException {
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
        webElement = driver.findElement(By.id("moreSelect"));
        Select select = new Select(webElement);
        //通过索引选择
        select.selectByIndex(0);
        Thread.sleep(2000);
        //通过value选择
        select.selectByValue("huawei");
        Thread.sleep(2000);
        //通过标签包含的文本选择
        select.selectByVisibleText("xiaomi");
        Thread.sleep(2000);
    }
}
