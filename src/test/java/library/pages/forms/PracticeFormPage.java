package library.pages.forms;

import library.modules.common.DefaultData;
import library.modules.common.adapters.CheckboxesHandler;
import library.modules.common.adapters.SelectsHandler;
import library.modules.common.adapters.WebDriverActions;
import library.modules.forms.practiceform.FillEntireStudentRegistrationFormStrategy;
import library.modules.forms.practiceform.FillRequiredStudentRegistrationFormStrategy;
import library.modules.forms.practiceform.PracticeFormPageElements;
import library.modules.forms.practiceform.StudentRegistrationFormDto;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        studentRegistrationFormData.put("gender", CheckboxesHandler.getSelectedRadiobuttonLabel());
        studentRegistrationFormData.put("mobileNumber", userMobileNumberInput.getAttribute("value"));
        //studentRegistrationFormData.put("dateOfBirth", dateOfBirthInput.getAttribute("value"));
        studentRegistrationFormData.put("subjects", SelectsHandler.getSelectMultiValues(subjectsSelect));
        studentRegistrationFormData.put("hobbies", CheckboxesHandler.getSelectedCheckboxesLabelsList());
        studentRegistrationFormData.put("currentAddress", currentAddressInput.getAttribute("value"));
        studentRegistrationFormData.put("state", stateSelect.findElement(By.xpath(".//div[contains(@class,'singleValue')]"))
                .getText());
        studentRegistrationFormData.put("city", citySelect.findElement(By.xpath(".//div[contains(@class,'singleValue')]"))
                .getText());

        return studentRegistrationFormData;
    }

    public void chooseRadioOption(String optionValue){
        WebDriverActions.scrollToElementAndClick(driver.findElement(By.xpath(
                "//input[@name='gender' and @value='"+optionValue+"']//following-sibling::label")));
    }

    public void checkHobbies(String... hobbies){
        CheckboxesHandler.setCheckboxes(true, hobbies);
    }

    public void uploadPicture(){
        uploadPictureButton.sendKeys(DefaultData.jpgFilePath);
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
