package library.modules.forms.practiceform.strategies;

import library.modules.forms.practiceform.StudentRegistrationFormDto;

public interface FillFormStrategy {
    void fillForm(StudentRegistrationFormDto studentRegistrationFormData);
}