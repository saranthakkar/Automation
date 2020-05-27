package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitExplicitWait {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void implicit(){
        WebElement loginbutton = driver.findElement(By.linkText("Login"));
        loginbutton.click();

        WebElement UserID = driver.findElement(By.id("user_email"));
        UserID.sendKeys("test");
    }


    @Test
    public void explicit(){
        WebElement loginbutton = driver.findElement(By.linkText("Login"));
        loginbutton.click();

        WebDriverWait wait = new WebDriverWait(driver,3);   //Initialising and giving time limit
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
        username.sendKeys("test");
        }
    }


