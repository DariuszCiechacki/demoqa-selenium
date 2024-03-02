package library.modules.elements.webtables.form.strategy;

import library.modules.elements.webtables.form.RegistrationFormDto;
import library.pages.elements.webtables.RegistrationFormModal;

public class FillWebTablesRegistrationForm implements RegistrationFormFillingStrategy {
    private final RegistrationFormModal registrationFormModal;

    public FillWebTablesRegistrationForm(RegistrationFormModal registrationFormModal) {
        this.registrationFormModal = registrationFormModal;
    }

    @Override
    public void fillRegistrationForm(RegistrationFormDto registrationFormData) {
        registrationFormModal.firstNameInput.sendKeys(registrationFormData.getFirstName());
        registrationFormModal.lastNameInput.sendKeys(registrationFormData.getLastName());
        registrationFormModal.userEmailInput.sendKeys(registrationFormData.getEmail());
        registrationFormModal.ageInput.sendKeys(registrationFormData.getAge());
        registrationFormModal.salaryInput.sendKeys(registrationFormData.getSalary());
        registrationFormModal.departmentInput.sendKeys(registrationFormData.getDepartment());
    }
}
