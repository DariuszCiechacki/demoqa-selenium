package library.modules.forms.strategies;

import library.modules.forms.StudentRegistrationFormDto;
import library.pages.forms.PracticeFormPage;

public interface StudentRegistrationFormFillingStrategy {
    void fillForm(StudentRegistrationFormDto studentRegistrationFormData);
}