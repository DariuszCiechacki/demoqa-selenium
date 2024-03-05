package library.modules.forms.practiceform;

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
        //practiceFormPage.dateOfBirthInput.sendKeys(studentRegistrationFormData.getDateOfBirth());// ToDo
        practiceFormPage.selectSubjects(studentRegistrationFormData.getSubjects());
        //practiceFormPage.checkHobbies(studentRegistrationFormData.getHobbies());
        //practiceFormPage.uploadPicture();
        practiceFormPage.currentAddressInput.sendKeys(studentRegistrationFormData.getCurrentAddress());
        practiceFormPage.selectStateAndCity(studentRegistrationFormData.getState(), studentRegistrationFormData.getCity());
    }
}
