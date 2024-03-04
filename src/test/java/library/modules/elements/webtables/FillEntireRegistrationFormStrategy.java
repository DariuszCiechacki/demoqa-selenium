package library.modules.elements.webtables;

import library.modules.common.forms.FormsDto;
import library.pages.elements.webtables.RegistrationFormModal;

public class FillEntireRegistrationFormStrategy implements FillRegistrationFormStrategy {
    @Override
    public void fillRegistrationFormStrategy(FormsDto formsDto) {
        RegistrationFormModal registrationFormModal = new RegistrationFormModal();
        registrationFormModal.firstNameInput.sendKeys(formsDto.getFirstName());
        registrationFormModal.lastNameInput.sendKeys(formsDto.getLastName());
        registrationFormModal.userEmailInput.sendKeys(formsDto.getEmail());
        registrationFormModal.ageInput.sendKeys(formsDto.getAge());
        registrationFormModal.salaryInput.sendKeys(formsDto.getSalary());
        registrationFormModal.departmentInput.sendKeys(formsDto.getDepartment());
    }
}
