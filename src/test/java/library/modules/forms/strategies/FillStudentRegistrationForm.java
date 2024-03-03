package library.modules.forms.strategies;

import library.modules.forms.StudentRegistrationFormDto;
import library.pages.forms.PracticeFormPage;

public class FillStudentRegistrationForm implements StudentRegistrationFormFillingStrategy{
    private final StrategyType strategyType;
    public FillStudentRegistrationForm(StrategyType strategyType) {
        this.strategyType = strategyType;
    }

    public enum StrategyType {
        FULL_FORM,
        REQUIRED_FIELDS
    }

    @Override
    public void fillForm(StudentRegistrationFormDto studentRegistrationFormData, PracticeFormPage practiceFormPage) {
        switch (strategyType) {
            case FULL_FORM:
                fillEntireStudentRegistrationForm(studentRegistrationFormData, practiceFormPage);
                break;
            case REQUIRED_FIELDS:
                fillRequiredStudentRegistrationForm(studentRegistrationFormData, practiceFormPage);
                break;
        }
    }

    private void fillEntireStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData, PracticeFormPage practiceFormPage) {
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

    private void fillRequiredStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData, PracticeFormPage practiceFormPage) {
        practiceFormPage.firstNameInput.sendKeys(studentRegistrationFormData.getFirstName());
        practiceFormPage.lastNameInput.sendKeys(studentRegistrationFormData.getLastName());
        practiceFormPage.chooseRadioOption(studentRegistrationFormData.getGender());
        practiceFormPage.userNumberInput.sendKeys(studentRegistrationFormData.getMobileNumber());
    }
}
