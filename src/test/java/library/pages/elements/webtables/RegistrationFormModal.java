package library.pages.elements.webtables;

import library.modules.common.forms.FormsDto;
import library.modules.strategies.FormFillingStrategy;
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

    public WebTablesPage submitForm(){
        submitFormButton.click();

        return new WebTablesPage();
    }

    private void waitForRegistrationFormModalToClose(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .invisibilityOf(registrationFormModalTitle));
    }
}
