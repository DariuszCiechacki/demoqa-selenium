package tests.elements;

import library.TestCase;
import library.modules.SidebarMenu;
import library.pages.HomePage;
import library.pages.elements.TextBoxPage;
import org.testng.Assert;

public class FillTextBoxFormTest extends TestCase {

    public void fillTextBoxFormTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToElementsCategory();

        TextBoxPage textBoxPage = new SidebarMenu().navigateToTextBoxPage();

        boolean textBoxPageVisible = textBoxPage.waitForTextBoxPageContent();
        Assert.assertTrue(textBoxPageVisible, "Text box page is not visible");


    }
}
