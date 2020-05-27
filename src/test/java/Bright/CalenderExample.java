package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalenderExample {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.southalltravel.co.uk/");
        driver.manage().window().maximize();
    }

    @Test

    public void SouthallTravel() {

        WebElement departingBox = driver.findElement(By.id("deptdt"));
        departingBox.click();

        List<WebElement> allMaydates = driver.findElements(By.cssSelector(".ui-state-default"));

        for (WebElement date : allMaydates) {
            System.out.println(date.getText());  /* to print all dates */

            if (date.getText().equals("9")) {
                date.click();
            }
        }

        WebElement returnBox = driver.findElement(By.id("rtndt"));
        returnBox.click();

        List<WebElement> returdates = driver.findElements(By.cssSelector(".ui-state-default"));

        for (WebElement returndate : returdates) {
            System.out.println(returndate.getText());

            if (returndate.getText().contains("20")) {
                returndate.click();
            }
        }
    }

    @Test
public void expedia(){

        driver.navigate().to("https://www.expedia.co.uk/");

        WebElement Cookie = driver.findElement(By.xpath("//span[@class='button-text']"));
        Cookie.click();

        WebElement flightbutton = driver.findElement(By.xpath("//span[contains(text(),'Flights')]"));
        flightbutton.click();

        WebElement departurebox = driver.findElement(By.id("flight-departing-hp-flight"));
        departurebox.click();

        WebElement Maycalendermonth = driver.findElement(By.xpath("//div[contains(@class,'col gcw-date-field')]//div[2]//table[1]"));
        //System.out.println(Maycalendermonth.isDisplayed());

        List<WebElement> alldates = Maycalendermonth.findElements(By.cssSelector(".datepicker-cal-date"));

        for (WebElement alldate: alldates){
            //System.out.println(alldate.getText());

            if (alldate.getText().contains("29")){
                alldate.click();
   }
}
}
}
