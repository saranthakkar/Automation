package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ListOfElements {

    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
    }

    @Test
    public void RadioButton() {
        List<WebElement> radiobuttons = driver.findElements(By.cssSelector("input[type=radio]"));

        for (WebElement radiobutton : radiobuttons) {
            System.out.println(radiobutton.getAttribute("value"));  // printout all the radiobutton by getting attribute
            //System.out.println(radiobutton.getText());   //cannot able to print the value by text
            //radiobutton.click();   // it will click on all radio one by one
            if (radiobutton.getAttribute("value").contains("honda")) {  //if condition
                radiobutton.click();
            }                                              // if condition will be inside the if each loop
        }
    }
}