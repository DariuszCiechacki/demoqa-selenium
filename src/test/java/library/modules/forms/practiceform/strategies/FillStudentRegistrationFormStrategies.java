package library.modules.forms.practiceform.strategies;

import library.modules.forms.practiceform.StudentRegistrationFormDto;
import library.pages.forms.practiceform.PracticeFormPage;

public class FillStudentRegistrationFormStrategies implements FillFormStrategy {

    private final StrategyType strategyType;
    private final PracticeFormPage practiceFormPage;

    public FillStudentRegistrationFormStrategies(StrategyType strategyType, PracticeFormPage practiceFormPage) {
        this.strategyType = strategyType;
        this.practiceFormPage = practiceFormPage;
    }

    public enum StrategyType {
        FULL_FORM,
        REQUIRED_FIELDS
    }

    @Override
    public void fillForm(StudentRegistrationFormDto studentRegistrationFormData) {
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
        practiceFormPage.uploadPicture();
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
