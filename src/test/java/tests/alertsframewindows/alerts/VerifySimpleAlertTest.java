package tests.alertsframewindows.alerts;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySimpleAlertTest extends TestCase {
    private final String expectedAlertMessage = "You clicked a button";

    @Test
    public void verifySimpleAlertTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        AlertsPage alertsPage = new SidebarMenu().navigateToAlertsPage();

        boolean alertsPageVisible = alertsPage.waitForAlertsPageContent();
        Assert.assertTrue(alertsPageVisible, "Alerts page is not visible");

        alertsPage.simpleAlertButton.click();

        Assert.assertTrue(alertsPage.waitForAlertToBePresent(),
                "Alert is not present");

        Assert.assertEquals(alertsPage.getAlertMessage(),
                expectedAlertMessage,
                "Incorrect alert message");

        alertsPage.acceptAlert();

        Assert.assertFalse(alertsPage.verifyAlertVisibility(),
                "Alert was not closed");
    }
}
