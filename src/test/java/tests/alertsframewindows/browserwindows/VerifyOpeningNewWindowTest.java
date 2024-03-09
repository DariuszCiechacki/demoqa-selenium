package tests.alertsframewindows.browserwindows;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.BrowserWindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.Driver.driver;

public class VerifyOpeningNewWindowTest extends TestCase {
    private String originalWindowHandle;
    private String openedWindowHandle;
    private final String expectedOpenedWindowHeaderText = "This is a sample page";

    @Test(description = "Switch to new window and verify its header")
    public void verifyOpeningNewWindowTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        BrowserWindowsPage browserWindowsPage = new SidebarMenu().navigateToBrowserWindowsPage();

        boolean browserWindowsPageVisible = browserWindowsPage.waitForBrowserWindowsPageContent();
        Assert.assertTrue(browserWindowsPageVisible, "Browser windows page is not visible");

        browserWindowsPage.openNewWindowButton.click();

        originalWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(browserWindowsPage.getOpenedTabWindowHandle(originalWindowHandle));

        openedWindowHandle = driver.getWindowHandle();
        Assert.assertNotEquals(openedWindowHandle, originalWindowHandle,
                "Driver did not switch to opened window");

        Assert.assertEquals(browserWindowsPage.getNewWindowHeaderText(), expectedOpenedWindowHeaderText,
                "Incorrect header of opened window");
    }
}
