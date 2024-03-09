package tests.alertsframewindows.alerts;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTimerAlertTest extends TestCase {
    private final String expectedAlertMessage = "This alert appeared after 5 seconds";

    @Test
    public void verifyTimerAlertTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        AlertsPage alertsPage = new SidebarMenu().navigateToAlertsPage();

        boolean alertsPageVisible = alertsPage.waitForAlertsPageContent();
        Assert.assertTrue(alertsPageVisible, "Alerts page is not visible");

        alertsPage.timerAlertButton.click();

        Assert.assertTrue(alertsPage.waitForAlertToBePresent(),
                "Alert was not present within 5 seconds");

        Assert.assertEquals(alertsPage.getAlertMessage(),
                expectedAlertMessage,
                "Incorrect alert message");

        alertsPage.acceptAlert();

        Assert.assertFalse(alertsPage.verifyAlertVisibility(),
                "Alert was not closed");
    }
}
