package com.selenium.day1;/*
created by LJQ on 2020-7-29   
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseBrowserTest {
    @Test
    public void openAndCloseChrome() throws InterruptedException {
        //贴上driver的地址
        System.setProperty("webdriver.chrome.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        Thread.sleep(3000);
        // 关闭当前窗口 但是driver还在，可在任务管理器中查看
        webDriver.close();

        //关闭所有窗口并退出driver
        webDriver.quit();
    }
}
