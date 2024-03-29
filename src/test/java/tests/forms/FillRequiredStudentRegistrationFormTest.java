package tests.forms;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.modules.forms.practiceform.StudentRegistrationFormFactory;
import library.pages.HomePage;
import library.pages.forms.PracticeFormPage;
import library.pages.forms.SubmittedFormModal;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class FillRequiredStudentRegistrationFormTest extends TestCase {
    @Test(description = "Fill required fields in student registration form test")
    public void fillRequiredStudentRegistrationFormTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToFormsCategory();

        PracticeFormPage practiceFormPage = new SidebarMenu().navigateToPracticeFormPage();

        boolean practiceFormPageVisible = practiceFormPage.waitForPracticeFormPageContent();
        Assert.assertTrue(practiceFormPageVisible, "Practice form page is not visible");

        practiceFormPage.fillRequiredPracticeForm(StudentRegistrationFormFactory
                .createRequiredStudentRegistrationFormData("Other"));

        Map<String, String> studentRegistrationFormData = practiceFormPage.getRequiredStudentRegistrationFormData();

        SubmittedFormModal submittedFormModal = practiceFormPage.submitForm();

        boolean submittedFormModalVisible = submittedFormModal.waitForSubmittedFormModalContent();
        Assert.assertTrue(submittedFormModalVisible, "Submitted form modal is not visible");

        Assert.assertEquals(submittedFormModal.getRequiredSubmittedFormData(), studentRegistrationFormData,
                "Incorrect submitted form data");
    }
}
