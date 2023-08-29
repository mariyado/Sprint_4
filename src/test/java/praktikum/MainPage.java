package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseTest {

    public WebElement accordionElement() {
        return driver.findElement(By.xpath(".//div[@id='accordion__heading-0']"));
    }

    private void scrollToAccordion() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", new Object[]{accordionElement()});
    }

    public WebElement answerAccordionElement() {
        return driver.findElement(By.xpath(".//div[@id='accordion__panel-0']/p"));
    }

    private void isAnswerCorrect() {
        Assert.assertEquals("Текст не 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.'", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", answerAccordionElement().getText());
    }

    @Test
    public void checkTextPriceAndPaymentMethod() {

        openStartUrl(mainUrl);
        clickConfirmButton();
        scrollToAccordion();
        accordionElement().click();
        isAnswerCorrect();
    }




}
