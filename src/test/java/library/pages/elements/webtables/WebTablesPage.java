package library.pages.elements.webtables;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class WebTablesPage {
    public WebTablesPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Web Tables']")
    WebElement webTablesPageTitle;

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


}
