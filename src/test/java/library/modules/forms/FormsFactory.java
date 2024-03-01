package library.modules.forms;

import com.github.javafaker.Faker;

import static library.modules.DefaultData.defaultEmail;

public class FormsFactory {
    public static FormsDto createFormsData(){
        FormsDto formsData = new FormsDto();
        Faker faker = new Faker();

        formsData.setFullName(faker.name().fullName());
        formsData.setEmail(defaultEmail);
        formsData.setCurrentAddress(faker.address().fullAddress());
        formsData.setPermanentAddress(faker.address().fullAddress());

        return formsData;
    }
}
