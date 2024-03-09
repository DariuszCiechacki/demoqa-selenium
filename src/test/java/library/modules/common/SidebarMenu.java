package library.modules.common;

import library.pages.alertsframesandwindows.*;
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
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Practice Form']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Forms");
        }

        categoryName.click();

        return new PracticeFormPage();
    }

    public AlertsPage navigateToAlertsPage(){
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Alerts']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Alerts, Frame & Windows");
        }

        categoryName.click();

        return new AlertsPage();
    }

    public ModalDialogsPage navigateToModalDialogsPage(){
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Modal Dialogs']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Alerts, Frame & Windows");
        }

        categoryName.click();

        return new ModalDialogsPage();
    }

    public FramesPage navigateToFramesPage(){
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Frames']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Alerts, Frame & Windows");
        }

        categoryName.click();

        return new FramesPage();
    }

    public BrowserWindowsPage navigateToBrowserWindowsPage(){
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Browser Windows']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Alerts, Frame & Windows");
        }

        categoryName.click();

        return new BrowserWindowsPage();
    }

    public NestedFramesPage navigateToNestedFramesPage(){
        WebElement categoryName = driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='Nested Frames']"));
        if (!categoryName.isEnabled()){
            expandMainCategoryIfNecessary("Alerts, Frame & Windows");
        }

        categoryName.click();

        return new NestedFramesPage();
    }

    private void expandMainCategoryIfNecessary(String mainCategoryText){
        driver.findElement(By.xpath("//div[@class='left-pannel']//*[text()='"+mainCategoryText+"']"))
                .click();
    }
}
