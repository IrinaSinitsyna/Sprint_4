import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.OrderPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPlacementTest {

    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;

    private String name;
    private String surname;
    private String address;
    private String phone;
    private String comment;

    public OrderPlacementTest(String name, String surname, String address, String phone, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getOrderData() {
        return Arrays.asList(new Object[][]{
                {"Владимир", "Пупкин", "Москва, ул. Аэропорт, д.22", "89635488574", "Надо два самоката"},
                {"Ирина", "Силаева", "Московская область, г.Люберцы, ул. Мира, д.3", "+7915248966587", "Без царапин"},
        });
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriverForWindows.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-automation");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(HomePage.MAIN_PAGE);
        homePage = new HomePage(driver);
        homePage.clickCookieButton();
        orderPage = new OrderPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testOrderPlacementTopOrderButton() {
        //Заказ по кнопке ORDER_TOP_BUTTON
        homePage.clickOrderTopButton();
        //Заполнение формы заказа
        orderPage.enterName(name);
        orderPage.enterSurname(surname);
        orderPage.enterAddress(address);
        orderPage.selectRandomMetroStation();
        orderPage.enterPhone(phone);
        orderPage.clickNextButton();
        orderPage.selectRandomDate();
        orderPage.selectThreeDaysPeriod();
        orderPage.selectGreyColour();
        orderPage.enterComment(comment);
        //Подтверждение заказа
        orderPage.clickOrderButton();
        orderPage.clickConfirmOrderButton();
        //Проверка сообщения об успешном создании заказа
        assertTrue(orderPage.isSuccessMessageDisplayed());
    }

    @Test
    public void testOrderPlacementMiddleOrderButton() {
        //Заказ по кнопке ORDER_MIDDLE_BUTTON
        homePage.clickOrderMiddleButton();
        //Заполнение формы заказа
        orderPage.enterName(name);
        orderPage.enterSurname(surname);
        orderPage.enterAddress(address);
        orderPage.selectRandomMetroStation();
        orderPage.enterPhone(phone);
        orderPage.clickNextButton();
        orderPage.selectRandomDate();
        orderPage.selectFourDaysPeriod();
        orderPage.selectBlackColour();
        orderPage.enterComment(comment);
        //Подтверждение заказа
        orderPage.clickOrderButton();
        orderPage.clickConfirmOrderButton();
        //Проверка сообщения об успешном создании заказа
        assertTrue(orderPage.isSuccessMessageDisplayed());
    }
}

