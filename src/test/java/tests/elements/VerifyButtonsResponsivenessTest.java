package tests.elements;

import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.elements.ButtonsPage;
import library.pages.elements.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyButtonsResponsivenessTest {
    @Test(description = "Verify double click, right click and dynamic click buttons test")
    public void verifyButtonsResponsivenessTest() {
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible, "Home page is not visible");

        new HomePage().navigateToElementsCategory();

        ButtonsPage buttonsPage = new SidebarMenu().navigateToButtonsPage();

        boolean buttonsPageVisible = buttonsPage.waitForButtonsPageContent();
        Assert.assertTrue(buttonsPageVisible, "Buttons page is not visible");


    }
}
