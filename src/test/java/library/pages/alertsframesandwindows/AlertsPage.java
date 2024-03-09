package library.pages.alertsframesandwindows;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class AlertsPage {
    public AlertsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Alerts']")
    public WebElement alertsPageTitle;
    @FindBy(id = "alertButton")
    public WebElement simpleAlertButton;
    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertButton;
    @FindBy(id = "confirmButton")
    public WebElement confirmAlertButton;
    @FindBy(id = "promtButton")
    public WebElement promptAlertButton;

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

    public boolean waitForAlertToBePresent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
            return true;
        }
        catch (TimeoutException exception){
            return false;
        }
    }

    public boolean verifyAlertVisibility(){
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException exception){
            return false;
        }
    }

    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
    }
}
