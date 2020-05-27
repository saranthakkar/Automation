package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchiFrame {
    public static WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
    }
    @Test
    public void iFrame() throws InterruptedException {
        Thread.sleep(3000);
        driver.switchTo().frame("courses-iframe");   //ID Locator of iframe

        WebElement searchCourse = driver.findElement(By.id("search-courses"));
        searchCourse.sendKeys("Java");

        driver.switchTo().defaultContent();

        WebElement bmwradio = driver.findElement(By.id("bmwradio"));
        bmwradio.click();
    }
}
