package library.modules.elements.textbox;

import library.modules.common.forms.FormsDto;
import library.pages.elements.TextBoxPage;

public class FillEntireTextBoxFormStrategy implements FillTextBoxFormStrategy{
    @Override
    public void fillTextBoxForm(FormsDto formsDto) {
        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage.userName.sendKeys(formsDto.getFullName());
        textBoxPage.userEmail.sendKeys(formsDto.getEmail());
        textBoxPage.currentAddress.sendKeys(formsDto.getCurrentAddress());
        textBoxPage.permanentAddress.sendKeys(formsDto.getPermanentAddress());
    }
}