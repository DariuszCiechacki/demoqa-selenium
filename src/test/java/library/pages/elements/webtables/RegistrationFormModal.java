package library.pages.elements.webtables;

import library.modules.elements.webtables.FillEntireRegistrationFormStrategy;
import library.modules.elements.webtables.RegistrationFormDto;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static drivers.Driver.driver;

public class RegistrationFormModal {
    public RegistrationFormModal(){
        PageFactory.initElements(driver, this);
    }
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
    
    public RegistrationFormModal clearRegistrationFormData(){
        List<WebElement> filledFields = driver.findElements(By.xpath("//form[@id='userForm']//input"));
        filledFields.forEach(field ->{
            field.sendKeys(Keys.SHIFT, Keys.ARROW_UP);
            field.sendKeys(Keys.BACK_SPACE);
        });

        return this;
    }

    public RegistrationFormModal fillEntireRegistrationFormStrategy(RegistrationFormDto registrationFormData){
        new FillEntireRegistrationFormStrategy().fillRegistrationFormStrategy(registrationFormData);

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
