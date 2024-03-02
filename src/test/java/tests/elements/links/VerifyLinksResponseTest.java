package tests.elements.links;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.elements.LinksPage;
import library.pages.elements.TextBoxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLinksResponseTest extends TestCase {

    @Test
    public void verifyLinksResponseTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToElementsCategory();

        LinksPage linksPage = new SidebarMenu().navigateToLinksPage();

        boolean linksPageVisible = linksPage.waitForLinksPageContent();
        Assert.assertTrue(linksPageVisible, "Links page is not visible");


    }
}
