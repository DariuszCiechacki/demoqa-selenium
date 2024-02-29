package tests;

import library.TestCase;
import library.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenHomePageTest extends TestCase {

    @Test
    public void openHomePageTest(){
        Assert.assertTrue(new HomePage().waitForHomePageContent(),
                "Home page is not visible");
    }
}
