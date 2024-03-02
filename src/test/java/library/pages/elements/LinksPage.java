package library.pages.elements;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class LinksPage {
    public LinksPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[text()='Links']")
    WebElement linksPageTitle;

    public boolean waitForLinksPageContent(){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(linksPageTitle));
            return true;
        }
        catch (TimeoutException exception){
            return false;
        }
    }


}
