package tests.elements.webtables.sorting;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.elements.webtables.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortByFirstNameAscTest extends TestCase {

    @Test(description = "Sort table by first name ascending")
    public void sortByFirstNameAscTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible, "Home page is not visible");

        new HomePage().navigateToElementsCategory();

        WebTablesPage webTablesPage = new SidebarMenu().navigateToWebTablesPage();

        boolean webTablesPageVisible = webTablesPage.waitForWebTablesPageContent();
        Assert.assertTrue(webTablesPageVisible,
                "Web tables page is not visible");

        Assert.assertTrue(webTablesPage.tableElement.isDisplayed(),
                "Table is not visible");
        Assert.assertTrue(webTablesPage.countTableRecords() >= 2,
                "Table has less than 2 records");


    }
}
