package tests.alertsframewindows.browserwindows;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.BrowserWindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.Driver.driver;

public class VerifyOpeningNewTabTest extends TestCase {
    private String originalWindowHandle;
    private String openedTabWindowHandle;
    private final String expectedOpenedTabHeaderText = "This is a sample page";

    @Test(description = "Switch to opened tab and verify its header")
    public void verifyOpeningNewTabTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        BrowserWindowsPage browserWindowsPage = new SidebarMenu().navigateToBrowserWindowsPage();

        boolean browserWindowsPageVisible = browserWindowsPage.waitForBrowserWindowsPageContent();
        Assert.assertTrue(browserWindowsPageVisible, "Browser windows page is not visible");

        browserWindowsPage.openNewTabButton.click();

        originalWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(browserWindowsPage.getOpenedTabWindowHandle(originalWindowHandle));

        openedTabWindowHandle = driver.getWindowHandle();
        Assert.assertNotEquals(openedTabWindowHandle, originalWindowHandle,
                "Driver did not switch to opened tab window");

        Assert.assertEquals(browserWindowsPage.getNewWindowHeaderText(), expectedOpenedTabHeaderText,
                "Incorrect header of opened tab");
    }
}
