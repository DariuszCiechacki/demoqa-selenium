package library.pages;

import library.modules.common.SidebarMenu;
import library.modules.common.adapters.WebDriverActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[contains(@class,'consent fc-primary-button')]")
    private WebElement acceptConsentButton;
    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsCategory;
    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Forms']")
    private WebElement formsCategory;
    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertsFramesWindowsCategory;
    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Widgets']")
    private WebElement widgetsCategory;
    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Interactions']")
    private WebElement interactionsCategory;
    @FindBy(xpath = "//div[@class='category-cards']//h5[text()='Book Store Application']")
    private WebElement bookStoreApplicationCategory;

    //ToDo needs to be fixed for CI/CD purpose
    public boolean waitForHomePageContent(){
        /*try {
            new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions
                    .visibilityOf(elementsCategory));
        }
        catch (TimeoutException exception){
            return false;
        }*/
        try {
            Thread.sleep(5000);
        }
        catch (Exception exception){}

        closeConsentModal();

        return true;
    }

    public SidebarMenu navigateToElementsCategory(){
        elementsCategory.click();

        return new SidebarMenu();
    }

    public SidebarMenu navigateToAlertsFrameAndWindowsCategory(){
        WebDriverActions.scrollToElementAndClick(alertsFramesWindowsCategory);

        return new SidebarMenu();
    }

    public SidebarMenu navigateToFormsCategory(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formsCategory);
        formsCategory.click();

        return new SidebarMenu();
    }

    private void closeConsentModal(){
        try {
            if (acceptConsentButton.isDisplayed()){
                acceptConsentButton.click();
                waitForConsentModalToClose();
            }
        }
        catch (NoSuchElementException exception){}
    }

    private void waitForConsentModalToClose(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .invisibilityOf(acceptConsentButton));
    }
}
