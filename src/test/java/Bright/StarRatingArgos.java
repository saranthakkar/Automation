package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StarRatingArgos {
    public static WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:search:term:nike");
        driver.manage().window().maximize();
    }
    @Test
    public void starRating() {
        JavascriptExecutor js = (JavascriptExecutor) driver; //initialising scroll so that automation can click on StarRating
        js.executeScript("window.scrollBy(0,800);");

        List<WebElement> radiobuttons = driver.findElements(By.cssSelector(".RadioListstyles__Label-sc-4132xt-5.gywEET"));

        for (WebElement radiobutton : radiobuttons){
            System.out.println(radiobutton.getAttribute("id"));  //to print out all options from list

            if (radiobutton.getAttribute("id").contains("3 or more-label")){
                radiobutton.click();                             // to click on one of 6 options
            }
        }
    }
}
