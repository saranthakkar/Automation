package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PriceRangeArgos {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();
    }
    @Test
    public void priceRange(){
        WebElement SearchBar = driver.findElement(By.id("searchTerm"));
        SearchBar.sendKeys("nike");

        WebElement SearchButton = driver.findElement(By.className("_1gqeQ"));
        SearchButton.click();

        List<WebElement> priceranges = driver.findElements(By.cssSelector("label[name=price]"));

            for (WebElement pricerange : priceranges){
                System.out.println(pricerange.getAttribute("value"));

                if (pricerange.getAttribute("value").contains("£10 - £15")){
                    pricerange.click();
                }
        }
    }
}
