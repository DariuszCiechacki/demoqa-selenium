package library.modules.strategies;

import library.modules.common.forms.FormsDto;
import library.pages.forms.PracticeFormPage;

public class StudentRegistrationFormFillingStrategy implements FormFillingStrategy{
    private final PracticeFormPage practiceFormPage;

    public StudentRegistrationFormFillingStrategy(PracticeFormPage practiceFormPage) {
        this.practiceFormPage = practiceFormPage;
    }

    @Override
    public void fillForm(FormsDto formsDto) {
        practiceFormPage.firstNameInput.sendKeys(formsDto.getFirstName());
        practiceFormPage.lastNameInput.sendKeys(formsDto.getLastName());
        practiceFormPage.userEmailInput.sendKeys(formsDto.getEmail());
        practiceFormPage.userNumberInput.sendKeys(formsDto.getMobileNumber());
        practiceFormPage.currentAddressInput.sendKeys(formsDto.getCurrentAddress());
    }
}
