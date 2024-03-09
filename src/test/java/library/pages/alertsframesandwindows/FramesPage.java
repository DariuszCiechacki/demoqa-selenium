package library.pages.alertsframesandwindows;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.Driver.driver;

public class FramesPage {
    public FramesPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h1[text()='Frames']")
    WebElement framesPageTitle;
    @FindBy(id = "frame1")
    WebElement firstFrameElement;
    @FindBy(id = "frame2")
    WebElement secondFrameElement;
    @FindBy(id = "sampleHeading")
    WebElement sampleHeadingElement;

    public boolean waitForFramesPageContent() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions
                    .elementToBeClickable(framesPageTitle));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public String getTextFromFirstFrame() {
        driver.switchTo().frame(firstFrameElement);
        String sampleHeadingText = sampleHeadingElement.getText();
        driver.switchTo().defaultContent();

        return sampleHeadingText;
    }

    public String getTextFromSecondFrame() {
        driver.switchTo().frame(secondFrameElement);
        String sampleHeadingText = sampleHeadingElement.getText();
        driver.switchTo().defaultContent();

        return sampleHeadingText;
    }
}
