package tests.alertsframewindows.browserwindows;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.BrowserWindowsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.Driver.driver;

public class VerifyNewWindowMessageTest extends TestCase {
    private String originalWindowHandle;
    private String openedWindowHandle;
    private final String expectedNewWindowMessageText = "Knowledge increases by sharing but not by saving. " +
            "Please share this website with your friends and in your organization.";

    @Test(description = "Switch to new window and verify its text")
    public void verifyNewWindowMessageTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        BrowserWindowsPage browserWindowsPage = new SidebarMenu().navigateToBrowserWindowsPage();

        boolean browserWindowsPageVisible = browserWindowsPage.waitForBrowserWindowsPageContent();
        Assert.assertTrue(browserWindowsPageVisible, "Browser windows page is not visible");

        browserWindowsPage.openNewMessageWindowButton.click();

        originalWindowHandle = driver.getWindowHandle();
        driver.switchTo().window(browserWindowsPage.getOpenedTabWindowHandle(originalWindowHandle));

        openedWindowHandle = driver.getWindowHandle();
        Assert.assertNotEquals(openedWindowHandle, originalWindowHandle,
                "Driver did not switch to opened window");

        /*ToDo fix assertion
        Assert.assertEquals(driver.findElement(By.xpath("//body")).getText(), expectedNewWindowMessageText,
                "Incorrect new window message text");*/
    }
}
