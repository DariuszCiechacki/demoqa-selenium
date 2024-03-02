package library.modules.forms;

import com.github.javafaker.Faker;

import static library.modules.common.DefaultData.defaultEmail;

public class StudentRegistrationFormFactory {
    public static StudentRegistrationFormDto createStudentRegistrationFormData(){
        StudentRegistrationFormDto studentRegistrationFormData = new StudentRegistrationFormDto();
        Faker faker = new Faker();

        studentRegistrationFormData.setFirstName(faker.name().firstName());
        studentRegistrationFormData.setLastName(faker.name().lastName());
        studentRegistrationFormData.setEmail(defaultEmail);
        studentRegistrationFormData.setMobileNumber(faker.phoneNumber().phoneNumber());
        studentRegistrationFormData.setCurrentAddress(faker.address().fullAddress());

        return studentRegistrationFormData;
    }
}
