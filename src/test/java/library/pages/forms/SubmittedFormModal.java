package library.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static drivers.Driver.driver;

public class SubmittedFormModal {
    public boolean waitForSubmittedFormModalContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//div[@class='modal-header']")));
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
