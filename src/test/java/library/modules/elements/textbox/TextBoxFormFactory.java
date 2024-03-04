package library.modules.elements.textbox;

import com.github.javafaker.Faker;

import static library.modules.common.DefaultData.defaultEmail;

public class TextBoxFormFactory {
    public static TextBoxFormDto createTextBoxFormData(){
        TextBoxFormDto textBoxFormData = new TextBoxFormDto();
        Faker faker = new Faker();

        textBoxFormData.setFullName(faker.name().fullName());
        textBoxFormData.setEmail(defaultEmail);
        textBoxFormData.setCurrentAddress(faker.address().fullAddress());
        textBoxFormData.setPermanentAddress(faker.address().fullAddress());

        return textBoxFormData;
    }
}
