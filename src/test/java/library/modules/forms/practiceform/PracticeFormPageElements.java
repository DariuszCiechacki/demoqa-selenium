package library.modules.forms.practiceform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static drivers.Driver.driver;

public class PracticeFormPageElements {
    public PracticeFormPageElements(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Practice Form']")
    protected WebElement practiceFormPageTitle;
    @FindBy(id = "firstName")
    public WebElement firstNameInput;
    @FindBy(id = "lastName")
    public WebElement lastNameInput;
    @FindBy(id = "userEmail")
    public WebElement userEmailInput;
    @FindBy(id = "userNumber")
    public WebElement userMobileNumberInput;
    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;
    @FindBy(id = "subjectsContainer")
    public WebElement subjectsSelect;

    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureButton;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;
    @FindBy(xpath = "//div[@id='state']")
    public WebElement stateSelect;
    @FindBy(xpath = "//div[@id='city']")
    public WebElement citySelect;
    @FindBy(id = "submit")
    public WebElement submitFormButton;
}
