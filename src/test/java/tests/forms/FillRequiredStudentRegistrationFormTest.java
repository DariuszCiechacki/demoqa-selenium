package tests.forms;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.modules.forms.practiceform.StudentRegistrationFormFactory;
import library.modules.forms.practiceform.strategies.FillStudentRegistrationFormStrategies;
import library.pages.HomePage;
import library.pages.forms.practiceform.PracticeFormPage;
import library.pages.forms.practiceform.SubmittedFormModal;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class FillRequiredStudentRegistrationFormTest extends TestCase {

    @Test(description = "Fill only required fields in student registration form test")
    public void fillRequiredStudentRegistrationFormTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToFormsCategory();

        PracticeFormPage practiceFormPage = new SidebarMenu().navigateToPracticeFormPage();

        boolean practiceFormPageVisible = practiceFormPage.waitForPracticeFormPageContent();
        Assert.assertTrue(practiceFormPageVisible, "Practice form page is not visible");

        practiceFormPage.fillStudentRegistrationForm(
                StudentRegistrationFormFactory.createRequiredStudentRegistrationFormData("Male"),
                FillStudentRegistrationFormStrategies.StrategyType.REQUIRED_FIELDS);

        Map<String, String> studentRegistrationFormData = practiceFormPage.getStudentRegistrationFormData();

        SubmittedFormModal submittedFormModal = practiceFormPage.submitForm();

        boolean submittedFormModalVisible = submittedFormModal.waitForSubmittedFormModalContent();
        Assert.assertTrue(submittedFormModalVisible, "Submitted form modal is not visible");

        System.out.println(studentRegistrationFormData);
        Assert.assertEquals(submittedFormModal.getSubmittedFormData(), studentRegistrationFormData,
                "Incorrect submitted form data");
    }
}