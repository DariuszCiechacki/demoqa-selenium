package library.pages.elements.webtables;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class RegistrationFormModal {
    @FindBy(id = "registration-form-modal")
    WebElement registrationFormModalTitle;

    public boolean waitForRegistrationFormModalContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(registrationFormModalTitle));
        }
        catch (TimeoutException exception){
            return false;
        }

        return true;
    }
}
