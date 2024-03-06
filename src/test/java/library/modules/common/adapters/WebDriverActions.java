package library.modules.common.adapters;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static drivers.Driver.driver;

public class WebDriverActions {
    public static void scrollToElementAndClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
}
