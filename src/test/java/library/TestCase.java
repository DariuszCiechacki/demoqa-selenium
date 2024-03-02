package library;

import com.demoqa.config.ConfigLoader;
import drivers.BrowserType;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static drivers.Driver.driver;

public class TestCase {

    @BeforeTest
    public static void setUpWebDriver() {
        String browserName = System.getProperty("browser", "CHROME");

        BrowserType browserType = BrowserType.valueOf(browserName.toUpperCase());
        driver = browserType.createWebDriver();

        setWindowDimension();
        navigateToBasePageUrl();
    }

    //@AfterTest
    public static void tearDown() {
        driver.quit();
    }

    private static void setWindowDimension(){
        driver.manage().window().setSize(new Dimension(1700, 1080));
    }

    private static void navigateToBasePageUrl(){
        driver.get(ConfigLoader.getProperty("baseUrl"));
    }
}