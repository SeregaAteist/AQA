package io.gatling.computerdatabase;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;


public class FirstTest {
    private static WebDriver driver;

    @BeforeMethod
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\Chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://computer-database.gatling.io/computers");

    }

    @Test
    public void Buttom() {
        driver.findElement(By.id("add")).click();

        String addUrl = driver.getCurrentUrl();
        Assert.assertTrue(addUrl.equals("http://computer-database.gatling.io/computers/new"));

        driver.findElement(By.id("name")).click();
        driver.switchTo().activeElement().sendKeys("myName");

        driver.findElement(By.id("introduced")).click();
        driver.switchTo().activeElement().sendKeys("2010-10-09");

        driver.findElement(By.id("discontinued")).click();
        driver.switchTo().activeElement().sendKeys("2020-10-09");

        Select company = new Select (driver.findElement(By.id("company")));
        company.selectByIndex(1);

//        driver.findElement(By.id("company")).click();
//        driver.switchTo().activeElement().sendKeys("ap");
//        driver.switchTo().activeElement().sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//input[@class='btn primary']")).click();
        String submitUrl = driver.getCurrentUrl();
        Assert.assertTrue(submitUrl.equals("http://http://computer-database.gatling.io/computers"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

