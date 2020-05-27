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

public class DropDownOptions {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://learn.letskodeit.com/p/practice");
        driver.manage().window().maximize();
}
@Test
    public void DropDownDemo() throws InterruptedException {

    WebElement DropDownOption = driver.findElement(By.id("carselect"));

    //Using Select class - initialising Select sel
    Select sel = new Select(DropDownOption);

    sel.selectByIndex(0);
    Thread.sleep(2000);

    sel.selectByValue("benz");
    Thread.sleep(2000);

    sel.selectByVisibleText("Honda");
    Thread.sleep(2000);

    //List will only need in Select class if you want to print out
    //List<WebElement> options = sel.getAllSelectedOptions();  // to get only selected options
    List<WebElement> options = sel.getOptions();           // to get all options

    for (WebElement option : options){
        System.out.println(option.getText());
    }
}

@Test
    public void MultipleSelectionDemo() throws InterruptedException {

    WebElement MultipleSelection = driver.findElement(By.id("multiple-select-example"));

    Select sel = new Select(MultipleSelection);

    sel.selectByIndex(0);
    Thread.sleep(2000);

    sel.selectByValue("orange");
    Thread.sleep(2000);

    sel.selectByVisibleText("Peach");
    Thread.sleep(2000);

    sel.deselectByIndex(0);
    sel.deselectByVisibleText("Peach");


    //List & for() only used if you need print out
    List<WebElement> options = sel.getOptions();
    //List<WebElement> options = sel.getAllSelectedOptions();

    for (WebElement option : options){
        System.out.println(option.getText());
    }
}
@Test
    public void ArgosSortByRelevance() throws InterruptedException {

        driver.navigate().to("https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:home:term:nike");

        WebElement Relevance = driver.findElement(By.id("sort-select"));

        //using Select Class
        Select sel = new Select(Relevance);
        Thread.sleep(3000);

        sel.selectByVisibleText("Price: High - Low");
        Thread.sleep(3000);

        sel.selectByVisibleText("Price: Low - High");
        Thread.sleep(3000);

        List<WebElement> options = sel.getOptions();

        for (WebElement option : options){
            System.out.println(sel.getOptions());
        }
}
}
