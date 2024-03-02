package tests.elements.webtables.sorting.department;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.modules.webtables.ColumnName;
import library.modules.webtables.SortingType;
import library.pages.HomePage;
import library.pages.elements.webtables.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SortByDepartmentDescTest extends TestCase {

    @Test(description = "Sort table by department descending")
    public void sortByDepartmentDescTest(){
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

        webTablesPage.sortColumn(ColumnName.DEPARTMENT, SortingType.DESC);

        Map<String, Map<String, String>> webTableData = webTablesPage.getWebTableData();

        List<String> firstNameColumnValues = webTableData.values().stream()
                .filter(rowData -> rowData.containsKey("department"))
                .map(rowData -> rowData.get("department"))
                .toList();

        Assert.assertEquals(firstNameColumnValues, firstNameColumnValues.stream().sorted(Comparator.reverseOrder()).toList(),
                "Department column is not sorted in descending order");
    }
}
