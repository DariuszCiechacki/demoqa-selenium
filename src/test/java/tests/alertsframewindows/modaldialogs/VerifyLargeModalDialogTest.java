package tests.alertsframewindows.modaldialogs;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.ModalDialogsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLargeModalDialogTest extends TestCase {
    private final String largeModalTitleExpectedText = "Large Modal";

    @Test
    public void verifyLargeModalDialogTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        ModalDialogsPage modalDialogsPage = new SidebarMenu().navigateToModalDialogsPage();

        boolean modalDialogsPageVisible = modalDialogsPage.waitForModalDialogsPageContent();
        Assert.assertTrue(modalDialogsPageVisible, "Modal dialogs page is not visible");

        modalDialogsPage.showLargeModalButton.click();
        modalDialogsPage.waitForModalDialogContent();

        Assert.assertTrue(modalDialogsPage.verifyModalDialogVisibility(),
                "Small modal is not visible");

        Assert.assertEquals(modalDialogsPage.modalDialogTitle.getText(), largeModalTitleExpectedText,
                "Incorrect large modal dialog title");

        modalDialogsPage.closeLargeModalDialog();

        Assert.assertFalse(modalDialogsPage.verifyModalDialogVisibility(),
                "Small modal was not closed successfully");
    }
}
