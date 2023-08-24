package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import praktikum.pages.MainPage;

@RunWith(Parameterized.class)
public class ScooterTest extends BaseTest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String orderComment;

    @Parameters
    public static Object[][] getFormData() {
        return new Object[][]{{"Анна", "Иванова", "Кутузова, 60", "+79181122333", "вход с торца дома"}, {"Кристина", "Петрова", "Ставропольская, 61", "+79189122333", "домофон не работает"}};
    }

    public ScooterTest(String firstName, String lastName, String address, String phone, String orderComment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.orderComment = orderComment;
    }

    @Test
    public void clickOrderButtonInHeader() {
        MainPage page = new MainPage(this.driver);
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        page.clickButtonHeader();
        page.findFormOrder();
    }

    @Test
    public void clickMiddleOrderButton() {
        MainPage page = new MainPage(this.driver);
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        page.clickConfirmButton();
        WebElement orderMiddleButton = this.driver.findElement(By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']"));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{orderMiddleButton});
        orderMiddleButton.click();
        page.findFormOrder();
    }

    @Test
    public void checkTextPriceAndPaymentMethod() {
        MainPage page = new MainPage(this.driver);
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        page.clickConfirmButton();
        WebElement accordionElement = this.driver.findElement(By.xpath(".//div[@id='accordion__heading-0']"));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{accordionElement});
        accordionElement.click();
        Assert.assertEquals("Текст не 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.'", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", this.driver.findElement(By.xpath(".//div[@id='accordion__panel-0']/p")).getText());
    }

    @Test
    public void scooterOrder() {
        MainPage page = new MainPage(this.driver);
        this.driver.get("https://qa-scooter.praktikum-services.ru/order/");
        page.clickConfirmButton();
        page.clickNameField();
        page.enteringName(this.firstName);
        page.clickLastNameField();
        page.enteringLastNameField(this.lastName);
        page.clickAddressField();
        page.enteringAddress(this.address);
        page.clickStationField();
        WebElement stationElement = this.driver.findElement(By.xpath(".//button[@value = '5']"));
        page.scrollStationElement(stationElement);
        stationElement.click();
        page.clickPhoneField();
        page.enteringPhone(this.phone);
        WebElement nextButton = this.driver.findElement(By.xpath(".//button[text() = 'Далее']"));
        page.scrollNextButton(nextButton);
        nextButton.click();
        page.clickDataField();
        page.selectDate();
        page.clickDuration();
        page.selectDuration();
        page.selectColor();
        page.clickCommentField();
        page.enteringComment(this.orderComment);
        page.clickOrderButton();
        MainPage.clickOrderConfirmationButton(this.driver);
        page.isStatusButton();
    }
}
