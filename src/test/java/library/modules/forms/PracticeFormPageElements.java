package library.modules.forms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static drivers.Driver.driver;

public abstract class PracticeFormPageElements {
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
    public WebElement userNumberInput;
    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;
    @FindBy(id = "uploadPicture")
    public WebElement uploadPictureButton;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;
}
