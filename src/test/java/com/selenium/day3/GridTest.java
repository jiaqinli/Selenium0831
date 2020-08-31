package com.selenium.day3;/*
created by LJQ on 2020-8-29   
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {
    @Test
    public void testChrome() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.104:4444/wd/hub"),dc);//指定地址
        driver.get("http://www.baidu.com");
        Thread.sleep(10000);
        driver.quit();
    }
    @DataProvider(name = "data4")
    public Object[][] test1(){
        return new Object[][]{
                {" http://192.168.0.104:5555","firefox"},
                {" http://192.168.0.104:5555","chrome"}
        };
    }
    @Test(dataProvider = "data4")
    public void testData(String url,String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = null;
        if (browser.equals("chrome")){
            desiredCapabilities=DesiredCapabilities.chrome();
        }else if(browser.equals("firefox")){
            desiredCapabilities=DesiredCapabilities.firefox();
        }else {
            System.out.println("error");
        }
        WebDriver driver=new RemoteWebDriver(new URL(url+"/wd/hub"),desiredCapabilities);
        driver.get("http://www.baidu.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
