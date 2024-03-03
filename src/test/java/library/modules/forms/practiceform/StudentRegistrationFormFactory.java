package library.modules.forms.practiceform;

import com.github.javafaker.Faker;

import static library.modules.common.DefaultData.defaultEmail;

public class StudentRegistrationFormFactory {
    public static StudentRegistrationFormDto createEntireStudentRegistrationFormData(String gender, String dateOfBirth,
                                                                               String subjects, String hobbies,
                                                                               String state, String city){
        StudentRegistrationFormDto studentRegistrationFormData = new StudentRegistrationFormDto();
        Faker faker = new Faker();

        studentRegistrationFormData.setFirstName(faker.name().firstName());
        studentRegistrationFormData.setLastName(faker.name().lastName());
        studentRegistrationFormData.setEmail(defaultEmail);
        studentRegistrationFormData.setGender(gender);
        studentRegistrationFormData.setMobileNumber(faker.phoneNumber().phoneNumber());
        studentRegistrationFormData.setDateOfBirth(dateOfBirth);
        studentRegistrationFormData.setSubjects(subjects);
        studentRegistrationFormData.setHobbies(hobbies);
        studentRegistrationFormData.setCurrentAddress(faker.address().fullAddress());
        studentRegistrationFormData.setState(state);
        studentRegistrationFormData.setCity(city);

        return studentRegistrationFormData;
    }

    public static StudentRegistrationFormDto createRequiredStudentRegistrationFormData(String gender){
        StudentRegistrationFormDto studentRegistrationFormData = new StudentRegistrationFormDto();
        Faker faker = new Faker();

        studentRegistrationFormData.setFirstName(faker.name().firstName());
        studentRegistrationFormData.setLastName(faker.name().lastName());
        studentRegistrationFormData.setGender(gender);
        studentRegistrationFormData.setMobileNumber(faker.phoneNumber().subscriberNumber(10));

        return studentRegistrationFormData;
    }
}
