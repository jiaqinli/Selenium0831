package com.selenium.day3;/*
created by LJQ on 2020-8-6   
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailTest {
    WebDriver driver;
    WebElement element;
    String userName = "lijiaqin557",password = "lijiaqin007";
    @BeforeMethod
    public void coon(){
        System.setProperty("webdriver.chrome.driver","D:\\IDEworkspace\\FirstMaven_Demo_01\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
    @Test
    public void reg(){
        driver.get("https://mail.163.com/");
        driver.findElement(By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]")).click();
        String handle1 = driver.getWindowHandle();
        for (String handles : driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }
            else{
                driver.switchTo().window(handles);
                break;
            }
        }
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("phone")).sendKeys("18786949693");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[4]/span")).click();
        driver.findElement(By.className("j-register")).click();
        System.out.println(driver.findElement(By.className("j-register")).getText());//立即注册 定位到了，为什么没有点击到
        //判断注册是否成功

        String success = driver.findElement(By.xpath("/html/body/div[2]/div/p/text()")).getText();//返回注册成功即标识成功了
        Assert.assertEquals(success," 注册成功！");
    }
    @Test
    public void login(){
        driver.get("https://mail.163.com/");
        WebElement frame=driver.findElement(By.xpath( "/html/body/div[2]/div[3]/div/div[3]/div[4]/div[1]/div[1]/iframe" ));
        driver.switchTo().frame(frame);
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("dologin")).click();
		//显示等待
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("spnUid")));
        //判断登录是否成功
        String uName = driver.findElement(By.id("spnUid")).getText();
        Assert.assertEquals(uName,userName+"@163.com");
    }
    @Test
    public void sendEmail(){
        driver.get("https://mail.163.com/");
        WebElement frame = driver.findElement(By.xpath( "/html/body/div[2]/div[3]/div/div[3]/div[4]/div[1]/div[1]/iframe" ));
        driver.switchTo().frame(frame);
        driver.findElement(By.name("email")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("dologin")).click();
       //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("spnUid")));
        
        String uName = driver.findElement(By.id("spnUid")).getText();
        System.out.println(uName);

        driver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/ul/li[2]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/section/header/div[1]/div[1]/div/div[2]")).sendKeys("467936661@qq.com");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/section/header/div[2]/div[1]/div")).sendKeys("测试邮件发送");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/section/header/div[3]/div[1]/div[2]/input")).sendKeys("C:\\Users\\ASUS\\Desktop\\baidu.png");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/header/div/div[1]/div/span[2]")).click();
    }
}
