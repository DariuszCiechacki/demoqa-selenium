package library.pages.elements.webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static drivers.Driver.driver;

public class WebTablesPage {
    public WebTablesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Web Tables']")
    WebElement webTablesPageTitle;
    @FindBy(xpath = "//div[contains(@class,'rt-table')]")
    public WebElement tableElement;
    @FindBy(id = "addNewRecordButton")
    WebElement addNewRecordButton;

    @FindBy(id = "searchBox")
    WebElement searchBoxInput;

    public boolean waitForWebTablesPageContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(webTablesPageTitle));
        }
        catch (TimeoutException exception){
            return false;
        }

        return true;
    }

    public Map<String, Map<String, String>> getWebTableData(){
        Map<String, Map<String, String>> webTableData = new HashMap<>();

        List<WebElement> rowElements = driver.findElements(
                By.xpath("//div[contains(@class,'action-buttons')]//ancestor::div[contains(@class,'rt-tr-group')]"));
        int rowIndex = 0;

        for (WebElement rowElement : rowElements){
            Map<String, String> rowData = new HashMap<>();

            List<WebElement> rowCells = rowElement.findElements(By.xpath(".//div[@role='gridcell']"));

            rowData.put("firstName", rowCells.get(0).getText());
            rowData.put("lastName", rowCells.get(1).getText());
            rowData.put("age", rowCells.get(2).getText());
            rowData.put("email", rowCells.get(3).getText());
            rowData.put("salary", rowCells.get(4).getText());
            rowData.put("department", rowCells.get(5).getText());

            webTableData.put(String.valueOf(rowIndex++), rowData);
        }

        return webTableData;
    }

    public WebTablesPage enterSearchBoxValue(String value){
        searchBoxInput.sendKeys(value);

        return this;
    }

    public RegistrationFormModal navigateToAddNewRecordForm(){
        addNewRecordButton.click();

        return new RegistrationFormModal();
    }

    public RegistrationFormModal navigateToEditRandomRecordForm(){
        List<WebElement> editRecordButtons = driver.findElements(
                By.xpath("//div[contains(@class,'action-buttons')]//span[contains(@id,'edit-record')]"));

        int random = new Random().nextInt(editRecordButtons.size());

        editRecordButtons.get(random).click();

        return new RegistrationFormModal();
    }
}
