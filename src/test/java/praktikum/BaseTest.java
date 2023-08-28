package praktikum;

import java.io.File;
import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    public void clickConfirmButton() {
        this.driver.findElement(By.xpath(".//button[@id='rcc-confirm-button']")).click();
    }


    @After
    public void teardown() {
        this.driver.quit();
    }
}
