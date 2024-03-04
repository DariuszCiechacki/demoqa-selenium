package library.pages.forms;

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
        driver.findElement(By.xpath("//input[@name='gender' and @value='"+optionValue+"']//following-sibling::label"))
                .click();
    }

    public void selectSubjects(String... subjects){
        for (String subject : subjects){
            subjectsSelect.sendKeys(subject);

            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                    .textToBePresentInElement(subjectsSelect.findElement(By.xpath(
                            "div[contains(@class,'-menu')]")), subject));

            subjectsSelect.sendKeys(Keys.RETURN);
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

    public void selectStateAndCity(String state, String city){
        stateSelect.findElement(By.xpath("//input"))
                .sendKeys(state);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .textToBePresentInElement(stateSelect.findElement(By.xpath(
                        "div[contains(@class,'-menu')]")), state));

        stateSelect.findElement(By.xpath("//input")).sendKeys(Keys.RETURN);

        if(!state.isEmpty()){
            selectCity(city);
        }
    }

    public SubmittedFormModal submitForm(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitFormButton);
        submitFormButton.click();
        return new SubmittedFormModal();
    }

    private void selectCity(String city){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(citySelect));

        citySelect.findElement(By.xpath("//input"))
                .sendKeys(city);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                .textToBePresentInElement(citySelect.findElement(By.xpath(
                        "div[contains(@class,'-menu')]")), city));

        citySelect.findElement(By.xpath("//input")).sendKeys(Keys.RETURN);
    }
}
