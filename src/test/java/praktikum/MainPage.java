package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseTest {

    private WebDriver driver;



    @Test
    public void checkTextPriceAndPaymentMethod() {

        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        clickConfirmButton();
        WebElement accordionElement = this.driver.findElement(By.xpath(".//div[@id='accordion__heading-0']"));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{accordionElement});
        accordionElement.click();
        Assert.assertEquals("Текст не 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.'", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", this.driver.findElement(By.xpath(".//div[@id='accordion__panel-0']/p")).getText());
    }
}
