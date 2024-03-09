package library.pages.alertsframesandwindows;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class AlertsPage {
    @FindBy(xpath = "//h1[text()='Alerts']")
    WebElement alertsPageTitle;
    @FindBy(id = "alertButton")
    WebElement simpleAlertButton;
    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;
    @FindBy(id = "confirmButton")
    WebElement confirmAlertButton;
    @FindBy(id = "promtButton")
    WebElement promptAlertButton;

    public boolean waitForAlertsPageContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(alertsPageTitle));
            return true;
        }
        catch (TimeoutException exception){
            return false;
        }
    }
}
