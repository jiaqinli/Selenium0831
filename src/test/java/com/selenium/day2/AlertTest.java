package com.selenium.day2;/*
created by LJQ on 2020-8-2   
*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
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
    //点击警告弹窗的确定
    @Test
    public void alertTest(){
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        try {
            Thread.sleep(2000);//点击了弹窗按钮之后，alert不一定马上就出来，所以一般处理alert的时候，先等待个1S
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();//将driver重定向到alert上，把控制权交给alert，并且点击alert上的确定（accept方法）
    }
    //点击提示框的取消、确定
    @Test
    public void confirmTest(){
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
        driver.findElement(By.className("confirm")).click();
        try {
            Thread.sleep(2000);//和alert一个道理
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();//点击取消
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();//点击确定
    }
    //带输入框的弹窗，输入一个值后点击确定
    @Test
    public void promptTest(){
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
        driver.findElement(By.className("prompt")).click();
        try {
            Thread.sleep(2000);//和alert一个道理
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("这个是prompt");//chromeDriver有BUG，无法在带输入框的弹窗中输入值，要看效果可使用火狐
        alert.accept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(alert.getText());//获取到弹窗信息：你点击的结果是-确定
        alert.accept();
    }
}
