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

        submittedFormData.put("firstName", driver.findElement(By.xpath("//td[text()='Student Name']//following-sibling::td"))
                .getText());
        submittedFormData.put("lastName", driver.findElement(By.xpath("//td[text()='Student Name']//following-sibling::td"))
                .getText());
        submittedFormData.put("email", driver.findElement(By.xpath("//td[text()='Student Mail']//following-sibling::td"))
                .getText());
        submittedFormData.put("gender", driver.findElement(By.xpath("//td[text()='Gender']//following-sibling::td"))
                .getText());
        submittedFormData.put("mobileNumber", driver.findElement(By.xpath("//td[text()='Mobile']//following-sibling::td"))
                .getText());
        submittedFormData.put("dateOfBirth", driver.findElement(By.xpath("//td[text()='Date of Birth']//following-sibling::td"))
                .getText());
        submittedFormData.put("subjects", driver.findElement(By.xpath("//td[text()='Subjects']//following-sibling::td"))
                .getText());
        submittedFormData.put("hobbies", driver.findElement(By.xpath("//td[text()='Hobbies']//following-sibling::td"))
                .getText());
        submittedFormData.put("currentAddress", driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td"))
                .getText());
        submittedFormData.put("state", driver.findElement(By.xpath("//td[text()='State and City']//following-sibling::td"))
                .getText());
        submittedFormData.put("city", driver.findElement(By.xpath("//td[text()='State and City']//following-sibling::td"))
                .getText());

        return submittedFormData;
    }
}
