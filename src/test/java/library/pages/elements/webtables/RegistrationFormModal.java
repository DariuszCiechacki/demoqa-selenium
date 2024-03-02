package library.pages.elements.webtables;

import library.modules.common.forms.FormsDto;
import library.modules.strategies.FormFillingStrategy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static drivers.Driver.driver;

public class RegistrationFormModal {
    @FindBy(id = "registration-form-modal")
    WebElement registrationFormModalTitle;
    @FindBy(id = "firstName")
    public WebElement firstNameInput;
    @FindBy(id = "lastName")
    public WebElement lastNameInput;
    @FindBy(id = "userEmail")
    public WebElement userEmailInput;
    @FindBy(id = "age")
    public WebElement ageInput;
    @FindBy(id = "salary")
    public WebElement salaryInput;
    @FindBy(id = "department")
    public WebElement departmentInput;
    @FindBy(id = "submit")
    public WebElement submitFormButton;

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

    public RegistrationFormModal fillRegistrationForm(FormFillingStrategy strategy, FormsDto registrationFormData){
        strategy.fillForm(registrationFormData);

        return this;
    }

    public Map<String, String> getRegistrationFormData(){
        Map<String, String> registrationFormData = new HashMap<>();

        registrationFormData.put("firstName", firstNameInput.getAttribute("value"));
        registrationFormData.put("lastName", lastNameInput.getAttribute("value"));
        registrationFormData.put("email", userEmailInput.getAttribute("value"));
        registrationFormData.put("age", ageInput.getAttribute("value"));
        registrationFormData.put("salary", salaryInput.getAttribute("value"));
        registrationFormData.put("department", departmentInput.getAttribute("value"));

        return registrationFormData;
    }

    public WebTablesPage submitForm(){
        submitFormButton.click();

        waitForRegistrationFormModalToClose();

        return new WebTablesPage();
    }

    private void waitForRegistrationFormModalToClose(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .invisibilityOf(registrationFormModalTitle));
    }
}
