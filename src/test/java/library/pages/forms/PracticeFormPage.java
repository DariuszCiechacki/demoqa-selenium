package library.pages.forms;

import library.modules.common.adapters.SelectsHandler;
import library.modules.common.adapters.WebDriverActions;
import library.modules.forms.practiceform.FillEntireStudentRegistrationFormStrategy;
import library.modules.forms.practiceform.FillRequiredStudentRegistrationFormStrategy;
import library.modules.forms.practiceform.PracticeFormPageElements;
import library.modules.forms.practiceform.StudentRegistrationFormDto;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static drivers.Driver.driver;

public class PracticeFormPage extends PracticeFormPageElements {
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

    public void fillRequiredPracticeForm(StudentRegistrationFormDto studentRegistrationFormData){
        new FillRequiredStudentRegistrationFormStrategy()
                .fillStudentRegistrationForm(studentRegistrationFormData);
    }

    public void fillEntirePracticeForm(StudentRegistrationFormDto studentRegistrationFormData){
        new FillEntireStudentRegistrationFormStrategy()
                .fillStudentRegistrationForm(studentRegistrationFormData);
    }

    public Map<String, String> getStudentRegistrationFormData(){
        Map<String, String> studentRegistrationFormData = new HashMap<>();

        studentRegistrationFormData.put("firstName", firstNameInput.getAttribute("value"));
        studentRegistrationFormData.put("lastName", lastNameInput.getAttribute("value"));
        studentRegistrationFormData.put("email", userEmailInput.getAttribute("value"));
        //studentRegistrationFormData.put("gender", firstNameInput.getAttribute("value"));
        studentRegistrationFormData.put("mobileNumber", userMobileNumberInput.getAttribute("value"));
        studentRegistrationFormData.put("dateOfBirth", dateOfBirthInput.getAttribute("value"));
        //studentRegistrationFormData.put("subjects", firstNameInput.getAttribute("value"));
        //studentRegistrationFormData.put("hobbies", firstNameInput.getAttribute("value"));
        studentRegistrationFormData.put("currentAddress", currentAddressInput.getAttribute("value"));
        studentRegistrationFormData.put("state", stateSelect.findElement(By.xpath("//div[contains(@class,'singleValue')]"))
                .getText());
        studentRegistrationFormData.put("city", citySelect.findElement(By.xpath("//div[contains(@class,'singleValue')]"))
                .getText());

        return studentRegistrationFormData;
    }

    public void chooseRadioOption(String optionValue){
        WebDriverActions.scrollToElementAndClick(driver.findElement(By.xpath(
                "//input[@name='gender' and @value='"+optionValue+"']//following-sibling::label")));
    }

    public void selectSubjects(String... subjects){
        for (String subject : subjects){
            SelectsHandler.fillSelectAutocompleteMulti(subjectsSelect, subject);
        }
    }

    public void checkHobbies(String... hobbies){
        for (String hobby : hobbies){
            WebElement hobbyCheckbox = driver.findElement(By.xpath("//label[contains(@for,'hobbies') and text()='"+hobby+"']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hobbyCheckbox);
            hobbyCheckbox.click();
        }
    }

    public void uploadPicture(){
        uploadPictureButton.sendKeys("");
    }

    public void selectStateAndCity(String stateName, String cityName){
        SelectsHandler.fillSelectAutocompleteSingle(stateSelect, stateName);

        if(!stateName.isEmpty()){
            selectCity(cityName);
        }
    }

    public SubmittedFormModal submitForm(){
        WebDriverActions.scrollToElementAndClick(submitFormButton);

        return new SubmittedFormModal();
    }

    private void selectCity(String cityName){
        SelectsHandler.fillSelectAutocompleteSingle(citySelect, cityName);
    }
}
