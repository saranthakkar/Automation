package Bright;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindowDemo2 {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.next.co.uk/");
        driver.manage().window().maximize();
    }

    @Test
    public void Switch() throws InterruptedException {
        String NEXTHandle = driver.getWindowHandle();         //Step 1 - Naming current window

        JavascriptExecutor js = (JavascriptExecutor) driver;  // Step 2 - Giving an URL of 2nd WEB handle
        js.executeScript("window.open(arguments[0])", "https://www.ralphlauren.co.uk/");

        Thread.sleep(5000);  //waiting time

        Set<String>handles = driver.getWindowHandles();    // Step 3 - Set all Window handles

        for (String handle : handles){                     //Step 4 - For Each Loop condition to switch the handle

        if (!handle.equals(NEXTHandle)){
            driver.switchTo().window(handle);
            System.out.println(handle);
        }
    }
        String RalphLaurenHandle = driver.getWindowHandle();    //Step 5 - Naming 2nd Web Handle

        Thread.sleep(5000);   //waiting time

        driver.switchTo().window(NEXTHandle);                   //Step 6 - Switching back to 1st(Next) window Handle

        Thread.sleep(5000);   //waiting time

        driver.switchTo().window(RalphLaurenHandle);            //Switching back to 2nd(Ralph lauren) window Handle
}
}
