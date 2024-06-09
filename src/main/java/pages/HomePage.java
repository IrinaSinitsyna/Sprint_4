package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static final String MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка "Заказать" в шапке
    public static final By ORDER_TOP_BUTTON = By.xpath("//button[@class='Button_Button__ra12g']");

    //Кнопка "Заказать" в центре
    public static final By ORDER_MIDDLE_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Кнопка информирования о куки
    public static final By EVERYONE_IS_USED_TO_IT_COOKIE_BUTTON = By.xpath("//button[@id='rcc-confirm-button']");

    //Кнопки вопросов
    public static final By HOW_MUCH_DOES_IT_COST_AND_HOW_TO_PAY_BUTTON = By.xpath("//div[@id='accordion__heading-0']");
    public static final By SEVERAL_SCOOTERS_POSSIBLE_BUTTON = By.xpath("//div[@id='accordion__heading-1']");
    public static final By RENTAL_TIME_CALCULATION_BUTTON = By.xpath("//div[@id='accordion__heading-2']");
    public static final By ORDER_A_SCOOTER_FOR_TODAY_BUTTON = By.xpath("//div[@id='accordion__heading-3']");
    public static final By EXTEND_THE_ORDER_OR_RETURN_EARLIER_BUTTON = By.xpath("//div[@id='accordion__heading-4']");
    public static final By CHARGING_UNIT_WITH_SCOOTER_BUTTON = By.xpath("//div[@id='accordion__heading-5']");
    public static final By ORDER_CANCELLATION_BUTTON = By.xpath("//div[@id='accordion__heading-6']");
    public static final By BRING_IT_BEYOND_THE_MRR_BUTTON = By.xpath("//div[@id='accordion__heading-7']");

    //Текст ответов на вопросы
    public static final By HOW_MUCH_DOES_IT_COST_AND_HOW_TO_PAY_ANSWER = By.xpath("//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    public static final By SEVERAL_SCOOTERS_POSSIBLE_ANSWER = By.xpath("//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    public static final By RENTAL_TIME_CALCULATION_ANSWER = By.xpath("//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    public static final By ORDER_A_SCOOTER_FOR_TODAY_ANSWER = By.xpath("//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    public static final By EXTEND_THE_ORDER_OR_RETURN_EARLIER_ANSWER = By.xpath("//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    public static final By CHARGING_UNIT_WITH_SCOOTER_ANSWER = By.xpath("//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    public static final By ORDER_CANCELLATION_ANSWER = By.xpath("//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");
    public static final By BRING_IT_BEYOND_THE_MRR_ANSWER = By.xpath("//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");

    public void clickCookieButton() {
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(EVERYONE_IS_USED_TO_IT_COOKIE_BUTTON));
        cookieButton.click();
    }

    //Параметризированный метод для проверки вопросов и ответов
    public void checkQuestionAndAnswer(By questionButton, By answerText) {
        WebElement questionElement = wait.until(ExpectedConditions.elementToBeClickable(questionButton));
        questionElement.click();
        WebElement answerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(answerText));
        assert answerElement.isDisplayed() : "Ответ не отображается";
    }

    //Метод для клика по кнопке "Заказать" в шапке
    public void clickOrderTopButton() {
        WebElement orderTopButton = wait.until(ExpectedConditions.elementToBeClickable(ORDER_TOP_BUTTON));
        orderTopButton.click();
    }

    //Метод для клика по кнопке "Заказать" в центре
    public void clickOrderMiddleButton() {
        WebElement orderTopButton = wait.until(ExpectedConditions.elementToBeClickable(ORDER_MIDDLE_BUTTON));
        orderTopButton.click();
    }
}



