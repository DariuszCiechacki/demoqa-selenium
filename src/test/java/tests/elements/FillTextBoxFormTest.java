package tests.elements;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.modules.common.forms.FormsFactory;
import library.modules.elements.textbox.BasicFormFillingStrategy;
import library.pages.HomePage;
import library.pages.elements.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class FillTextBoxFormTest extends TestCase {

    @Test(description = "fill all visible fields, get data and compare with output")
    public void fillTextBoxFormTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToElementsCategory();

        TextBoxPage textBoxPage = new SidebarMenu().navigateToTextBoxPage();

        boolean textBoxPageVisible = textBoxPage.waitForTextBoxPageContent();
        Assert.assertTrue(textBoxPageVisible, "Text box page is not visible");

        textBoxPage.fillFormWithStrategy(new BasicFormFillingStrategy(textBoxPage), FormsFactory.createFormsData());
        Map<String, String> formData = textBoxPage.getFilledFormData();

        textBoxPage.submitForm();
        Assert.assertEquals(textBoxPage.getOutputFormData(), formData,
                "Incorrect form data");
    }
}
