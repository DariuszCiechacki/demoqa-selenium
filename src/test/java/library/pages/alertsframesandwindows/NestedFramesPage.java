package library.pages.alertsframesandwindows;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class NestedFramesPage {
    public NestedFramesPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Nested Frames']")
    WebElement nestedFramesPageTitle;
    @FindBy(id = "frame1")
    WebElement parentFrameElement;
    @FindBy(xpath = "//iframe")
    WebElement childFrameElement;

    public boolean waitForNestedFramesPageContent() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(nestedFramesPageTitle));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public String getTextFromParentFrame() {
        driver.switchTo().frame(parentFrameElement);
        String parentFrameText = driver.findElement(By.xpath(".//body")).getText();
        driver.switchTo().defaultContent();

        return parentFrameText;
    }

    public String getTextFromChildFrame() {
        driver.switchTo().frame(parentFrameElement);
        driver.switchTo().frame(childFrameElement);
        String childFrameText = driver.findElement(By.xpath(".//body")).getText();
        driver.switchTo().defaultContent();

        return childFrameText;
    }
}
