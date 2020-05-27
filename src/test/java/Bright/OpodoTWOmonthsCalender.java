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

public class OpodoTWOmonthsCalender {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.opodo.co.uk/");
        driver.manage().window().maximize();
    }
    @Test
    public void Opodo(){

        String CurrentURL = driver.getCurrentUrl();
        System.out.println(CurrentURL);

        String CurrentTitle = driver.getTitle();
        System.out.println(CurrentTitle);

        JavascriptExecutor js = (JavascriptExecutor) driver;  //initialising scroll so that automation can click on date
        js.executeScript("window.scrollBy(0,800);");

        WebElement departuringBox = driver.findElement(By.xpath("//body[@id='viewport']/div[@id='flights-root']/div[@id='page']/div[contains(@class,'od-home-main-layout home_main_layout')]/div[contains(@class,'od-body-content body_content')]/section[@id='home']/div[contains(@class,'od-home-wrapper')]/div[contains(@class,'od-home-full-width-content odf-flex-item odf-flex-item-first')]/div[contains(@class,'od-home-content od-home-content-with-warning-top-message')]/div[contains(@class,'od-home-content-search')]/div[@id='flights-manager']/div[contains(@class,'')]/div[@class='od-flightsManager-content']/div[@class='od-flightsManager-main']/div[@class='od-flightsManager-row citysearch_group']/div[@class='od-flightsManager-cell']/div[2]/div[1]/div[1]/div[1]/div[2]"));
        departuringBox.click();

        WebElement MayMonth = driver.findElement(By.xpath("//body[@id='viewport']/div[@id='flights-root']/div[@id='page']/div[contains(@class,'od-home-main-layout home_main_layout')]/div[contains(@class,'od-body-content body_content')]/section[@id='home']/div[contains(@class,'od-home-wrapper')]/div[contains(@class,'od-home-full-width-content odf-flex-item odf-flex-item-first')]/div[contains(@class,'od-home-content od-home-content-with-warning-top-message')]/div[contains(@class,'od-home-content-search')]/div[@id='flights-manager']/div[contains(@class,'')]/div[contains(@class,'od-flightsManager-content')]/div[contains(@class,'od-flightsManager-main')]/div[contains(@class,'od-flightsManager-row citysearch_group')]/div[contains(@class,'od-flightsManager-cell')]/div[contains(@class,'calendar_container active')]/div[contains(@class,'od-ui-datepicker-container datepicker hasButton active')]/div[contains(@class,'od-ui-datepicker-wrapper')]/div[contains(@class,'od-ui-calendar-wrapper open')]/div[contains(@class,'od-ui-calendar-body')]/div[contains(@class,'od-ui-calendar-container')]/div[1]/div[2]"));

        // list is to create one common element of all dates of May Month
        List<WebElement> alldates = MayMonth.findElements(By.cssSelector(".od-ui-calendar-day"));

        for (WebElement date : alldates){
            System.out.println(date.getText());    //to print all dates of May month

            if (date.getText().contains("31")){
                date.click();                    // to click on one of all date
            }
        }

        WebElement returnBox = driver.findElement(By.xpath("//div[@class='od-flightsManager-row citysearch_group']//div[@class='od-ui-datepicker-display'][contains(text(),'Return')]"));
        returnBox.click();

        WebElement JuneMonth = driver.findElement(By.xpath("//body[@id='viewport']/div[@id='flights-root']/div[@id='page']/div[contains(@class,'od-home-main-layout home_main_layout')]/div[contains(@class,'od-body-content body_content')]/section[@id='home']/div[contains(@class,'od-home-wrapper')]/div[contains(@class,'od-home-full-width-content odf-flex-item odf-flex-item-first')]/div[contains(@class,'od-home-content od-home-content-with-warning-top-message')]/div[contains(@class,'od-home-content-search')]/div[@id='flights-manager']/div[contains(@class,'')]/div[contains(@class,'od-flightsManager-content')]/div[contains(@class,'od-flightsManager-main')]/div[contains(@class,'od-flightsManager-row citysearch_group')]/div[contains(@class,'od-flightsManager-cell')]/div[contains(@class,'calendar_container active')]/div[contains(@class,'od-ui-datepicker-container datepicker hasButton active')]/div[contains(@class,'od-ui-datepicker-wrapper')]/div[contains(@class,'od-ui-calendar-wrapper open')]/div[contains(@class,'od-ui-calendar-body')]/div[contains(@class,'od-ui-calendar-container')]/div[2]/div[2]"));
        //System.out.println(JuneMonth.isDisplayed());

        List<WebElement> returndates = JuneMonth.findElements(By.cssSelector(".od-ui-calendar-day"));

        for (WebElement returndate : returndates){

            if (returndate.getText().contains("5")){
                returndate.click();
            }
        }
    }

}
