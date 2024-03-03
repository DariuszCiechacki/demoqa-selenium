package tests.forms;

import library.TestCase;
import library.modules.common.SidebarMenu;
import library.pages.HomePage;
import library.pages.elements.TextBoxPage;
import library.pages.forms.PracticeFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillEntireStudentRegistrationFormTest extends TestCase {

    @Test
    public void fillEntireStudentRegistrationFormTest(){
        boolean homePageVisible = new HomePage().waitForHomePageContent();
        Assert.assertTrue(homePageVisible,"Home page is not visible");

        new HomePage().navigateToFormsCategory();

        PracticeFormPage practiceFormPage = new SidebarMenu().navigateToPracticeFormPage();

        boolean practiceFormPageVisible = practiceFormPage.waitForPracticeFormPageContent();
        Assert.assertTrue(practiceFormPageVisible, "Practice form page is not visible");
    }
}