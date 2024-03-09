package tests.alertsframewindows;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.alertsframesandwindows.FramesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyFramesTest extends TestCase {
    private final String expectedFrameText = "This is a sample page";

    @Test
    public void verifyFramesTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToAlertsFrameAndWindowsCategory();

        FramesPage framesPage = new SidebarMenu().navigateToFramesPage();

        boolean framesPageVisible = framesPage.waitForFramesPageContent();
        Assert.assertTrue(framesPageVisible, "Frames page is not visible");

        Assert.assertEquals(framesPage.getTextFromFirstFrame(), expectedFrameText,
                "Incorrect first frame text");

        Assert.assertEquals(framesPage.getTextFromSecondFrame(), expectedFrameText,
                "Incorrect second frame text");
    }
}
