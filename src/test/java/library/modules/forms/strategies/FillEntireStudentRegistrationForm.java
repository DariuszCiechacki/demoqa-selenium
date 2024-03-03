package library.modules.forms.strategies;

import library.modules.forms.StudentRegistrationFormDto;
import library.pages.forms.PracticeFormPage;

public class FillEntireStudentRegistrationForm implements StudentRegistrationFormFillingStrategy {
    private final PracticeFormPage practiceFormPage;

    public FillEntireStudentRegistrationForm(PracticeFormPage practiceFormPage) {
        this.practiceFormPage = practiceFormPage;
    }

    @Override
    public void fillEntireStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData) {
        practiceFormPage.firstNameInput.sendKeys(studentRegistrationFormData.getFirstName());
        practiceFormPage.lastNameInput.sendKeys(studentRegistrationFormData.getLastName());
        practiceFormPage.userEmailInput.sendKeys(studentRegistrationFormData.getEmail());
        practiceFormPage.chooseRadioOption(studentRegistrationFormData.getGender());
        practiceFormPage.userNumberInput.sendKeys(studentRegistrationFormData.getMobileNumber());
        practiceFormPage.dateOfBirthInput.sendKeys(studentRegistrationFormData.getDateOfBirth());
        practiceFormPage.selectSubjects(studentRegistrationFormData.getSubjects());
        practiceFormPage.checkHobbies(studentRegistrationFormData.getHobbies());
        practiceFormPage.currentAddressInput.sendKeys(studentRegistrationFormData.getCurrentAddress());
        practiceFormPage.selectState(studentRegistrationFormData.getState());
        practiceFormPage.selectCity(studentRegistrationFormData.getCity());
    }

    @Override
    public void fillRequiredStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData) {
        practiceFormPage.firstNameInput.sendKeys(studentRegistrationFormData.getFirstName());
        practiceFormPage.lastNameInput.sendKeys(studentRegistrationFormData.getLastName());
        practiceFormPage.chooseRadioOption(studentRegistrationFormData.getGender());
        practiceFormPage.userNumberInput.sendKeys(studentRegistrationFormData.getMobileNumber());
    }
}
