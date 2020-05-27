package Bright;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class KeyboardPress {
    public static WebDriver driver;
    @Before
    public  void setup(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
    }
    @Test
    public void keyPres(){
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='navbar-link fedora-navbar-link']"));
        loginButton.click();

        WebElement username = driver.findElement(By.id("user_email"));
        username.sendKeys("saranthakkar@yahoo.com");
        username.sendKeys(Keys.TAB);

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("12345");
        password.sendKeys(Keys.ENTER);
    }
    @Test
    public void combineKeyPress() throws InterruptedException {
        WebElement bmwradio = driver.findElement(By.id("bmwradio"));
        bmwradio.click();

        bmwradio.sendKeys(Keys.CONTROL+"a",Keys.CONTROL+"c");

        Thread.sleep(3000);

        WebElement searchbox = driver.findElement(By.id("name"));
        searchbox.click();

        searchbox.sendKeys(Keys.CONTROL+"v");
        Thread.sleep(4000);
    }
@After
    public void  tearDown() throws IOException {
    TakesScreenshot screenshot = ((TakesScreenshot) driver);
    File sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File destinationFolder = new File("D:\\Desktop\\sample.png");
    FileUtils.copyFile(sourcefile,destinationFolder);
}
}
