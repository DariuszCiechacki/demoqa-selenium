package library.modules.elements.textbox;

import library.pages.elements.TextBoxPage;

public class FillTextBoxForm implements TextBoxFormFillingStrategy {
    private final TextBoxPage textBoxPage;

    public FillTextBoxForm(TextBoxPage textBoxPage) {
        this.textBoxPage = textBoxPage;
    }

    @Override
    public void fillTextBoxForm(TextBoxFormDto textBoxFormDto) {
        textBoxPage.userName.sendKeys(textBoxFormDto.getFullName());
        textBoxPage.userEmail.sendKeys(textBoxFormDto.getEmail());
        textBoxPage.currentAddress.sendKeys(textBoxFormDto.getCurrentAddress());
        textBoxPage.permanentAddress.sendKeys(textBoxFormDto.getPermanentAddress());
    }
}
