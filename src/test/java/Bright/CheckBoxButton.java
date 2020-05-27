package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxButton {
    public static WebDriver driver;
    @Before
    public  void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
    }

    @Test
    public void CheckBox() {
        WebElement bmwRadioButton = driver.findElement(By.id("bmwcheck"));
        bmwRadioButton.click();

        WebElement benzRadioButton = driver.findElement(By.id("benzcheck"));
        benzRadioButton.click();

        WebElement hondaRadioButton = driver.findElement(By.id("hondacheck"));
        hondaRadioButton.click();
    }
}
