package library.pages.forms;

import library.modules.common.forms.FormsDto;
import library.modules.strategies.FormFillingStrategy;
import library.pages.elements.TextBoxPage;
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
    WebElement firstNameInput;
    @FindBy(id = "lastName")
    WebElement lastNameInput;
    @FindBy(id = "userEmail")
    WebElement userEmailInput;
    @FindBy(id = "userNumber")
    WebElement userNumberInput;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    @FindBy(id = "uploadPicture")
    WebElement uploadPictureButton;
    @FindBy(id = "currentAddress")
    WebElement currentAddressInput;

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

    public PracticeFormPage fillFormWithStrategy(FormFillingStrategy strategy, FormsDto formData) {
        strategy.fillForm(formData);

        return this;
    }
}
