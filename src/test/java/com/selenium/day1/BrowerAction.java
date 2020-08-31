package com.selenium.day1;/*
created by LJQ on 2020-7-29   
*/

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowerAction {
/**
 *打开百度 等待3s 退出
 *
 */
WebDriver driver;
@BeforeMethod
public void setProperty(){
    System.setProperty("webdriver.chrome.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\chromedriver.exe");
    driver = new ChromeDriver();
}
@Test
    public void chromeGetAction() throws InterruptedException {
    driver.get("http://www.baidu.com");//必须加上http
    Thread.sleep(3000);
    driver.quit();
}
    /**
     *后退 前进 刷新
     *
     */
    @Test
    public void chromeSomeAction() throws InterruptedException {
        driver.get("http://www.baidu.com");//必须加上http
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);

        //浏览器刷新
        driver.navigate().refresh();
        Thread.sleep(1000);
        //浏览器最大化
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //设置浏览器大小
       Dimension dimension = new Dimension(900, 800);
       driver.manage().window().setSize(dimension);
       Thread.sleep(1000);
        //获取当前页面URL
        String a = driver.getCurrentUrl();
        System.out.println(a);
        Thread.sleep(1000);
        //获取当前页面Title
      String b =  driver.getTitle();
      System.out.println(b);
        Thread.sleep(1000);

        driver.quit();
    }

}
