package library.modules.elements.webtables;

import library.modules.elements.textbox.TextBoxFormDto;
import library.pages.elements.webtables.RegistrationFormModal;

public class FillEntireRegistrationFormStrategy implements FillRegistrationFormStrategy {
    @Override
    public void fillRegistrationFormStrategy(RegistrationFormDto registrationFormData) {
        RegistrationFormModal registrationFormModal = new RegistrationFormModal();
        registrationFormModal.firstNameInput.sendKeys(registrationFormData.getFirstName());
        registrationFormModal.lastNameInput.sendKeys(registrationFormData.getLastName());
        registrationFormModal.userEmailInput.sendKeys(registrationFormData.getEmail());
        registrationFormModal.ageInput.sendKeys(registrationFormData.getAge());
        registrationFormModal.salaryInput.sendKeys(registrationFormData.getSalary());
        registrationFormModal.departmentInput.sendKeys(registrationFormData.getDepartment());
    }
}
