package Bright;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BrowserInvoke {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/");
        driver.manage().window().maximize();

        //find searchbox element by ID
        //WebElement searchbox = driver.findElement(By.id("searchTerm"));
        //searchbox.sendKeys("Nike");

        //find searchbox element by Class name
        //WebElement searchbox = driver.findElement(By.className("_1Rz0y"));
        //searchbox.sendKeys("Nike");

        //find searchbox element by xpath
        //WebElement searchbox = driver.findElement(By.xpath("//*[@id=\"searchTerm\"]"));
        //searchbox.sendKeys("Nike");

        //find searchbox click element by ID
        //WebElement searchbutton = driver.findElement(By.className("_1gqeQ"));
        //searchbutton.click();

        //find searchbox element by CSS selector
        //WebElement searchbox = driver.findElement(By.cssSelector("#searchTerm"));
        //searchbox.sendKeys("Nike");

        //WebElement wishlistButton = driver.findElement(By.linkText("Account"));   //by linkText
        //wishlistButton.click();
        WebElement SearchBar = driver.findElement(By.cssSelector("input[aria-controls=haas-ac-results]"));
        SearchBar.sendKeys("Nike");

        //WebElement Searchbutton = driver.findElement(By.className("_2mKaC"));
        //SearchBar.click();

    }
}
