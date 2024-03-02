package library.modules.common.forms;

import com.github.javafaker.Faker;

import static library.modules.common.DefaultData.defaultEmail;

public class FormsFactory {
    public static FormsDto createTextBoxFormData(){
        FormsDto textBoxFormData = new FormsDto();
        Faker faker = new Faker();

        textBoxFormData.setFullName(faker.name().fullName());
        textBoxFormData.setEmail(defaultEmail);
        textBoxFormData.setCurrentAddress(faker.address().fullAddress());
        textBoxFormData.setPermanentAddress(faker.address().fullAddress());

        return textBoxFormData;
    }

    public static FormsDto createRegistrationFormData(){
        FormsDto registrationFormData = new FormsDto();
        Faker faker = new Faker();

        registrationFormData.setFirstName(faker.name().firstName());
        registrationFormData.setLastName(faker.name().lastName());
        registrationFormData.setEmail(defaultEmail);
        registrationFormData.setAge(String.valueOf(faker.number().numberBetween(1, 99)));
        registrationFormData.setSalary(faker.commerce().price());
        registrationFormData.setDepartment(faker.funnyName().name());

        return registrationFormData;
    }
}
