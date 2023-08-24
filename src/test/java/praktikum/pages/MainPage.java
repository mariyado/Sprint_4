package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    protected WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void clickOrderConfirmationButton(WebDriver driver) {
        driver.findElement(By.xpath(".//button[text() = 'Да']")).click();
    }

    public void findFormOrder() {
        this.driver.findElement(By.xpath(".//div[text()='Для кого самокат']"));
    }

    public void clickButtonHeader() {
        this.driver.findElement(By.xpath(".//button[contains(@class, 'Button_Button__ra12g') and text() = 'Заказать']")).click();
    }

    public void clickOrderButton() {
        this.driver.findElement(By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']")).click();
    }

    public void enteringComment(String comment) {
        this.driver.findElement(By.xpath(".//input[@placeholder = 'Комментарий для курьера']")).sendKeys(new CharSequence[]{comment});
    }

    public void clickCommentField() {
        this.driver.findElement(By.xpath(".//input[@placeholder = 'Комментарий для курьера']")).click();
    }

    public void selectColor() {
        this.driver.findElement(By.id("black")).click();
    }

    public void selectDuration() {
        this.driver.findElement(By.xpath(".//div[text() = 'двое суток']")).click();
    }

    public void clickDuration() {
        this.driver.findElement(By.xpath(".//div[contains(@class, 'Dropdown-control')]")).click();
    }

    public void selectDate() {
        this.driver.findElement(By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]")).click();
    }

    public void clickDataField() {
        this.driver.findElement(By.xpath(".//input[@placeholder = '* Когда привезти самокат']")).click();
    }

    public void scrollNextButton(WebElement nextButton) {
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{nextButton});
    }

    public void enteringPhone(String phone) {
        this.driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys(new CharSequence[]{phone});
    }

    public void clickPhoneField() {
        this.driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).click();
    }

    public void scrollStationElement(WebElement stationElement) {
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{stationElement});
    }

    public void clickStationField() {
        this.driver.findElement(By.xpath(".//input[@placeholder = '* Станция метро']")).click();
    }

    public void enteringAddress(String address) {
        this.driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys(new CharSequence[]{address});
    }

    public void clickAddressField() {
        this.driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).click();
    }

    public void enteringLastNameField(String lastName) {
        this.driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']")).sendKeys(new CharSequence[]{lastName});
    }

    public void clickLastNameField() {
        this.driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']")).click();
    }

    public void enteringName(String firstName) {
        this.driver.findElement(By.xpath(".//input[@placeholder='* Имя']")).sendKeys(new CharSequence[]{firstName});
    }

    public void clickNameField() {
        this.driver.findElement(By.xpath(".//input[@placeholder='* Имя']")).click();
    }

    public void clickConfirmButton() {
        this.driver.findElement(By.xpath(".//button[@id='rcc-confirm-button']")).click();
    }

    public void isStatusButton() {
        WebElement statusButton = this.driver.findElement(By.xpath(".//button[text() = 'Посмотреть статус']"));

        assert statusButton.isDisplayed();

    }
}
