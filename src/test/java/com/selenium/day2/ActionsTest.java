package com.selenium.day2;/*
created by LJQ on 2020-8-1   
*/

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.bind.Element;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ActionsTest {
    /*
    * 点击百度首页的某链接按钮
    *
    *点击：click()
    文本框输入文本：sendkeys()
    清空文本框：clear()
    获取文本：getText()
    获取title：getTitle()
    判断元素是否展示：isDisplayed()
    判断选择框是否选取：isSelected()
    判断输入框是否为可输入，某个按钮是否可点击，某个复选框是否能选择等是否处于激活状态的判断：isEnabled()
    截图

    * */
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
    public void rightClick() throws InterruptedException {
        driver.get("http:www.baidu.com");
        webElement = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.contextClick(webElement).perform();//perform代表执行
        //actions.contextClick().perform();//传参就在指定控件上右键，不传参就在页面左上方右键，火狐是鼠标在哪就在哪右键
        Thread.sleep(2000);
    }
    //双击
    @Test
    public void doubleClick() throws InterruptedException {
        driver.get("http:www.baidu.com");
        webElement = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.doubleClick(webElement).perform();//perform代表执行
        //actions.contextClick().perform();//和右击一样
        Thread.sleep(2000);
    }
    //移动鼠标到某个位置(做这类测试的时候，不要随便移动鼠标。。。）
    @Test
    public void moveMouseTest() throws InterruptedException {
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
        webElement = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();//perform代表执行
        Thread.sleep(2000);
    }
    //拖动鼠标到X,Y
    @Test
    public void dragTest() throws InterruptedException {
        driver.get("file:///D:/ForTestStudy/selenium_html/dragAndDrop.html");
        webElement = driver.findElement(By.id("drag"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(webElement,500,500).perform();//perform代表执行
        Thread.sleep(2000);
    }
    //拖动鼠标到X,Y
    @Test
    public void dropTest() throws InterruptedException {
        driver.get("file:///D:/ForTestStudy/selenium_html/dragAndDrop.html");
        webElement = driver.findElement(By.id("drag"));
        WebElement webElement1 =driver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.clickAndHold(webElement).moveToElement(webElement1).release();//按住 拖到指定控件 释放鼠标

       // actions.dragAndDrop(element,webElement);
        Thread.sleep(2000);
    }
    @Test
    public void mutiSelect() throws InterruptedException {
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
        driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list =driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver) ;
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();
        //按住shift 点击列表中第一个选项  再点击第三个 再松开shift ,若只想选其中几个，可以把shift换成ctrl CONTROL
       //Keys方法只提供了外围的键盘 像字母这些就没有 需要用到roboot类
        Thread.sleep(5000);
    }
    //ctrl+s enter保存页面
    @Test
    public void saveHtml() throws InterruptedException, AWTException {
        driver.get("http://www.baidu.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(2000);//发现这个地方必须等一下才按下一个键
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        //Keys方法只提供了外围的键盘 像字母这些就没有 需要用到roboot类
        Thread.sleep(2000);
    }
    //上传文件
    @Test
    public void uploadtest() throws InterruptedException {
        driver.get("file:///D:/ForTestStudy/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys("C:\\Users\\ASUS\\Pictures\\QQ浏览器截图\\QQ浏览器截图20190128103108.png");
        Thread.sleep(6000);
    }

    @Test
    public void clickTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
       driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]")).click();
       b = "http://news.baidu.com/";
        Thread.sleep(2000);
        String handle1 = driver.getWindowHandle();
        //重定向了，case通过，否则一直获取的是百度链接，获取不到新闻链接
        for (String handles : driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }
            else{
                driver.switchTo().window(handles);
                break;
            }
        }
        a = driver.getCurrentUrl();//获取出来的不是预期值，获取到的是www.baidu.com????可能是没有重定向？ 确实没有重定向
        System.out.println(a);
        Assert.assertEquals(a,b);
    }
    @Test
    public void searchKeyWord() throws InterruptedException {
        driver.get("http://www.baidu.com");
        webElement = driver.findElement(By.id("kw"));
        webElement.sendKeys("selenium");
        b = webElement.getText();//这个标签获取的是标签本身中间的值，<>这里的中间值</>     所以此处是获取不到输入值的
        webElement = driver.findElement(By.id("su"));
        webElement.click();
        Thread.sleep(5000);
        a = driver.getTitle();
        Assert.assertEquals(a,"selenium_百度搜索");
        Assert.assertEquals(b,"selenium");
    }

    @Test
    public void someMethodsTest(){
        driver.get("http://www.baidu.com");
       a = driver.findElement(By.id("su")).getAttribute("value");//获取百度一下按钮的value值
        Boolean c,d;
        c = driver.findElement(By.id("su")).isDisplayed();//百度一下这个按钮页面上是否展示
        d = driver.findElement(By.id("kw")).isEnabled();//这个文本框是否能输入
       Assert.assertEquals(a,"百度一下");
       Assert.assertTrue(c);
        Assert.assertTrue(d);
    }
    @Test
    public void ScreenShot() throws IOException {
        driver.get("http://www.baidu.com/");
        //对百度首页进行截图,这个方法先记下来
        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("D:\\baidu.png"));
        //复制一份截图到另一个文件夹
        FileHandler.copy(new File("D:\\baidu.png"),new File("C:\\Users\\ASUS\\Desktop\\baidu.png"));
        //下面是对上面两句命令的解释
/*        //        获取当前项目路径
        String currentPath = System.getProperty("user.dir");
//        强制转换driver为TakesScreenshot类型
        TakesScreenshot takename = (TakesScreenshot) driver;
//        截图
        File file = takename.getScreenshotAs(OutputType.FILE);
//        保存到D盘
        FileUtils.copyFile(file,new File("D:/test2.png"));
*/
    }
}
