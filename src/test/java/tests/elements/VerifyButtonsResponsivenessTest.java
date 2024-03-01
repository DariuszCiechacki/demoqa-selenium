package tests.elements;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.elements.ButtonsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyButtonsResponsivenessTest extends TestCase {
    @Test(description = "Verify double click, right click and dynamic click buttons test")
    public void verifyButtonsResponsivenessTest() {
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible, "Home page is not visible");

        new HomePage().navigateToElementsCategory();

        ButtonsPage buttonsPage = new SidebarMenu().navigateToButtonsPage();

        boolean buttonsPageVisible = buttonsPage.waitForButtonsPageContent();
        Assert.assertTrue(buttonsPageVisible, "Buttons page is not visible");

        Assert.assertTrue(buttonsPage.verifyDoubleClickButton(), "Double click was not performed successfully");
        Assert.assertTrue(buttonsPage.verifyRightClickButton(), "Right click was not performed successfully");
        Assert.assertTrue(buttonsPage.verifyDynamicClickButton(), "Dynamic click was not performed successfully");
    }
}
