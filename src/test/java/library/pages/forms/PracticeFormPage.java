package library.pages.forms;

import library.modules.forms.StudentRegistrationFormDto;
import library.modules.forms.StudentRegistrationFormFillingStrategy;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class PracticeFormPage {
    public PracticeFormPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Practice Form']")
    WebElement practiceFormPageTitle;
    @FindBy(id = "firstName")
    public WebElement firstNameInput;
    @FindBy(id = "lastName")
    public WebElement lastNameInput;
    @FindBy(id = "userEmail")
    public WebElement userEmailInput;
    @FindBy(id = "userNumber")
    public WebElement userNumberInput;
    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;
    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureButton;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;

    public boolean waitForPracticeFormPageContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(practiceFormPageTitle));
        }
        catch (TimeoutException exception){
            return false;
        }

        return true;
    }

    public PracticeFormPage fillStudentRegistrationForm(StudentRegistrationFormFillingStrategy strategy, StudentRegistrationFormDto studentRegistrationFormData) {
        strategy.fillStudentRegistrationForm(studentRegistrationFormData);

        return this;
    }
}
