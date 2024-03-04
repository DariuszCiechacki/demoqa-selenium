package library.pages.forms;

import library.modules.elements.webtables.FillEntireRegistrationFormStrategy;
import library.modules.forms.practiceform.FillEntireStudentRegistrationFormStrategy;
import library.modules.forms.practiceform.FillRequiredStudentRegistrationFormStrategy;
import library.modules.forms.practiceform.PracticeFormPageElements;
import library.modules.forms.practiceform.StudentRegistrationFormDto;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
