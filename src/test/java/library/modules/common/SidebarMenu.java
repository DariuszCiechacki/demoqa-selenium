package library.modules.common;

import library.pages.elements.ButtonsPage;
import library.pages.elements.TextBoxPage;
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

    private void expandMainCategoryIfNecessary(String mainCategoryText){
        driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='"+mainCategoryText+"']"))
                .click();
    }
}
