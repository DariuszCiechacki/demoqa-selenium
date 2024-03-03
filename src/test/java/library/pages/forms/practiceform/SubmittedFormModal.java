package library.pages.forms.practiceform;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static drivers.Driver.driver;

public class SubmittedFormModal {
    @FindBy(id = "")
    WebElement submittedFormModalTitle;

    public boolean waitForSubmittedFormModalContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(submittedFormModalTitle));
        }
        catch (TimeoutException exception){
            return false;
        }

        return true;
    }

    public Map<String, String> getSubmittedFormData(){
        Map<String, String> submittedFormData = new HashMap<>();



        return submittedFormData;
    }
}
