package tests.alertsframewindows;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.NestedFramesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyNestedFramesTest extends TestCase {
    private final String expectedParentFrameText = "Parent frame";
    private final String expectedChildFrameText = "Child Iframe";

    @Test
    public void verifyNestedFramesTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        NestedFramesPage nestedFramesPage = new SidebarMenu().navigateToNestedFramesPage();

        boolean nestedFramesPageVisible = nestedFramesPage.waitForNestedFramesPageContent();
        Assert.assertTrue(nestedFramesPageVisible, "Nested frames page is not visible");

        Assert.assertEquals(nestedFramesPage.getTextFromParentFrame(), expectedParentFrameText,
                "Incorrect parent frame text");

        Assert.assertEquals(nestedFramesPage.getTextFromChildFrame(), expectedChildFrameText,
                "Incorrect child frame text");
    }
}
