package Bright;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

public class AssertionDemo {
    public static WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:home:term:nike");
        driver.manage().window().maximize();
    }

    @Test
    public void argos(){

        String actual = driver.getCurrentUrl();
        Assert.assertThat(actual,Matchers.containsString("https://www.argos.co.uk/")); //Asserting website url
        //Assert.assertThat(actual, Matchers.equalToIgnoringCase("https://www.argos.co.uk/"));  //Asserting website url
        //Assert.assertThat(actual,Matchers.endsWith("argos.co.uk/"));

        //Example of different Asserting methods
        //Assert.assertThat(actual, Matchers.greaterThan());
        Assert.assertThat(actual,Matchers.containsString("nike"));
        //Assert.assertThat(actual, Matchers.equalToIgnoringCase());
        //Assert.assertThat(actual, Matchers.greaterThan());
        //Assert.assertThat(actual, Matchers.greaterThanOrEqualTo());
        //Assert.assertThat(actual, Matchers.lessThanOrEqualTo());
    }

}
