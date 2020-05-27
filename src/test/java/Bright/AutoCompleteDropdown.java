package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoCompleteDropdown {
    public static WebDriver driver;
    @Before
    public  void setup(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.expedia.co.uk/");
        driver.manage().window().maximize();
    }
    @Test
    public void expedia() throws InterruptedException {
        WebElement destinationfield = driver.findElement(By.xpath("//input[@id='hotel-destination-hp-hotel']"));
        System.out.println(destinationfield.isEnabled());    //to check boolean if element is enable or not

        destinationfield.sendKeys("Del");
        Thread.sleep(4000);


        List<WebElement> destinations = driver.findElements(By.cssSelector("li[class=results-item]"));

        for (WebElement destination : destinations){
            System.out.println(destination.getText());

           if (destination.getText().contains("Delhi (DEL - Indira Gandhi Intl.)")){
                destination.click();
                break;
            }
        }
    }
}
