package tests.alertsframewindows.modaldialogs;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.ModalDialogsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySmallModalDialogTest extends TestCase {
    private final String smallModalTitleExpectedText = "Small Modal";

    @Test(description = "Open small modal dialog and verify its header")
    public void verifySmallModalDialogTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        ModalDialogsPage modalDialogsPage = new SidebarMenu().navigateToModalDialogsPage();

        boolean modalDialogsPageVisible = modalDialogsPage.waitForModalDialogsPageContent();
        Assert.assertTrue(modalDialogsPageVisible, "Modal dialogs page is not visible");

        modalDialogsPage.showSmallModalButton.click();
        modalDialogsPage.waitForModalDialogContent();

        Assert.assertTrue(modalDialogsPage.verifyModalDialogVisibility(),
                "Small modal is not visible");

        Assert.assertEquals(modalDialogsPage.modalDialogTitle.getText(), smallModalTitleExpectedText,
                "Incorrect small modal dialog title");

        modalDialogsPage.closeSmallModalDialog();

        Assert.assertFalse(modalDialogsPage.verifyModalDialogVisibility(),
                "Small modal was not closed successfully");
    }
}
