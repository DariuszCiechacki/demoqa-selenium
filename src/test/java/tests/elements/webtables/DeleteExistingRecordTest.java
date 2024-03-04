package tests.elements.webtables;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.elements.webtables.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteExistingRecordTest extends TestCase {
    protected int initialTableSize;

    @Test(description = "Verify deleting existing record")
    public void deleteExistingRecordTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible, "Home page is not visible");

        new HomePage().navigateToElementsCategory();

        WebTablesPage webTablesPage = new SidebarMenu().navigateToWebTablesPage();

        boolean webTablesPageVisible = webTablesPage.waitForWebTablesPageContent();
        Assert.assertTrue(webTablesPageVisible,
                "Web tables page is not visible");

        Assert.assertTrue(webTablesPage.tableElement.isDisplayed(),
                "Table is not visible");

        initialTableSize = webTablesPage.countTableRecords();

        Assert.assertTrue(initialTableSize >= 1, "Table has no records");

        webTablesPage.deleteTableRecord();

        Assert.assertEquals(webTablesPage.countTableRecords(), initialTableSize - 1,
                "Table record was not deleted");
    }
}
