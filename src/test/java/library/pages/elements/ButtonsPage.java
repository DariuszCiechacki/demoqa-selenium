package library.pages.elements;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class ButtonsPage {
    public ButtonsPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Buttons']")
    WebElement buttonsPageTitle;

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickButton;

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    @FindBy(id = "rightClickBtn")
    WebElement rightClickButton;

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    @FindBy(xpath = "//button[text()='Click Me']")
    WebElement dynamicClickButton;

    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickMessage;

    public boolean waitForButtonsPageContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(buttonsPageTitle));
            return true;
        }
        catch (TimeoutException exception){
            return false;
        }
    }

    public boolean verifyDoubleClickButton(){
        new Actions(driver).doubleClick(doubleClickButton).perform();

        return verifySuccessMessage(doubleClickMessage);
    }

    public boolean verifyRightClickButton(){
        new Actions(driver).contextClick(rightClickButton).perform();

        return verifySuccessMessage(rightClickMessage);
    }

    public boolean verifyDynamicClickButton(){
        dynamicClickButton.click();

        return verifySuccessMessage(dynamicClickMessage);
    }

    private boolean verifySuccessMessage(WebElement successMessage){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(successMessage));
            return true;
        }
        catch (TimeoutException exception){

            return false;
        }
    }
}
