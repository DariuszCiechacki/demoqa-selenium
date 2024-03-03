package library.modules.common;

import library.pages.elements.ButtonsPage;
import library.pages.elements.TextBoxPage;
import library.pages.elements.webtables.WebTablesPage;
import library.pages.forms.PracticeFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static drivers.Driver.driver;

public class SidebarMenu {
    public TextBoxPage navigateToTextBoxPage(){
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Text Box']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Elements");
        }

        categoryName.click();

        return new TextBoxPage();
    }

    public ButtonsPage navigateToButtonsPage(){
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Buttons']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Elements");
        }

        categoryName.click();

        return new ButtonsPage();
    }

    public WebTablesPage navigateToWebTablesPage(){
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Web Tables']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Elements");
        }

        categoryName.click();

        return new WebTablesPage();
    }

    public PracticeFormPage navigateToPracticeFormPage(){
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Practice form']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Forms");
        }

        categoryName.click();

        return new PracticeFormPage();
    }

    private void expandMainCategoryIfNecessary(String mainCategoryText){
        driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='"+mainCategoryText+"']"))
                .click();
    }
}
