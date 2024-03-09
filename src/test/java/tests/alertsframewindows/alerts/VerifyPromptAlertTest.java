package tests.alertsframewindows.alerts;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyPromptAlertTest extends TestCase {
    private final String expectedAlertMessage = "Please enter your name";
    private final String promptResultPartialText = "You entered ";
    private final String promptText = "promptText";

    @Test(description = "Verify inserting text in prompt alert")
    public void verifyPromptAlertTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        AlertsPage alertsPage = new SidebarMenu().navigateToAlertsPage();

        boolean alertsPageVisible = alertsPage.waitForAlertsPageContent();
        Assert.assertTrue(alertsPageVisible, "Alerts page is not visible");

        alertsPage.promptAlertButton.click();

        Assert.assertTrue(alertsPage.waitForAlertToBePresent(),
                "Alert is not present");

        Assert.assertEquals(alertsPage.getAlertMessage(),
                expectedAlertMessage,
                "Incorrect alert message");

        alertsPage.fillAlertPrompt(promptText);
        alertsPage.acceptAlert();

        Assert.assertEquals(alertsPage.promptResultText.getText(),
                promptResultPartialText + promptText,
                "Incorrect prompt result message");

        Assert.assertFalse(alertsPage.verifyAlertVisibility(),
                "Alert was not closed");
    }
}
