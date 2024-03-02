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
    @FindBy(id = "created")
    WebElement createdLink;
    @FindBy(id = "no-content")
    WebElement noContentLink;
    @FindBy(id = "moved")
    WebElement movedLink;
    @FindBy(id = "bad-request")
    WebElement badRequestLink;
    @FindBy(id = "unauthorized")
    WebElement unauthorized;
    @FindBy(id = "forbidden")
    WebElement forbiddenLink;
    @FindBy(id = "invalid-url")
    WebElement invalidUrlLink;

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

    public LinksPage clickLink(){
        createdLink.click();

        return this;
    }
}
