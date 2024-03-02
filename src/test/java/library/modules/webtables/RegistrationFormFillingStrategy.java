package library.modules.webtables;

import library.modules.common.forms.FormsDto;
import library.modules.strategies.FormFillingStrategy;
import library.pages.elements.webtables.RegistrationFormModal;

public class RegistrationFormFillingStrategy implements FormFillingStrategy {
    private final RegistrationFormModal registrationFormModal;

    public RegistrationFormFillingStrategy(RegistrationFormModal registrationFormModal) {
        this.registrationFormModal = registrationFormModal;
    }

    @Override
    public void fillForm(FormsDto formsDto) {
        registrationFormModal.firstNameInput.sendKeys(formsDto.getFirstName());
        registrationFormModal.lastNameInput.sendKeys(formsDto.getLastName());
        registrationFormModal.userEmailInput.sendKeys(formsDto.getEmail());
        registrationFormModal.ageInput.sendKeys(formsDto.getAge());
        registrationFormModal.salaryInput.sendKeys(formsDto.getSalary());
        registrationFormModal.departmentInput.sendKeys(formsDto.getDepartment());
    }
}
