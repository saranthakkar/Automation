package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Screenshot {
    public static WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void result() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.id("u_0_b"));
        loginButton.click();
        Thread.sleep(4000);   //very imp to allow Selenium webdriver to take screenshot
    }
    @After
    public void teardown() throws IOException {
        TakesScreenshot screenshot =((TakesScreenshot) driver);                      //method to initialise Screenshot
        File sourcefile = screenshot.getScreenshotAs(OutputType.FILE);               //method to take screenshot
        File destinationfile = new File("D:\\Desktop\\ScreenShotFile.png");//select folder in your laptop where to save
        FileUtils.copyFile(sourcefile,destinationfile);                              //Saving screenshot in relevant folder
    }
}
