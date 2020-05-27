package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelectClass {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:home:term:nike");
        driver.manage().window().maximize();
    }

    @Test
    public void ArgosSortByRelevance() throws InterruptedException {            //throws: declaring exception
        WebElement Relevance = driver.findElement(By.id("sort-select"));
        Select sel = new Select(Relevance);       //using Select Class
        Thread.sleep(3000);                 //giving waiting time

        sel.selectByVisibleText("Price: High - Low");
        Thread.sleep(3000);

        sel.selectByVisibleText("Price: Low - High");
        Thread.sleep(3000);

        // -------------------------------------------
        // List<WebElement> is used only to get print out on console.
        List<WebElement> options = sel.getOptions();                    //to get all options
        //List<WebElement> options = sel.getAllSelectedOptions();       //to get only selected options

      for(WebElement option : options){
        System.out.println(sel.getOptions());                           //to print all options
        //System.out.println(sel.getAllSelectedOptions());              //to print only selected options
    }
}
}
