package library.modules.forms.strategies;

import library.modules.forms.StudentRegistrationFormDto;

public interface StudentRegistrationFormFillingStrategy {
    void fillEntireStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData);
    void fillRequiredStudentRegistrationForm(StudentRegistrationFormDto studentRegistrationFormData);
}
