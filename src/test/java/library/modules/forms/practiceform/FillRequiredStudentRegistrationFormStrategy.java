package library.modules.forms.practiceform;

import library.pages.forms.PracticeFormPage;

public class FillRequiredStudentRegistrationFormStrategy implements FillStudentRegistrationFormStrategy{
    @Override
    public void fillStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData) {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        practiceFormPage.firstNameInput.sendKeys(studentRegistrationFormData.getFirstName());
        practiceFormPage.lastNameInput.sendKeys(studentRegistrationFormData.getLastName());
        practiceFormPage.chooseRadioOption(studentRegistrationFormData.getGender());
        practiceFormPage.userMobileNumberInput.sendKeys(studentRegistrationFormData.getMobileNumber());
    }
}
