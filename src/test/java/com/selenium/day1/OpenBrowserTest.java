package com.selenium.day1;/*
created by LJQ on 2020-7-29   
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {
    @Test
    public void openFireFox(){
        //默认的安装路径可以这么写
        WebDriver webDriver = new FirefoxDriver();
    }

    @Test
    public void openFireFox2(){
        //贴上Firefox EXE的路径
        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
    }
    @Test
    public void openChrome(){
        //贴上driver的地址
        System.setProperty("webdriver.chrome.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
    }
    @Test
    public void openIE(){
        //贴上driver的地址
        System.setProperty("webdriver.ie.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();
    }
    @Test
    public void openEdge(){
        //贴上driver的地址
        System.setProperty("webdriver.edge.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\MicrosoftWebDriver.exe");
        WebDriver webDriver = new EdgeDriver();


    }
}
