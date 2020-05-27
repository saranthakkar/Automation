package Bright;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class NavigatePages {
    public static WebDriver driver;

    @Before
    public  void setup(){
        System.setProperty("webdriver.chrome.driver","D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/");
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        String CurrentTitle = driver.getTitle();  // website title
        System.out.println(CurrentTitle);

        String CurrentURL = driver.getCurrentUrl(); //website url
        System.out.println(CurrentURL);

        driver.navigate().to("https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1");
        String LoginURL = driver.getCurrentUrl();
        System.out.println(LoginURL);

        driver.navigate().back();

        driver.navigate().forward();
    }
}
