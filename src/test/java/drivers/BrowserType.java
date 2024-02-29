package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum BrowserType {
    CHROME {
        public WebDriver createWebDriver() {
            ChromeOptions options = new ChromeOptions();
            configureHeadless(options);

            WebDriverManager.chromedriver().setup();

            return new ChromeDriver(options);
        }
    },
    EDGE {
        public WebDriver createWebDriver(){
            EdgeOptions options = new EdgeOptions();
            configureHeadless(options);
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver(options);
        }
    },

    FIREFOX {
        public WebDriver createWebDriver(){
            FirefoxOptions options = new FirefoxOptions();
            configureHeadless(options);

            WebDriverManager.firefoxdriver().setup();

            return new FirefoxDriver(options);
        }
    };

    public abstract WebDriver createWebDriver();

    protected void configureHeadless(ChromeOptions options) {
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        if (isHeadless) {
            options.addArguments("--headless");
        }
    }

    protected void configureHeadless(FirefoxOptions options) {
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        if (isHeadless) {
            options.addArguments("--headless");
        }
    }

    protected void configureHeadless(EdgeOptions options) {
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        if (isHeadless) {
            options.addArguments("--headless");
            options.addArguments("disable-gpu");
        }
    }
}
