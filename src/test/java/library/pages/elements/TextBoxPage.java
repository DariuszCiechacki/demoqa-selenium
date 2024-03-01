package library.pages.elements;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class TextBoxPage {
    @FindBy(xpath = "//h1[text()='Text Box']")
    WebElement textBoxPageTitle;

    public boolean waitForTextBoxPageContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(textBoxPageTitle));
        }
        catch (TimeoutException exception){
            return false;
        }

        return true;
    }
}
