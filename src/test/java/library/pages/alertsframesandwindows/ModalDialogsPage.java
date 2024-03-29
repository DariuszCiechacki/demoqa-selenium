package library.pages.alertsframesandwindows;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class ModalDialogsPage {
    public ModalDialogsPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Modal Dialogs']")
    public WebElement modalDialogsPageTitle;
    @FindBy(id = "showSmallModal")
    public WebElement showSmallModalButton;
    @FindBy(id = "showLargeModal")
    public WebElement showLargeModalButton;
    @FindBy(xpath = "//div[contains(@class,'modal-title')]")
    public WebElement modalDialogTitle;
    @FindBy(id = "closeSmallModal")
    public WebElement closeSmallModalButton;
    @FindBy(id = "closeLargeModal")
    public WebElement closeLargeModalButton;

    public boolean waitForModalDialogsPageContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(modalDialogsPageTitle));
            return true;
        }
        catch (TimeoutException exception){
            return false;
        }
    }

    public void waitForModalDialogContent(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .elementToBeClickable(modalDialogTitle));
    }

    public void closeSmallModalDialog(){
        closeSmallModalButton.click();
        waitForModalDialogToClose();
    }

    public void closeLargeModalDialog(){
        closeLargeModalButton.click();
        waitForModalDialogToClose();
    }

    public boolean verifyModalDialogVisibility(){
        try {
            modalDialogTitle.isDisplayed();
            return true;
        }
        catch (NoSuchElementException exception){
            return false;
        }
    }

    private void waitForModalDialogToClose(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .invisibilityOf(modalDialogTitle));
    }
}
