package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {
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
    public void Switch() throws InterruptedException {
        //saving argos window handle
        String argosHandle = driver.getWindowHandle();
        //System.out.println(argosHandle);

        //opening another tab with facebook url
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.open(arguments[0])", "https://www.facebook.com/");

    Thread.sleep(2000);

    //set both open windows handle
    Set<String>allhandles = driver.getWindowHandles();   // Set all window handles

    //for each loop to print both window handles, if block to switch on second window
    for (String handle : allhandles){

        if (!handle.equals(argosHandle)){
            driver.switchTo().window(handle);
            System.out.println(handle);
        }
    }

    String facebookHandle = driver.getWindowHandle();

    Thread.sleep(5000);

    driver.switchTo().window(argosHandle);   // switching to 1st window handle

    Thread.sleep(5000);

    driver.switchTo().window(facebookHandle);
}
}
