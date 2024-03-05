package library.modules.forms.practiceform;

import library.modules.common.adapters.DatePickerHandler;
import library.modules.common.adapters.SelectsHandler;
import library.pages.forms.PracticeFormPage;

public class FillEntireStudentRegistrationFormStrategy implements FillStudentRegistrationFormStrategy{
    @Override
    public void fillStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData) {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        practiceFormPage.firstNameInput.sendKeys(studentRegistrationFormData.getFirstName());
        practiceFormPage.lastNameInput.sendKeys(studentRegistrationFormData.getLastName());
        practiceFormPage.userEmailInput.sendKeys(studentRegistrationFormData.getEmail());
        practiceFormPage.chooseRadioOption(studentRegistrationFormData.getGender());
        practiceFormPage.userMobileNumberInput.sendKeys(studentRegistrationFormData.getMobileNumber());
        DatePickerHandler.pickDate(practiceFormPage.dateOfBirthInput, studentRegistrationFormData.getDateOfBirth());
        SelectsHandler.fillSelectAutocompleteMulti(practiceFormPage.subjectsSelect, studentRegistrationFormData.getSubjects());
        practiceFormPage.checkHobbies(studentRegistrationFormData.getHobbies());
        //practiceFormPage.uploadPicture();
        practiceFormPage.currentAddressInput.sendKeys(studentRegistrationFormData.getCurrentAddress());
        practiceFormPage.selectStateAndCity(studentRegistrationFormData.getState(), studentRegistrationFormData.getCity());
    }
}
