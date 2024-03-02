package library.modules.forms.strategies;

import library.modules.forms.StudentRegistrationFormDto;
import library.pages.forms.PracticeFormPage;

public class FillEntireStudentRegistrationForm implements StudentRegistrationFormFillingStrategy {
    private final PracticeFormPage practiceFormPage;

    public FillEntireStudentRegistrationForm(PracticeFormPage practiceFormPage) {
        this.practiceFormPage = practiceFormPage;
    }

    @Override
    public void fillStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData) {
        practiceFormPage.firstNameInput.sendKeys(studentRegistrationFormData.getFirstName());
        practiceFormPage.lastNameInput.sendKeys(studentRegistrationFormData.getLastName());
        practiceFormPage.userEmailInput.sendKeys(studentRegistrationFormData.getEmail());
        practiceFormPage.userNumberInput.sendKeys(studentRegistrationFormData.getMobileNumber());
        practiceFormPage.currentAddressInput.sendKeys(studentRegistrationFormData.getCurrentAddress());
    }
}
