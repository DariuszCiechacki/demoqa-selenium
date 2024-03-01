package library.pages.elements;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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

    @FindBy(id = "rightClickBtn")
    WebElement rightClickButton;

    @FindBy(id = "Mf0iB")
    WebElement dynamicClickButton;

    public boolean waitForButtonsPageContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(buttonsPageTitle));
        }
        catch (TimeoutException exception){
            return false;
        }

        return true;
    }
}
