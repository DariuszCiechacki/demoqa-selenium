package library.pages.alertsframesandwindows;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class BrowserWindowsPage {
    public BrowserWindowsPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Browser Windows']")
    WebElement browserWindowsPageTitle;
    @FindBy(id = "tabButton")
    public WebElement openNewTabButton;
    @FindBy(id = "windowButton")
    public WebElement openNewWindowButton;
    @FindBy(id = "messageWindowButton")
    public WebElement openNewMessageWindowButton;
    @FindBy(id = "sampleHeading")
    public WebElement newWindowHeaderElement;

    public boolean waitForBrowserWindowsPageContent() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                    .elementToBeClickable(browserWindowsPageTitle));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public String getOpenedTabWindowHandle(String originalWindowHandle){
        return driver.getWindowHandles().stream().filter(handle -> !handle.equals(originalWindowHandle))
                .findAny().orElse(null);
    }

    public String getNewWindowHeaderText(){
        return newWindowHeaderElement.getText();
    }
}
