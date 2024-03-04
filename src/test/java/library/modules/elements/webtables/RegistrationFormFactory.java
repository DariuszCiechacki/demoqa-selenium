package library.modules.elements.webtables;

import com.github.javafaker.Faker;

import static library.modules.common.DefaultData.defaultEmail;

public class RegistrationFormFactory {
    public static RegistrationFormDto createRegistrationFormData(){
        RegistrationFormDto registrationFormData = new RegistrationFormDto();
        Faker faker = new Faker();

        registrationFormData.setFirstName(faker.name().firstName());
        registrationFormData.setLastName(faker.name().lastName());
        registrationFormData.setEmail(defaultEmail);
        registrationFormData.setAge(String.valueOf(faker.number().numberBetween(1, 99)));
        registrationFormData.setSalary(String.valueOf(faker.number().numberBetween(1, 999999999)));
        registrationFormData.setDepartment(faker.funnyName().name());

        return registrationFormData;
    }
}
