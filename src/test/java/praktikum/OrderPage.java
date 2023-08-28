package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@RunWith(Parameterized.class)
public class OrderPage extends BaseTest {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String orderComment;

    @Parameterized.Parameters
    public static Object[][] getFormData() {
        return new Object[][]{{"Анна", "Иванова", "Кутузова, 60", "+79181122333", "вход с торца дома"}, {"Кристина", "Петрова", "Ставропольская, 61", "+79189122333", "домофон не работает"}};
    }

    public OrderPage(String firstName, String lastName, String address, String phone, String orderComment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.orderComment = orderComment;
    }

    //ПЕРЕМЕННЫЕ
    private By orderConfirmationButton = By.xpath(".//button[text() = 'Да']");
    private By formOrder = By.xpath(".//div[text()='Для кого самокат']");
    private By buttonOrderHeader = By.xpath(".//button[contains(@class, 'Button_Button__ra12g') and text() = 'Заказать']");
    private By buttonOrderMiddle = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']");
    private By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    private By colorScooter = By.id("black");
    private  By durationFieldElement = By.xpath(".//div[text() = 'двое суток']");
    private  By durationField = By.xpath(".//div[contains(@class, 'Dropdown-control')]");
    private By dayToday = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]");
    private By dataField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By stationField = By.xpath(".//input[@placeholder = '* Станция метро']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By confirmButton = By.xpath(".//button[@id='rcc-confirm-button']");
    private By statusButton = By.xpath(".//button[text() = 'Посмотреть статус']");
    private By backToMainPageButton = By.xpath(".//img[@alt= 'Scooter']");



    //МЕТОДЫ

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

    public void isStatusButton() {
        WebElement statusButton = this.driver.findElement(By.xpath(".//button[text() = 'Посмотреть статус']"));
        assert statusButton.isDisplayed();
    }

    private void backToMainPage() {
        driver.findElement(By.xpath(".//img[@alt= 'Scooter']"));
    }




    @Test
    public void clickOrderButtonInHeader() {
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        clickButtonHeader();
        findFormOrder();
        backToMainPage();


        clickConfirmButton();
        WebElement orderMiddleButton = this.driver.findElement(By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text() = 'Заказать']"));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{orderMiddleButton});
        orderMiddleButton.click();
        findFormOrder();


        clickNameField();
        enteringName(this.firstName);
        clickLastNameField();
        enteringLastNameField(this.lastName);
        clickAddressField();
        enteringAddress(this.address);
        clickStationField();
        WebElement stationElement = this.driver.findElement(By.xpath(".//button[@value = '5']"));
        scrollStationElement(stationElement);
        stationElement.click();
        clickPhoneField();
        enteringPhone(this.phone);
        WebElement nextButton = this.driver.findElement(By.xpath(".//button[text() = 'Далее']"));
        scrollNextButton(nextButton);
        nextButton.click();
        clickDataField();
        selectDate();
        clickDuration();
        selectDuration();
        selectColor();
        clickCommentField();
        enteringComment(this.orderComment);
        clickOrderButton();
        clickOrderConfirmationButton(this.driver);
        isStatusButton();
    }
}
