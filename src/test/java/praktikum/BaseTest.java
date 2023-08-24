package praktikum;

import java.io.File;
import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BaseTest {
    protected WebDriver driver;

    public BaseTest() {
    }

    @Before
    public void initDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = (ChromeDriverService)((ChromeDriverService.Builder)(new ChromeDriverService.Builder()).usingDriverExecutable(new File("C:\\webdriver\\bin\\chromedriver-win64\\chromedriver.exe"))).build();
        this.driver = new ChromeDriver(service);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
    }

    @After
    public void teardown() {
        this.driver.quit();
    }
}
