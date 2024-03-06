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

    public Map<String, String> getEntireSubmittedFormData(){
        Map<String, String> submittedFormData = new HashMap<>();

        submittedFormData.put("firstName", splitFullName()[0]);
        submittedFormData.put("lastName", splitFullName()[1]);
        submittedFormData.put("email", driver.findElement(By.xpath("//td[text()='Student Email']//following-sibling::td"))
                .getText());
        submittedFormData.put("gender", driver.findElement(By.xpath("//td[text()='Gender']//following-sibling::td"))
                .getText());
        submittedFormData.put("mobileNumber", driver.findElement(By.xpath("//td[text()='Mobile']//following-sibling::td"))
                .getText());
        /*submittedFormData.put("dateOfBirth", driver.findElement(By.xpath("//td[text()='Date of Birth']//following-sibling::td"))
                .getText());*/ //ToDo adjust to different format
        submittedFormData.put("subjects", driver.findElement(By.xpath("//td[text()='Subjects']//following-sibling::td"))
                .getText());
        /*submittedFormData.put("hobbies", driver.findElement(By.xpath("//td[text()='Hobbies']//following-sibling::td"))
                .getText());*/ //ToDo return values sorted by ascending
        submittedFormData.put("currentAddress", driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td"))
                .getText());
        submittedFormData.put("state", splitStateAndCity()[0]);
        submittedFormData.put("city", splitStateAndCity()[1]);

        return submittedFormData;
    }

    public Map<String, String> getRequiredSubmittedFormData(){
        Map<String, String> submittedFormData = new HashMap<>();

        submittedFormData.put("firstName", splitFullName()[0]);
        submittedFormData.put("lastName", splitFullName()[1]);
        submittedFormData.put("gender", driver.findElement(By.xpath("//td[text()='Gender']//following-sibling::td"))
                .getText());
        submittedFormData.put("mobileNumber", driver.findElement(By.xpath("//td[text()='Mobile']//following-sibling::td"))
                .getText());

        return submittedFormData;
    }

    private String[] splitFullName(){
        String fullName = driver.findElement(By.xpath("//td[text()='Student Name']//following-sibling::td"))
                .getText();
        return fullName.split(" ");
    }

    private String[] splitStateAndCity(){
        String stateAndCity = driver.findElement(By.xpath("//td[text()='State and City']//following-sibling::td"))
                .getText();
        return stateAndCity.split(" ");
    }
}
