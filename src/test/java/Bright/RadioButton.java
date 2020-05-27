package Bright;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButton {
    public static WebDriver driver;
    @Before
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
}

@Test
    public void RadioButton() throws InterruptedException {
    WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
    bmwRadioButton.click();
    Thread.sleep(3000);

    WebElement benzRadioButton = driver.findElement(By.id("benzradio"));
    benzRadioButton.click();
    Thread.sleep(3000);

    //WebElement hondaRadioButton = driver.findElement(By.id("hondaradio"));
    //hondaRadioButton.click();

    System.out.println(bmwRadioButton.isSelected());
    System.out.println(benzRadioButton.isSelected());
}
@After
    public void teardown(){
        //driver.quit();
}


}// class end
