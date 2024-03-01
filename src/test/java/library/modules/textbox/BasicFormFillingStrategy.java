package library.modules.textbox;

import library.modules.forms.FormsDto;
import library.pages.elements.TextBoxPage;

public class BasicFormFillingStrategy implements FormFillingStrategy{
    private final TextBoxPage textBoxPage;

    public BasicFormFillingStrategy(TextBoxPage textBoxPage) {
        this.textBoxPage = textBoxPage;
    }

    @Override
    public void fillForm(FormsDto formsDto) {
        textBoxPage.userName.sendKeys(formsDto.getFullName());
        textBoxPage.userEmail.sendKeys(formsDto.getEmail());
        textBoxPage.currentAddress.sendKeys(formsDto.getCurrentAddress());
        textBoxPage.permanentAddress.sendKeys(formsDto.getPermanentAddress());
    }
}