package tests.alertsframewindows.alerts;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyConfirmAlertTest extends TestCase {
    private final String acceptAlertStatusText = "You selected Ok";
    private final String dismissAlertStatusText = "You selected Cancel";

    @Test
    public void verifySimpleAlertTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        AlertsPage alertsPage = new SidebarMenu().navigateToAlertsPage();

        boolean alertsPageVisible = alertsPage.waitForAlertsPageContent();
        Assert.assertTrue(alertsPageVisible, "Alerts page is not visible");

        alertsPage.confirmAlertButton.click();

        Assert.assertTrue(alertsPage.waitForAlertToBePresent(),
                "Alert is not present");

        alertsPage.acceptAlert();

        Assert.assertFalse(alertsPage.verifyAlertVisibility(),
                "Alert was not closed");

        Assert.assertEquals(alertsPage.alertConfirmResultText.getText(),
                acceptAlertStatusText,
                "Incorrect alert confirmation message after accepting alert");

        alertsPage.confirmAlertButton.click();

        Assert.assertTrue(alertsPage.waitForAlertToBePresent(),
                "Alert is not present");

        alertsPage.dismissAlert();

        Assert.assertFalse(alertsPage.verifyAlertVisibility(),
                "Alert was not closed");

        Assert.assertEquals(alertsPage.alertConfirmResultText.getText(),
                dismissAlertStatusText,
                "Incorrect alert confirmation message after dismissing alert");
    }
}
