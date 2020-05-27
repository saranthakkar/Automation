package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionClassDragAndDrop {
    public static WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
    }
    @Test
    public void Droppable(){
        driver.switchTo().frame(0);

        WebElement dropFrom = driver.findElement(By.id("draggable")); //find elements for both boxes
        WebElement dropTo = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);                           //Initialised Action class
        action.dragAndDrop(dropFrom,dropTo).build().perform();          //Use method: dragAndDrop().build.perform
    }
}
//saran thakkar
