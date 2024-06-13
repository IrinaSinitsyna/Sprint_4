package functionalities;

import common.CommonTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.OrderPage;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPlacementTest extends CommonTest  {

    private OrderPage orderPage;

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String comment;

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
    @Override
    public void setUp() {
        setBrowserType("chrome");
        super.setUp();
        orderPage = new OrderPage(driver);
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

