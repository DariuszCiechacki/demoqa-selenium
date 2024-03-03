package library.pages.forms.practiceform;

import library.modules.forms.practiceform.PracticeFormPageElements;
import library.modules.forms.practiceform.StudentRegistrationFormDto;
import library.modules.forms.practiceform.strategies.FillStudentRegistrationFormStrategies;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
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

    public void fillStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData, FillStudentRegistrationFormStrategies.StrategyType strategyType) {
        new FillStudentRegistrationFormStrategies(strategyType, this).fillForm(studentRegistrationFormData);
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
        //studentRegistrationFormData.put("state", firstNameInput.getAttribute("value"));
        //studentRegistrationFormData.put("city", firstNameInput.getAttribute("value"));

        return studentRegistrationFormData;
    }

    public void chooseRadioOption(String optionValue){
        driver.findElement(By.xpath("//input[@name='gender' and @value='"+optionValue+"']//following-sibling::label"))
                .click();
    }

    public void selectSubjects(String... subjects){
        for (String subject : subjects){
            driver.findElement(By.xpath(""))
                    .click();
        }
    }

    public void checkHobbies(String... hobbies){
        for (String hobby : hobbies){
            driver.findElement(By.xpath(""))
                    .click();
        }
    }

    public void uploadPicture(){
        uploadPictureButton.sendKeys("");
    }

    public void selectState(String state){

    }

    public void selectCity(String city){

    }

    public SubmittedFormModal submitForm(){
        //new Actions(driver).moveToElement(submitFormButton).click().perform();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitFormButton);
        submitFormButton.click();
        return new SubmittedFormModal();
    }
}
