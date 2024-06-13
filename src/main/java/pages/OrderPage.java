package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    //Поле "Имя"
    public static final By NAME_INPUT = By.xpath("//input[@placeholder='* Имя']");

    //Поле "Фамилия"
    public static final By SURNAME_INPUT = By.xpath("//input[@placeholder='* Фамилия']");

    //Поле "Адрес:куда привезти заказ"
    public static final By ADDRESS_INPUT = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    //Поле "Станция метро"
    public static final By METRO_STATION_INPUT = By.xpath("//input[@placeholder='* Станция метро']");

    //Выбор станции метро
    public static final By METRO_STATION_OPTION = By.xpath("//div[@class='select-search__select']");

    //Поле "Телефон: на него позвонит курьер"
    public static final By  PHONE_INPUT = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка "Далее"
    public static final By NEXT_BUTTON = By.xpath("//button[text()='Далее']");

    //Поле "Когда привезти самокат"
    public static final By DATE_INPUT = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //Выбор варианта срока даты
    public static final By DATE_OPTION = By.xpath("//div[@aria-label='Choose суббота, 22-е июня 2024 г.']");

    //Поле "Срок аренды"
    public static final By PERIOD_INPUT = By.xpath("//div[text()='* Срок аренды']");

    //Выбор варианта срока аренды - 3 суток
    public static final By THREE_DAYS_PERIOD_OPTION = By.xpath("//div[text()='трое суток']");

    //Выбор варианта срока аренды - 4 суток
    public static final By FOUR_DAYS_PERIOD_OPTION = By.xpath("//div[text()='четверо суток']");

    //Выбор черного цвета самоката
    public static final By GREY_COLOUR_OPTION = By.xpath("//input[@id='grey']");

    //Выбор черного цвета самоката
    public static final By BLACK_COLOUR_OPTION = By.xpath("//input[@id='black']");

    //Поле "Комментарий"
    public static final By COMMENT_INPUT = By.xpath("//input[@placeholder='Комментарий для курьера']");

    //Кнопка "Заказать"
    public static final By ORDER_BUTTON = By.xpath("//button[text()='Заказать']");

    //Кнопка "Да" - окно подтверждения заказа
    public static final By YES_ORDER_CONFIRMATION_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Сообщение об успехе - отсутствует
    public static final By SUCCESS_MESSAGE = By.xpath("//span[text()='Заказ оформлен']");

    //Методы заполнения полей
    public void enterName(String name) {
        driver.findElement(NAME_INPUT).sendKeys(name);
    }

    public void enterSurname(String surname) {
        driver.findElement(SURNAME_INPUT).sendKeys(surname);
    }

    public void enterAddress(String address) {
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
    }

    public void selectRandomMetroStation() {
        driver.findElement(METRO_STATION_INPUT).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(METRO_STATION_OPTION));
        List<WebElement> metroStations = driver.findElements(METRO_STATION_OPTION);
        WebElement randomStation = metroStations.get(new Random().nextInt(metroStations.size()));
        randomStation.click();
    }

    public void enterPhone(String phone) {
        driver.findElement(PHONE_INPUT).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }

    public void selectRandomDate() {
        driver.findElement(DATE_INPUT).click();
        List<WebElement> availableDates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@aria-label, 'Choose')]")));

        Random random = new Random();
        int randomIndex = random.nextInt(availableDates.size());
        availableDates.get(randomIndex).click();
    }

    public void selectThreeDaysPeriod() {
        driver.findElement(PERIOD_INPUT).click();
        driver.findElement(THREE_DAYS_PERIOD_OPTION).click();
    }

    public void selectFourDaysPeriod() {
        driver.findElement(PERIOD_INPUT).click();
        driver.findElement(FOUR_DAYS_PERIOD_OPTION).click();
    }

    public void selectGreyColour() {
        driver.findElement(GREY_COLOUR_OPTION).click();
    }

    public void selectBlackColour() {
        driver.findElement(BLACK_COLOUR_OPTION).click();
    }

    public void enterComment(String comment) {
        driver.findElement(COMMENT_INPUT).sendKeys(comment);
    }

    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }

    public void clickConfirmOrderButton() {
        driver.findElement(YES_ORDER_CONFIRMATION_BUTTON).click();
    }

    public boolean isSuccessMessageDisplayed() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_MESSAGE));
        return successMessage.isDisplayed();
    }
}





