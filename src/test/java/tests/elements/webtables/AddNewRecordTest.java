package tests.elements.webtables;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.modules.elements.webtables.RegistrationFormFactory;
import library.pages.HomePage;
import library.pages.elements.webtables.RegistrationFormModal;
import library.pages.elements.webtables.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.function.Predicate;

public class AddNewRecordTest extends TestCase {

    @Test(description = "Verify adding new record")
    public void addNewRecordTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible, "Home page is not visible");

        new HomePage().navigateToElementsCategory();

        WebTablesPage webTablesPage = new SidebarMenu().navigateToWebTablesPage();

        boolean webTablesPageVisible = webTablesPage.waitForWebTablesPageContent();
        Assert.assertTrue(webTablesPageVisible,
                "Web tables page is not visible");

        Assert.assertTrue(webTablesPage.tableElement.isDisplayed(),
                "Table is not visible");

        RegistrationFormModal registrationFormModal = webTablesPage.navigateToAddNewRecordForm();

        boolean registrationFormModalVisible = registrationFormModal.waitForRegistrationFormModalContent();
        Assert.assertTrue(registrationFormModalVisible,
                "Registration form modal is not visible");

        registrationFormModal.fillEntireRegistrationFormStrategy(RegistrationFormFactory.createRegistrationFormData());

        Map<String, String> registrationFormData = registrationFormModal.getRegistrationFormData();

        webTablesPage = registrationFormModal.submitForm();

        Assert.assertTrue(webTablesPage.getWebTableData().values().stream().anyMatch(Predicate.isEqual(registrationFormData)),
                "Incorrect added record data");

        webTablesPage.enterSearchBoxValue(registrationFormData.get("lastName"));

        Assert.assertEquals(webTablesPage.countTableRecords(), 1,
                "Incorrect records number found");

        Assert.assertTrue(webTablesPage.getWebTableData().containsValue(registrationFormData),
                "Incorrect searched record data");
    }
}
