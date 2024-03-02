package library.modules.strategies;

import library.modules.common.forms.FormsDto;
import library.pages.elements.TextBoxPage;

public class TextBoxFormFillingStrategy implements FormFillingStrategy{
    private final TextBoxPage textBoxPage;

    public TextBoxFormFillingStrategy(TextBoxPage textBoxPage) {
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