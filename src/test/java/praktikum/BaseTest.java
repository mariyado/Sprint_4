package praktikum;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    public static final String mainUrl = "https://qa-scooter.praktikum-services.ru/";

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setup()
    {
        driver = new ChromeDriver();
    }

    public void clickConfirmButton() {
        this.driver.findElement(By.xpath(".//button[@id='rcc-confirm-button']")).click();
    }

    public void openStartUrl(String mainUrl) {
        driver.get(mainUrl);
    }


    @After
    public void teardown() {
        this.driver.quit();
    }
}
