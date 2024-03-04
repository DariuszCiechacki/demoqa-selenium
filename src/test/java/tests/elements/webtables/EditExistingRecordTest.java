package tests.elements.webtables;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.modules.elements.textbox.TextBoxFormFactory;
import library.modules.elements.webtables.RegistrationFormFactory;
import library.pages.HomePage;
import library.pages.elements.webtables.RegistrationFormModal;
import library.pages.elements.webtables.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.function.Predicate;

public class EditExistingRecordTest extends TestCase {

    @Test(description = "Verify editing existing record")
    public void editExistingRecordTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible, "Home page is not visible");

        new HomePage().navigateToElementsCategory();

        WebTablesPage webTablesPage = new SidebarMenu().navigateToWebTablesPage();

        boolean webTablesPageVisible = webTablesPage.waitForWebTablesPageContent();
        Assert.assertTrue(webTablesPageVisible,
                "Web tables page is not visible");

        Assert.assertTrue(webTablesPage.tableElement.isDisplayed(),
                "Table is not visible");

        RegistrationFormModal registrationFormModal = webTablesPage.navigateToEditRandomRecordForm();

        boolean registrationFormModalVisible = registrationFormModal.waitForRegistrationFormModalContent();
        Assert.assertTrue(registrationFormModalVisible,
                "Registration form modal is not visible");

        registrationFormModal
                .clearRegistrationFormData()
                .fillEntireRegistrationFormStrategy(RegistrationFormFactory.createRegistrationFormData());

        Map<String, String> registrationFormData = registrationFormModal.getRegistrationFormData();

        webTablesPage = registrationFormModal.submitForm();

        Assert.assertTrue(webTablesPage.getWebTableData().values().stream().anyMatch(Predicate.isEqual(registrationFormData)),
                "Incorrect edited record data");
    }
}
