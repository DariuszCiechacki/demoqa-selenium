package library.modules.strategies;

import library.modules.common.forms.FormsDto;
import library.pages.elements.webtables.RegistrationFormModal;

public class RegistrationFormFillingStrategy implements FormFillingStrategy{
    private final RegistrationFormModal registrationFormModal;

    public RegistrationFormFillingStrategy(RegistrationFormModal registrationFormModal) {
        this.registrationFormModal = registrationFormModal;
    }

    @Override
    public void fillForm(FormsDto formsDto) {
        registrationFormModal.firstName.sendKeys(formsDto.getFirstName());
        registrationFormModal.lastName.sendKeys(formsDto.getLastName());
        registrationFormModal.userEmail.sendKeys(formsDto.getEmail());
        registrationFormModal.age.sendKeys(formsDto.getAge());
        registrationFormModal.salary.sendKeys(formsDto.getSalary());
        registrationFormModal.department.sendKeys(formsDto.getDepartment());
    }
}
