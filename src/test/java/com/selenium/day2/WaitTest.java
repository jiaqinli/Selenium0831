package com.selenium.day2;/*
created by LJQ on 2020-8-2   
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver driver;
    WebElement webElement;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        //不使用等待ms了，使用全局等待，设置超时时间,可设置时分秒等参数
        //超时时间内找到即继续，不用等待固定时间，比sleep灵活
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void quitConn(){
        driver.quit();
    }
    @Test
    public void waitTest() throws InterruptedException {
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
        webElement = driver.findElement(By.xpath("//*[@id=\"wait\"]/input"));
        webElement.click();
       // Thread.sleep(2000);
        //只等待传入的控件
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");
    }
}
