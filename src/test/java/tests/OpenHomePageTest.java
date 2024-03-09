package tests;

import library.TestCase;
import library.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestCase {

    @Test(description = "Open home page test")
    public void openHomePageTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");
    }
}
