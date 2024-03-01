package library.pages.elements;

import library.modules.common.forms.FormsDto;
import library.modules.elements.textbox.FormFillingStrategy;
import org.openqa.selenium.By;
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

public class TextBoxPage {
    public TextBoxPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Text Box']")
    WebElement textBoxPageTitle;

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement userEmail;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    public WebElement currentAddress;

    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    public WebElement permanentAddress;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(id = "output")
    WebElement formOutputElement;

    public boolean waitForTextBoxPageContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(textBoxPageTitle));
        }
        catch (TimeoutException exception){
            return false;
        }

        return true;
    }

    public TextBoxPage fillFormWithStrategy(FormFillingStrategy strategy, FormsDto formData) {
        strategy.fillForm(formData);

        return this;
    }

    public Map<String, String> getFilledFormData(){
        Map<String, String> formData = new HashMap<>();

        formData.put("name", userName.getAttribute("value"));
        formData.put("email", userEmail.getAttribute("value"));
        formData.put("currentAddress", currentAddress.getAttribute("value"));
        formData.put("permanentAddress", permanentAddress.getAttribute("value"));

        return formData;
    }

    public TextBoxPage submitForm(){
        submitButton.click();
        waitForFormOutput();

        return this;
    }

    public Map<String, String> getOutputFormData(){
        List<WebElement> outputFormElements = formOutputElement.findElements(By.xpath("//p[@id]"));
        Map<String, String> outputFormData = new HashMap<>();

        for (WebElement outputFormElement : outputFormElements){
            String outputFormValue = outputFormElement.getText();
            int lastIndex = outputFormValue.lastIndexOf(":");

            outputFormData.put(outputFormElement.getAttribute("id"), outputFormValue.substring(lastIndex + 1));
        }

        return outputFormData;
    }

    private void waitForFormOutput(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(formOutputElement));
    }
}
