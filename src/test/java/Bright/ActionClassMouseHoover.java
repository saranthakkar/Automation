package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionClassMouseHoover {
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
    public void action() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000);");
        Thread.sleep(3000);

        WebElement mousehover = driver.findElement(By.id("mousehover"));
        Actions action = new Actions(driver);           // initialise the object
        action.moveToElement(mousehover).perform();
        Thread.sleep(3000);

        WebElement subElement = driver.findElement(By.linkText("Top"));
        action.moveToElement(subElement).click().perform();
        Thread.sleep(3000);
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
