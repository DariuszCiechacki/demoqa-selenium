package library.pages.forms;

import library.modules.forms.practiceform.PracticeFormPageElements;
import library.modules.forms.practiceform.StudentRegistrationFormDto;
import library.modules.forms.practiceform.strategies.FillStudentRegistrationFormStrategies;
import org.openqa.selenium.By;
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

    public void fillStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData, FillStudentRegistrationFormStrategies.StrategyType strategyType) {
        new FillStudentRegistrationFormStrategies(strategyType, this).fillForm(studentRegistrationFormData);
    }

    public void chooseRadioOption(String optionValue){
        driver.findElement(By.xpath("//input[@name='gender' and @value='"+optionValue+"']"));
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
}
