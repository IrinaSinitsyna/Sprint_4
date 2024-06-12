package common;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

public class CommonTest {
    protected WebDriver driver;
    protected HomePage homePage;

    private String browserType;

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    @Before
    public void setUp() {
        if (browserType.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriverForWindows.exe");
            driver = new ChromeDriver();
        } else if (browserType.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", " setBrowserType(src/main/resources/geckodriverForWindows.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(HomePage.MAIN_PAGE);
        homePage = new HomePage(driver);
        homePage.clickCookieButton();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
